package four;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

// 10818 최소, 최대
public class Main10818 {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 최솟값과 최댓값을 초기화
        int min = Integer.MAX_VALUE; 
        int max = Integer.MIN_VALUE; 

        // 입력된 정수를 순회하면서 최솟값과 최댓값을 계산
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken()); 
            if (num < min) min = num; 
            if (num > max) max = num; 
        }

        System.out.println(min + " " + max);
    }
}
