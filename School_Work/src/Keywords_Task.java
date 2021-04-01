import java.util.*;
import java.io.*;

public class Keywords_Task {
	public static Random rand = new Random(15);
	public static Scanner scan;
	public static Scanner hi = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String keyword[] = new String[15];
		String definitions[] = new String[15];
		String text[] = new String[1000];
		int correct[] = new int[15];
		boolean correctcheck[] = new boolean[15];
		String Ans;
		for (int c = 0; c < 15; c++) {
			correctcheck[c] = false;
		}

		int DefAndKeyRand = rand.nextInt(15);
		int defRand1 = rand.nextInt(15);
		int defRand2 = rand.nextInt(15);
		int layout = rand.nextInt(2);
		try {
			scan = new Scanner(new File("Untitled 1.txt"));
		} catch (IOException ex) {
		}
		for (int a = 0; a < 15; a++) {
			keyword[a] = scan.next();
			definitions[a] = scan.nextLine();

		}
		scan.close();

		for (int i = 0; i < 15; i++) {
			if (i == 15) {
				i = i - 15;
			}
			for (int b = 0; b < 15; b++) {
				if (correct[b] == 2) {
					correctcheck[b] = true;
				}
			}
			if (correctcheck[i] = true) {
				continue;
			}
			defRand2 = rand.nextInt(15);
			defRand1 = rand.nextInt(15);
			while (i == defRand1 || i == defRand2 || defRand1 == defRand2) {
				defRand2 = rand.nextInt(15);
				defRand1 = rand.nextInt(15);
			}

			layout = rand.nextInt(2);
			System.out.println("The keyword is:" + keyword[i]);
			if (layout == 0) {
				System.out.println("Definitions are:\na)" + definitions[i] + "\nb)" + definitions[defRand1] + "\nc)"
						+ definitions[defRand2] + "\n");
				System.out.println("What is the correct answer?\n");
				Ans = hi.nextLine();
				if (Ans.equalsIgnoreCase("a")) {
					System.out.println("Correct");
					correct[i] = correct[i] + 1;
				} else {
					System.out.println("Incorrect");
				}
			} else if (layout == 1) {
				System.out.println("Definitions are:\na)" + definitions[defRand1] + "\nb)" + definitions[i] + "\nc)"
						+ definitions[defRand2] + "\n");
				System.out.println("What is the correct answer?\n");
				Ans = hi.nextLine();
				if (Ans.equalsIgnoreCase("b")) {
					System.out.println("Correct");
					correct[i] = correct[i] + 1;
				} else {
					System.out.println("Incorrect");
				}
			} else if (layout == 2) {
				System.out.println("Definitions are:\na)" + definitions[defRand2] + "\nb)" + definitions[defRand1]
						+ "\nc)" + definitions[i] + "\n");
				System.out.println("What is the correct answer?\n");
				Ans = hi.nextLine();
				if (Ans.equalsIgnoreCase("c")) {
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
