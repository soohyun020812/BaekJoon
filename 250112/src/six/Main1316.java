package six;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 1316 그룹 단어 체커
public class Main1316 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 단어 개수 입력
        int N = Integer.parseInt(br.readLine()); 
        // 그룹 단어 개수 초기화
        int groupWordCount = 0; 
        
        for (int i = 0; i < N; i++) {
            String word = br.readLine(); 
            if (isGroupWord(word)) {
            	// 그룹 단어이면 카운트 증가
                groupWordCount++; 
            }
        }
        
        System.out.println(groupWordCount); 
    }

    // 그룹 단어 여부를 확인하는 함수
    public static boolean isGroupWord(String word) {
    	
    	// 알파벳 방문 여부
    	boolean[] visited = new boolean[26]; 
    	// 초기 이전 문자 설정 (빈 문자)
    	char previousChar = '\0'; 
        
        for (int i = 0; i < word.length(); i++) {
        	// 현재 문자
            char currentChar = word.charAt(i); 
            
            // 현재 문자가 이전 문자와 다르면
            if (currentChar != previousChar) {
                // 이미 등장했던 문자라면 그룹 단어가 아님
                if (visited[currentChar - 'a']) {
                    return false;
                }
                // 현재 문자를 방문 처리
                visited[currentChar - 'a'] = true;
                // 이전 문자 갱신
                previousChar = currentChar; 
            }
        }
        // 그룹 단어가 맞음
        return true; 
    }
}
