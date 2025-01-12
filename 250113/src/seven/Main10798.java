package seven;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 10798 세로읽기
public class Main10798 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 5개의 단어를 저장
        String[] words = new String[5]; 
        // 가장 긴 단어의 길이 저장
        int maxLength = 0; 

        for (int i = 0; i < 5; i++) {
            words[i] = br.readLine();
            // 최대 길이 갱신
            maxLength = Math.max(maxLength, words[i].length()); 
        }

        StringBuilder sb = new StringBuilder(); 

        // 세로 읽기
        // 최대 길이만큼 반복
        for (int i = 0; i < maxLength; i++) { 
        	// 각 단어에 대해
        	for (int j = 0; j < 5; j++) { 
        		// 글자가 있는 경우에만 읽기
        		if (i < words[j].length()) { 
                    sb.append(words[j].charAt(i));
                }
            }
        }

        System.out.println(sb.toString());
    }
}
