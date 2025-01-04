package baekjoon;
import java.util.Scanner;

// 11021 A+B-7
public class Main11021 {
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for(int i=1; i<=t; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            
            System.out.println("Case #"+i+": "+(A+B));
        }
        
        sc.close();
    }
}
