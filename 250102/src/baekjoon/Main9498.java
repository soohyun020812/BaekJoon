package baekjoon;
import java.util.Scanner;

// 9498 시험 성적
public class Main9498 {
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        
        if(x<=100 && x>=90) {
            System.out.println("A");
        } else if(x<90 && x>=80) {
            System.out.println("B");
        } else if(x<80 && x>=70) {
            System.out.println("C");
        } else if(x<70 && x>=60) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
        
        sc.close();
    }
}
