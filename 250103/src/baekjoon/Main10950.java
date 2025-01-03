package baekjoon;
import java.util.Scanner;

// 10950 A+B-3
public class Main10950 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
                
        int[] arr = new int[num];
        
        for(int i=0; i<num; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            
            arr[i]=A+B;
            
        }
        
        for(int i=0; i<num; i++) {
            System.out.println(arr[i]);
        }  
        
        sc.close();
    }
}
