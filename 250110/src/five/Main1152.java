package five;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 1152 단어의 개수
public class Main1152 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // trim : 문자열 양쪽 끝의 공백을 제거
        String input = br.readLine().trim();

        // 공백으로 문자열 나누기
        if (input.isEmpty()) {
        	// 공백만 있는 경우 단어 개수는 0
            System.out.println(0); 
        } else {
            String[] words = input.split(" ");
            // 단어 개수 출력
            System.out.println(words.length); 
        }
    }
}
