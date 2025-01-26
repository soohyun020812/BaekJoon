package _13;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

// 1427 소트인사이드
public class Main1427 {
	public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 숫자를 문자열로 읽음
        String input = reader.readLine();
        
        // 문자열을 문자 배열로 변환
        Character[] digits = new Character[input.length()];
        for (int i = 0; i < input.length(); i++) {
            digits[i] = input.charAt(i);
        }
        
        // 문자 배열을 내림차순으로 정렬
        Arrays.sort(digits, Collections.reverseOrder());
        
        // 정렬된 문자 배열을 StringBuilder에 추가하여 출력
        StringBuilder result = new StringBuilder();
        for (char digit : digits) {
            result.append(digit);
        }
        
        System.out.println(result);
    }
}
