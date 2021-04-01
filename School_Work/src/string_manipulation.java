import java.util.Scanner;

public class string_manipulation {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Input string you want to reverse.");
		String w = scan.next();
		int i = w.length();
		for (int a = 0; a < i; a++) {
			int c=i-a;
			System.out.print(w.substring(c));
		}
	}
}
