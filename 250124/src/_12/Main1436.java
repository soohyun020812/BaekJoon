package _12;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 1436 영화감독 숌
public class Main1436 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N번째 종말의 수를 찾기 위한 입력값
        int N = Integer.parseInt(br.readLine()); 

        // 현재까지 발견한 종말의 수의 개수
        int count = 0; 
        // 가장 작은 종말의 수부터 시작
        int number = 666; 

        // N번째 종말의 수를 찾기 위한 반복문
        while (true) {
            // 현재 숫자에 '666'이 포함되어 있는지 확인
            if (String.valueOf(number).contains("666")) {
            	// 종말의 수 발견 시 카운트 증가
            	count++; 
            }

            // N번째 종말의 수를 찾으면 반복문 종료
            if (count == N) {
                break;
            }

            // 다음 숫자 확인
            number++; 
        }

        System.out.println(number);
    }
}
