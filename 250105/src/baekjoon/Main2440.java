package baekjoon;
import java.util.Scanner;

//2438 별찍기 3
public class Main2440 {
	public static void main(String[] arga) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=n; i>=1; i--) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		sc.close();
	}
}
