package baekjoon;
import java.util.Scanner;

// 11022 A+B-8
public class Main11022{
    public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for(int i=1; i<=t; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            
            System.out.println("Case #"+i+": "+A+" + "+B+" = "+(A+B));
        }  
        
        sc.close();
    }
}
