import java.util.*;
import java.io.*;

public class biology_keywords_program {
	public static Random rand = new Random(15);
	public static Scanner scan;
	public static Scanner hi = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String keywords[] = new String[15];
		String definitions[] = new String[15];
		String text[] = new String[100000];
		int correct[] = new int[15];
		String PlayerAns;

		int DefAndKeyRand = rand.nextInt(15);
		int defRand1 = rand.nextInt(15);
		int defRand2 = rand.nextInt(15);
		int layout = rand.nextInt(2);
		try {
			scan = new Scanner(new File("text.txt"));
		} catch (IOException ex) {
		}
		for (int a = 0; a < 15; a++) {
			keywords[a] = scan.nextLine();
			definitions[a] = scan.nextLine();
		}
		scan.close();

		for (int i = 0; i < 15; i++) {
			if (i == 15) {
				i = i - 15;
			}
			//for(int b=0;b<15;b++) {
           // if(correct[b]==2) {correctcheck[b]=true;}
			//}
			if (correct[i] == 2) {
				continue;
			}
			defRand2 = rand.nextInt(15);
			defRand1 = rand.nextInt(15);
			while (i == defRand1 || i == defRand2 || defRand1 == defRand2) {
				defRand2 = rand.nextInt(15);
				defRand1 = rand.nextInt(15);
			}

			layout = rand.nextInt(2);
			System.out.println("The keyword is:" + keywords[i]);
			if (layout == 0) {
				System.out.println("Definitions are:\na)" + definitions[i] + "\nb)" + definitions[defRand1] + "\nc)"
						+ definitions[defRand2] + "\n");
				System.out.println("What is the correct answer?\n");
				PlayerAns = hi.nextLine();
				if (PlayerAns.equalsIgnoreCase("a")) {
					System.out.println("Correct");
					correct[i] = correct[i] + 1;
				} else {
					System.out.println("Incorrect");
				}
			} else if (layout == 1) {
				System.out.println("Definitions are:\na)" + definitions[defRand1] + "\nb)" + definitions[i] + "\nc)"
						+ definitions[defRand2] + "\n");
				System.out.println("What is the correct answer?\n");
				PlayerAns = hi.nextLine();
				if (PlayerAns.equalsIgnoreCase("b")) {
					System.out.println("Correct");
					correct[i] = correct[i] + 1;
				} else {
					System.out.println("Incorrect");
				}
			} else if (layout == 2) {
				System.out.println("Definitions are:\na)" + definitions[defRand2] + "\nb)" + definitions[defRand1]
						+ "\nc)" + definitions[i] + "\n");
				System.out.println("What is the correct answer?\n");
				PlayerAns = hi.nextLine();
				if (PlayerAns.equalsIgnoreCase("c")) {
					System.out.println("Correct");
					correct[i] = correct[i] + 1;
				} else {
					System.out.println("Incorrect");
				}
			}
			i = i++;
		}
		System.out.println("congratulations you have finished");
	}
}
