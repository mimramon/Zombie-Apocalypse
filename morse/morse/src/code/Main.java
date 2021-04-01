/*
* Skeleton Program code for the AQA AS Level Paper 1 2018 examination
* this code should be used in conjunction with the Preliminary Material
* written by the AQA AS Programmer Team
* developed using Netbeans IDE 8.1
*
* Version number: 0.0.4
*/
package code;

import java.io.*;

import javax.lang.model.util.ElementScanner14;

public class Main
{
  static final char SPACE = ' ';
  static final char EOL = '#';
  static final String EMPTYSTRING = "";

  
  static class PartString
  {
    public int i = 0;
    public String string = "";
  }
  
  static void reportError(String s)
  {
    Console.writeLine(String.format("%-5s ", "*") + s + String.format("%6s", "*"));
  }
  
  static String stripLeadingSpaces(String transmission)
  {
    int transmissionLength = transmission.length();
    if (transmissionLength > 0)
    {
      char firstsignal = transmission.charAt(0);
      while (firstsignal == SPACE && transmissionLength > 0)
      {
        transmission = transmission.substring(1);
        transmissionLength -= 1;
        if (transmissionLength > 0)
        {
          firstsignal = transmission.charAt(0);
        }
      }
    }
    if (transmissionLength == 0)
    {
      reportError("No signal received");
    }
    return transmission;
  }
  
  static String stripTrailingSpaces(String transmission)
  {
    int lastChar = transmission.length() - 1;
    while (transmission.charAt(lastChar) == SPACE)
    {
      transmission = transmission.substring(0, lastChar);
      lastChar -= 1;
    }
    return transmission;
  }
  
 static String getTransmission()
  {
    String transmission;
    Console.write("Enter file name: ");
    String fileName = Console.readLine();
    try
    {
      BufferedReader fileHandle = new BufferedReader(new FileReader(fileName));
      transmission = fileHandle.readLine();
      fileHandle.close();
      if (transmission == null) //Added to avoid null pointer exceptions later
      {
        transmission = EMPTYSTRING;
      }
      transmission = stripLeadingSpaces(transmission);
      if (transmission.length() > 0)
      {
        transmission = stripTrailingSpaces(transmission);
        transmission = transmission + EOL;
      }
    }
    catch (Exception e)
    {
      reportError("No transmission found");
      transmission = EMPTYSTRING;
    }
    return transmission;
  }
  
  static PartString getNextSymbol(int i, String transmission)
  {
    PartString partString = new PartString();
    String symbol = EMPTYSTRING;
    
    if (transmission.charAt(i) == EOL)
    {
      Console.writeLine();
      Console.writeLine("End of transmission");
      symbol = EMPTYSTRING;
    }
    else
    {
      int symbolLength = 0;
      char signal = transmission.charAt(i);
      while (signal != SPACE && signal != EOL)
      {
        i += 1;
        signal = transmission.charAt(i);
        symbolLength += 1;
      }
      if (symbolLength == 1)
      {
        symbol = ".";
      }
      else if (symbolLength == 3)
      {
        symbol = "-";
      }
      else if (symbolLength == 0)
      {
        symbol = SPACE + "";
      }
      else
      {
        reportError("Non-standard symbol received");
        symbol = EMPTYSTRING;
      }
    }
    partString.string = symbol;
    partString.i = i;
    return partString;
  }
  
  static PartString getNextLetter(int i, String transmission)
  {
    PartString partString = new PartString();
    PartString symbolString = new PartString();
    symbolString.string = EMPTYSTRING;
    boolean letterEnd = false;
    while (!letterEnd)
    {
      partString = getNextSymbol(i, transmission);
      String symbol = partString.string;
      i = partString.i;
      if (symbol == SPACE + "")
      {
        letterEnd = true;
        i += 4;
      }
      else if (transmission.charAt(i) == EOL)
      {
        letterEnd = true;
      }
      else if (transmission.charAt(i + 1) == SPACE && transmission.charAt(i + 2) == SPACE)
      {
        letterEnd = true;
        i += 3;
      }
      else
      {
        i += 1;
      }
      symbolString.string = symbolString.string + symbol;
      symbolString.i = i;
    }
    return symbolString;
  }
  
