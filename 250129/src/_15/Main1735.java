package _15;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 1735 분수 합
public class Main1735 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 분수 입력 (분자와 분모)
        String[] fraction1 = br.readLine().split(" ");
        // 첫 번째 분수의 분자
        int A1 = Integer.parseInt(fraction1[0]); 
        // 첫 번째 분수의 분모
        int B1 = Integer.parseInt(fraction1[1]); 
        
        // 두 번째 분수 입력 (분자와 분모)
        String[] fraction2 = br.readLine().split(" ");
        // 두 번째 분수의 분자
        int A2 = Integer.parseInt(fraction2[0]); 
        // 두 번째 분수의 분모
        int B2 = Integer.parseInt(fraction2[1]); 
        
        // 분수 합산 : 공통 분모를 구한 후, 분자 계산
        // 두 분수의 합의 분자
        int numerator = A1 * B2 + A2 * B1; 
        // 두 분수의 합의 분모
        int denominator = B1 * B2;
        
        // 분수를 기약분수로 변환
        // 분자와 분모의 최대공약수
        int gcd = gcd(numerator, denominator); 
        // 기약분수의 분자
        numerator /= gcd; 
        // 기약분수의 분모
        denominator /= gcd; 
        
        System.out.println(numerator + " " + denominator);
    }
    
    // 최대공약수를 계산하는 유클리드 호제법
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
