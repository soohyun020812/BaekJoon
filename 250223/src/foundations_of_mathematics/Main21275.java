package foundations_of_mathematics;
import java.io.*;
import java.util.*;

// 21275 폰 호석만 
public class Main21275 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // A진법으로 표현된 X
        String aStr = st.nextToken(); 
        // B진법으로 표현된 X
        String bStr = st.nextToken(); 

        List<long[]> results = new ArrayList<>();

        // 가능한 모든 A, B를 탐색
        // A와 B는 2 이상 36 이하의 값, 서로 다른 값을 가져야 함
        for (int A = 2; A <= 36; A++) {
            // A진법에서 X를 10진수로 변환
            Long xA = convertToDecimal(aStr, A);
            // 유효하지 않으면 무시
            if (xA == null) continue; 

            for (int B = 2; B <= 36; B++) {
            	// A와 B는 달라야 함
            	if (A == B) continue; 

                // B진법에서 X를 10진수로 변환
                Long xB = convertToDecimal(bStr, B);
                if (xB == null) continue;

                // 같은 X인지 확인
                if (xA.equals(xB)) {
                    results.add(new long[]{xA, A, B});
                }
            }
        }

        if (results.size() == 1) {
            // 유일한 경우 출력
            System.out.println(results.get(0)[0] + " " + results.get(0)[1] + " " + results.get(0)[2]);
        } else if (results.size() > 1) {
            // 여러 개의 경우
            System.out.println("Multiple");
        } else {
            // 가능한 경우가 없는 경우
            System.out.println("Impossible");
        }
    }

    // 진법 문자열을 10진수로 변환하는 함수
    public static Long convertToDecimal(String str, int base) {
        long result = 0;
        for (char c : str.toCharArray()) {
            int digit = Character.isDigit(c) ? c - '0' : c - 'a' + 10;
            // 진법 범위를 벗어남
            if (digit >= base) return null; 
            // overflow 방지
            if (result > (Long.MAX_VALUE - digit) / base) return null; 
            result = result * base + digit;
        }
        
        return result;
    }
}
