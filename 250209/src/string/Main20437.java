package string;
import java.io.*;

// 20437 문자열 게임 2
public class Main20437 {
	static int testCaseCount;
    static StringBuilder resultBuilder = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        testCaseCount = Integer.parseInt(br.readLine()); 
        while(testCaseCount-- > 0) {
            // 문자열 입력
            String inputString = br.readLine(); 
            // K값 입력
            int targetCount = Integer.parseInt(br.readLine()); 
            
            // 각 테스트 케이스 처리
            processTestCase(inputString, targetCount); 
        }
        
        System.out.println(resultBuilder.toString());
    }
    
    private static void processTestCase(String str, int targetCount) {
        if(targetCount == 1) {
            // K가 1일 경우 항상 "1 1" 출력
            resultBuilder.append("1 1").append("\n"); 
            return;
        }
        
        // 알파벳 별 등장 횟수 기록
        int[] alphabetCount = new int[26];
        for(int i = 0; i < str.length(); i++) {
            alphabetCount[str.charAt(i) - 'a']++;
        }
        
        // 최소 길이 초기화
        int minLength = Integer.MAX_VALUE; 
        // 최대 길이 초기화
        int maxLength = -1; 
        
        // 각 문자를 기준으로 K번 등장하는 부분 문자열 찾기
        for(int i = 0; i < str.length(); i++) {
            // 해당 문자가 K번 이상 등장하지 않으면 탐색할 필요 없음
            if(alphabetCount[str.charAt(i) - 'a'] < targetCount)
                continue;
                
            // 첫 번째 문자 등장 횟수 초기화
            int count = 1; 
            
            // 뒷부분 문자열 탐색
            for(int j = i + 1; j < str.length(); j++) {
                if(str.charAt(i) == str.charAt(j))
                    // 같은 문자가 등장할 때마다 카운트 증가
                    count++; 
                    
                // 카운트가 K에 도달한 순간
                if(count == targetCount) {
                    // 최소 길이 갱신
                    minLength = Math.min(minLength, j - i + 1); 
                    // 최대 길이 갱신
                    maxLength = Math.max(maxLength, j - i + 1); 
                    // K번 등장하면 더 이상 뒤로 탐색할 필요 없음
                    break; 
                }
            }
        }
        
        // 조건을 만족하는 부분 문자열이 없다면 -1 출력
        if(minLength == Integer.MAX_VALUE || maxLength == -1) {
            resultBuilder.append("-1").append("\n");
            return;
        }
        
        // 최소 길이와 최대 길이를 출력
        resultBuilder.append(minLength).append(" ").append(maxLength).append("\n");
    }
}