  static char decode(String codedLetter, int[] dash, char[] letter, int[] dot)
  {
    int codedLetterLength = codedLetter.length();
    int pointer = 0;
    char symbol;
    for (int i = 0; i < codedLetterLength; i++)
    {
      symbol = codedLetter.charAt(i);
      if (symbol == SPACE)
      {
        return SPACE;
      }
      else if (symbol == '-')
      {
        pointer = dash[pointer];
      }
      else
      {
        pointer = dot[pointer];
      }
    }
    return letter[pointer];
  }
  
  static void receiveMorseCode(int[] dash, char[] letter, int[] dot)
  {
    String plainText = EMPTYSTRING;
    String morseCodeString = EMPTYSTRING;
    String transmission = getTransmission();
    int lastChar = transmission.length() - 1;
    PartString partString = new PartString();
    String codedLetter;
    int i = 0;
    while (i < lastChar)
    {
      partString = getNextLetter(i, transmission);
      i = partString.i;
      codedLetter = partString.string;
      morseCodeString = morseCodeString + SPACE + codedLetter;
      char plainTextLetter = decode(codedLetter, dash, letter, dot);
      plainText = plainText + plainTextLetter;
    }
    Console.writeLine(morseCodeString);
    Console.writeLine(plainText);
  }
  
  static void sendMorseCode(String[] morseCode)
  {
    Console.write("Enter your message (uppercase letters and spaces only): ");
    String plainText = Console.readLine();
    int plainTextLength = plainText.length();
    String morseCodeString = EMPTYSTRING;
    int index;
    try
    {
      for (int i = 0; i < plainTextLength; i++)
      {
        char plainTextLetter = plainText.charAt(i);
        if (plainTextLetter == SPACE)
        {
          index = 0;
        }
        else
        {
          index = (int)plainTextLetter - (int)'A' + 1;
        }
        String codedLetter = morseCode[index];
        morseCodeString = morseCodeString + codedLetter + SPACE;
      }
    }
    catch(Exception e)
    {
      reportError("You entered at least one unsupported character!");
    }
    Console.writeLine(morseCodeString);
    SendSignals(morseCodeString);
  }

  static void SendSignals(String morseCodeString)
  {
    String signal = EMPTYSTRING;
    for(int i = 0; i < morseCodeString.length(); i++)
    {
      if(morseCodeString.charAt(i) == '.')
      {
        signal = signal + "= ";
      }
      else if(morseCodeString.charAt(i) == '-')
      {
        signal = signal + "=== ";
      }
      else if(morseCodeString.charAt(i) == ' ')
      {
        signal = signal + "  ";
      }
    }
    Console.writeLine("the signal is:");
    Console.writeLine("Start:" + signal + ":End");
  }
  
  static void displayMenu()
  {
    Console.writeLine();
    Console.writeLine("Main Menu");
    Console.writeLine("=========");
    Console.writeLine("R - Receive Morse code");
    Console.writeLine("S - Send Morse code");
    Console.writeLine("X - Exit program");
    Console.writeLine();
  }
  
  static char getMenuOption()
  {
    String menuOption = EMPTYSTRING;
    while (menuOption.length() != 1)
    {
      Console.write("Enter your choice: ");
      menuOption = Console.readLine();
    }
    return menuOption.charAt(0);
  }
 
    static void sendReceiveMessages()
  {
    int[] dash = { 20, 23, 0, 0, 24, 1, 0, 17, 0, 21, 0, 25, 0, 15, 11, 0, 0, 0, 0, 22, 13, 0, 0, 10, 0, 0, 0 };
    int[] dot = { 5, 18, 0, 0, 2, 9, 0, 26, 0, 19, 0, 3, 0, 7, 4, 0, 0, 0, 12, 8, 14, 6, 0, 16, 0, 0, 0 };
    char[] letter = { ' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
    String[] morseCode = { " ", ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };
    boolean programEnd = false;
    while (!programEnd)
    {
      displayMenu();
      char menuOption = getMenuOption();
      if (menuOption == 'R')
      {
        receiveMorseCode(dash, letter, dot);
      }
      else if (menuOption == 'S')
      {
        sendMorseCode(morseCode);
      }
      else if (menuOption == 'X')
      {
        programEnd = true;
      }
    }
  }
    public static void main(String[] args) 
    {
      sendReceiveMessages();
    }
    
}
