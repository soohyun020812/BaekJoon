package string;
import java.io.*;

// 1515 수 이어 쓰기 
public class Main1515 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 지워지고 남은 숫자 문자열
        String target = br.readLine(); 

        // target 문자열의 현재 위치
        int targetIndex = 0; 
        // 1부터 증가할 숫자
        int number = 0; 

        while (true) {
        	// 숫자를 1부터 증가
            number++; 
            // 숫자를 문자열로 변환
            String numStr = String.valueOf(number); 

            // 현재 숫자의 각 문자와 target을 비교하여 일치하는 문자가 있으면 targetIndex 증가
            for (int i = 0; i < numStr.length(); i++) {
                if (numStr.charAt(i) == target.charAt(targetIndex)) {
                    targetIndex++;
                }
                // target 문자열이 전부 매칭되었을 경우 최소 N을 출력하고 종료
                if (targetIndex == target.length()) {
                    System.out.println(number);
                    return;
                }
            }
        }
    }
}

/* 이전 코드는 메모리 초과로 실패함
 * 접근 방식의 차이점
 * 이전 코드 : StringBuilder를 사용해 1부터 N까지 숫자를 이어붙이는 방식
 * 현재 코드 : number를 1부터 증가시키며 target 문자열을 순차적으로 부분 문자열로 포함하는 지 확인
 * 
 * 시간 복잡도 차이점
 * 이전 코드 : StringBuilder는 계속 증가하며 contains() 연산이 반복적으로 수행됨
 * 현재 코드 : number를 1부터 증가시키면서 target과 매칭되도록 탐색
 */