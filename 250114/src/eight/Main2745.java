package eight;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 2745 진법 변환
public class Main2745 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        // B진법 수
        String N = input[0]; 
        // 진법
        int B = Integer.parseInt(input[1]); 

        // 10진법으로 변환
        int decimalValue = 0;
        // B^0부터 시작
        int power = 1; 

        // N의 각 자릿수를 오른쪽에서 왼쪽으로 순회
        for (int i = N.length() - 1; i >= 0; i--) {
            char digit = N.charAt(i);

            // 숫자인 경우와 알파벳인 경우 구분
            int value;
            if (Character.isDigit(digit)) {
            	// '0' ~ '9'
                value = digit - '0'; 
            } else {
            	// 'A' ~ 'Z'
                value = digit - 'A' + 10; 
            }

            // 10진법 값 계산
            decimalValue += value * power;
            // 진법의 가중치 증가
            power *= B; 
        }

        System.out.println(decimalValue);
    }
}
