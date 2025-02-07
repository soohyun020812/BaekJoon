package string;
import java.io.*;
import java.util.*;

// 1213 팰린드롬 만들기 
public class Main1213 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        
        // A~Z의 등장 횟수 저장
        int[] freq = new int[26]; 
        for (char c : name.toCharArray()) {
            freq[c - 'A']++;
        }

        int oddCount = 0;
        // 홀수 개수의 문자가 하나 있을 경우 저장
        char oddChar = 0;  
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                oddCount++;
                oddChar = (char) (i + 'A');
            }
        }

        // 홀수 개 등장하는 문자가 2개 이상이면 팰린드롬 불가능
        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        // 사전순으로 앞서는 팰린드롬 만들기
        StringBuilder half = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < freq[i] / 2; j++) {
            	// 절반만 저장 (팰린드롬은 좌우 절반이 서로 대칭)
            	half.append((char) (i + 'A')); 
            }
        }

        // 팰린드롬 만들기
        StringBuilder result = new StringBuilder(half);
        if (oddCount == 1) {
        	// 중간에 홀수 문자가 올 경우 추가
            result.append(oddChar); 
        }
        // 절반을 뒤집어서 붙이기
        result.append(half.reverse()); 

        System.out.println(result);
    }
}
