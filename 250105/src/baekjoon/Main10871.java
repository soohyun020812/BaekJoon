package baekjoon;
import java.util.Scanner;

// 10871 X보다 작은 수
public class Main10871 {
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        
        for(int i=0; i<n; i++) {
            int nn = sc.nextInt();
            
            if(nn<x) System.out.print(nn+" ");
        }
        
        sc.close();
    }
}
