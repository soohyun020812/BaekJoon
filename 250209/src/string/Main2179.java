package string;
import java.io.*;

public class Main2179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        // 입력 받을 단어의 개수
        int N = Integer.parseInt(br.readLine()); 
        // 단어들을 저장할 배열
        String[] list = new String[N]; 

        // N개의 단어를 입력받아 배열에 저장
        for (int i = 0; i < N; i++) {
            list[i] = br.readLine();
        }

        // 가장 긴 공통 접두사의 길이를 저장할 변수 (초기값은 -1)
        int max = -1; 
        // 가장 긴 공통 접두사를 가진 첫 번째 단어
        String word1 = ""; 
        // 가장 긴 공통 접두사를 가진 두 번째 단어
        String word2 = ""; 

        // 두 단어를 비교하여 가장 긴 공통 접두사를 찾는 이중 반복문
        for (int i = 0; i < N - 1; i++) { 
        	// 첫 번째 단어 선택
        	String s1 = list[i]; 
        	// 현재 찾은 최대 길이보다 작은 단어는 비교할 필요 없음
            if (s1.length() <= max) continue; 

            for (int j = i + 1; j < N; j++) { 
            	// 두 번째 단어 선택
            	String s2 = list[j]; 
            	// 현재 찾은 최대 길이보다 작은 단어는 비교할 필요 없음
                if (s2.length() <= max) continue; 

                // 두 단어의 공통 접두사 길이 계산
                int prefixLength = getPrefixLength(s1, s2); 

                // 더 긴 공통 접두사를 발견하면 갱신
                if (prefixLength > max) {
                    max = prefixLength;
                    // 첫 번째 단어 저장
                    word1 = s1; 
                    // 두 번째 단어 저장
                    word2 = s2; 
                }
            }
        }

        System.out.println(word1);
        System.out.println(word2);
    }
    
    // 두 문자열의 공통 접두사 길이를 계산하는 메서드
    static int getPrefixLength(String a, String b) {
    	// 두 문자열 중 더 짧은 길이만큼 비교
        int length = Math.min(a.length(), b.length()); 
        // 공통 접두사 길이 카운트
        int cnt = 0; 
        // 두 단어가 같을 때까지 비교
        while (cnt < length && a.charAt(cnt) == b.charAt(cnt)) { 
            cnt++; 
        }
        // 공통 접두사의 길이 반환
        return cnt; 
    }
}

/* 이전 코드는 틀린 코드
 * 단어 순서 유지 방식의 차이점
 * 이전 코드 : 단어 리스트를 사전순으로 정렬 
 * Collections.sort(words) 이 과정에서 단어의 원래 순서가 변경
 * 현재 코드 : 입력된 순서를 유지한 채로 이중 반복문을 사용
 * for (int i = 0; i < N - 1; i++) { for (int j = i + 1; j < N; j++) {
 * 
 * 공통 접두사 비교 방식의 차이점
 * 이전 코드 : 해시맵(prefixMap)을 사용하여 공통 접두사가 같은 단어들을 그룹화
 * 이는 입력된 순서가 아니라 사전순 기준이므로 정답이 달라질 수 있음
 * 현재 코드 : 공통 접두사 길이를 비교하여 최댓값 갱신
 * if (prefixLength > max) { max = prefixLength; word1 = s1; word2 = s2; }
 */