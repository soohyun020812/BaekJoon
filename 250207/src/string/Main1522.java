package string;
import java.io.*;

// 1522 문자열 교환
public class Main1522 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 주어진 문자열
		String str = br.readLine(); 
		// 문자열 길이
        int n = str.length(); 
        
        // 문자열에서 a의 개수를 셈
        int a_count = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'a') {
                a_count++;
            }
        }

        // 최소 교환 횟수를 저장할 변수
        int minSwapCount = Integer.MAX_VALUE;

        // 원형 문자열을 처리하기 위해 문자열을 두 번 이어 붙임
        String doubledString = str + str;

        // 슬라이딩 윈도우로 길이가 a_count인 구간을 살펴봄
        for (int i = 0; i < n; i++) {
            int b_count = 0;
            
            // i부터 i+a_count까지의 구간에서 b의 개수를 셈
            for (int j = i; j < i + a_count; j++) {
                if (doubledString.charAt(j) == 'b') {
                    b_count++;
                }
            }
            
            // 구간에서 b의 개수가 교환 횟수이므로 최소값 갱신
            minSwapCount = Math.min(minSwapCount, b_count);
        }

        System.out.println(minSwapCount);
    }
}
