package _12;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 19532 수학은 비대면강의입니다
public class Main19532 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력을 공백으로 구분
        String[] input = br.readLine().split(" ");
        // 첫 번째 방정식의 x의 계수
        int a = Integer.parseInt(input[0]);
        // 첫 번째 방정식의 y의 계수
        int b = Integer.parseInt(input[1]);
        // 첫 번째 방정식의 결과 값
        int c = Integer.parseInt(input[2]);
        // 두 번째 방정식의 x의 계수
        int d = Integer.parseInt(input[3]);
        // 두 번째 방정식의 y의 계수
        int e = Integer.parseInt(input[4]);
        // 두 번째 방정식의 결과 값
        int f = Integer.parseInt(input[5]);
        
        // 크래머의 공식을 이용해 x와 y를 계산
        // 1. 분모를 계산 (두 방정식의 계수를 이용해 행렬식 계산)
        // Denominator(분모) = a*e - b*d
        // 이는 두 방정식의 x와 y 계수를 섞어서 만든 값
        int denominator = a * e - b * d; 
        
        // 2. x를 계산
        // x의 분자는 다음과 같이 계산
        // x = (c*e - b*f) / (a*e - b*d)
        // 여기서 c*e는 첫 번째 방정식의 결과와 두 번째 방정식의 y 계수를 곱한 값
        // b*f는 첫 번째 방정식의 y 계수와 두 번째 방정식의 결과를 곱한 값

        // x 계산을 위한 분자
        int xNumerator = c * e - b * f; 
        // x 값 계산 (분자 / 분모)
        int x = xNumerator / denominator; 

        // 3. y를 계산
        // y의 분자는 다음과 같이 계산
        // y = (a*f - c*d) / (a*e - b*d)
        // 여기서 a*f는 첫 번째 방정식의 x 계수와 두 번째 방정식의 결과를 곱한 값
        // c*d는 첫 번째 방정식의 결과와 두 번째 방정식의 x 계수를 곱한 값
        
        // y 계산을 위한 분자
        int yNumerator = a * f - c * d; 
        // y 값 계산 (분자 / 분모)
        int y = yNumerator / denominator; 

        // x와 y를 공백으로 구분하여 출력
        System.out.println(x + " " + y);
    }
}
