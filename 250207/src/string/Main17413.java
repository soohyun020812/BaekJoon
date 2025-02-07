package string;
import java.io.*;

// 17413 단어 뒤집기 2
public class Main17413 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        
        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();
        // 태그 안인지 확인하는 변수
        boolean inTag = false;  

        for (char c : s.toCharArray()) {
        	// 태그 시작
        	if (c == '<') { 
        		// 단어 뒤집기
                result.append(word.reverse()); 
                // word 초기화
                word.setLength(0); 
                inTag = true;
                result.append(c);
            // 태그 종료
        	} else if (c == '>') { 
                inTag = false;
                result.append(c);
            // 태그 내부는 그대로 출력
        	} else if (inTag) { 
                result.append(c);
            } else {
            	// 공백이면 지금까지의 단어 뒤집고 추가
                if (c == ' ') { 
                    result.append(word.reverse());
                    result.append(c);
                    // 단어 초기화
                    word.setLength(0); 
                // 단어 문자라면 추가
                } else { 
                    word.append(c);
                }
            }
        }

        // 마지막 단어 처리
        result.append(word.reverse());

        System.out.println(result);
    }
}
