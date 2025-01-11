package six;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 1157 단어 공부
public class Main1157 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 대소문자 구분 제거를 위해 대문자로 변환
        String input = br.readLine().toUpperCase();
        // 알파벳 빈도를 저장할 배열
        int[] frequency = new int[26]; 

        // 빈도 계산
        for (int i = 0; i < input.length(); i++) {
            frequency[input.charAt(i) - 'A']++;
        }

        // 최대값 찾기
        int maxCount = 0;
        char maxChar = '?';
        boolean isDuplicate = false;

        for (int i = 0; i < 26; i++) {
            if (frequency[i] > maxCount) {
                maxCount = frequency[i];
                maxChar = (char) (i + 'A');
                // 새로운 최대값이 나왔으므로 중복 상태 초기화
                isDuplicate = false; 
            } else if (frequency[i] == maxCount) { 
            	// 최대값이 여러 개일 경우
                isDuplicate = true; 
            }
        }

        System.out.println(isDuplicate ? "?" : maxChar);
    }
}
