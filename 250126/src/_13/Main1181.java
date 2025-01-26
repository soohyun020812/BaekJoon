package _13;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
// Comparator : 객체를 정렬하기 위한 인터페이스
// 기본 정렬 기준 외에 커스텀 정렬 기준을 정의할 때 사용
import java.util.Comparator;
// LinkedHashSet : 중복을 허용하지 않으면서 삽입 순서를 유지하는 자료구조
import java.util.LinkedHashSet;

// 1181 단어 정렬
public class Main1181 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 번째 줄에서 단어 개수 입력받기
        int n = Integer.parseInt(br.readLine());
        
        // N개의 단어를 배열로 저장
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }
        
        // 중복 제거를 위해 LinkedHashSet 사용 (삽입 순서 유지)
        LinkedHashSet<String> uniqueWords = new LinkedHashSet<>(Arrays.asList(words));
        
        // LinkedHashSet의 요소를 배열로 변환
        String[] uniqueArray = uniqueWords.toArray(new String[0]);
        
        // 정렬 조건 정의 : 길이에서 사전 순
        Arrays.sort(uniqueArray, new Comparator<String>() {
        	// @Override : 어노테이션(Annotation)으로 주로 메서드를 오버라이드 할 때 사용
        	// 부모 클래스나 인터페이스에서 정의된 메서드를 자식 클래스에서 재정의하는 것
            @Override
            public int compare(String word1, String word2) {
                if (word1.length() != word2.length()) {
                	// 길이 순 정렬
                    return word1.length() - word2.length(); 
                }
                // 사전 순 정렬
                return word1.compareTo(word2); 
            }
        });
        
        // 정렬된 단어 출력
        StringBuilder sb = new StringBuilder();
        for (String word : uniqueArray) {
            sb.append(word).append("\n");
        }
        
        System.out.print(sb.toString());
    }
}
