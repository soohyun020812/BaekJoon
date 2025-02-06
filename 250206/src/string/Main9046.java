package string;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
// HashMap : Map 인터페이스를 구현한 구체적인 클래스
// 내부적으로 HashTable을 사용하여 데이터를 저장
import java.util.HashMap;
// Map : 키-값 쌍을 저장하는 자료구조에 대한 규격을 정의한 인터페이스
import java.util.Map;

// 9046 복호화 
public class Main9046 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        // 각 테스트 케이스 처리
        for (int t = 0; t < T; t++) {
            // 각 테스트 케이스마다 암호문 입력 받기 
            String cipherText = br.readLine();
            
            // 빈도수를 저장할 HashMap 
            Map<Character, Integer> frequencyMap = new HashMap<>();
            
            // 암호문에서 공백을 제외한 각 문자의 빈도수를 계산
            for (char ch : cipherText.toCharArray()) {
            	// 공백은 제외
            	if (ch != ' ') {  
            		frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
                }
            }
            
            // 가장 빈번한 문자를 찾기 위한 변수들
            // 가장 빈번하게 나타나는 문자의 빈도수
            int maxFreq = 0; 
            // 가장 빈번하게 나타나는 문자 (초기값은 '?'로 설정)
            char maxChar = '?'; 
            // 동일한 빈도수를 가진 문자가 여러 개 있는지 체크
            boolean duplicate = false; 
            
            // 빈도수 맵을 돌며 최빈값을 찾고, 중복된 빈도수가 있는지 확인
            for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            	// 현재 문자의 빈도수
            	int freq = entry.getValue();  
                
                // 현재 문자의 빈도수가 기존 최빈값보다 크면 새로운 최빈값으로 업데이트
                if (freq > maxFreq) {
                	// 최빈값 업데이트
                    maxFreq = freq;  
                    // 최빈 문자 업데이트
                    maxChar = entry.getKey();  
                    // 중복 없으므로 false로 설정
                    duplicate = false;  
                } 
                // 빈도수가 동일하면 중복 여부 플래그를 true로 설정
                else if (freq == maxFreq) {
                	// 빈도수가 동일한 문자가 있다는 뜻
                	duplicate = true;  
                }
            }
            
            // 중복된 빈도수가 있으면 '?'를 출력
            // 아니면 가장 빈번한 문자를 출력
            System.out.println(duplicate ? '?' : maxChar);
        }

        br.close();
    }
}
