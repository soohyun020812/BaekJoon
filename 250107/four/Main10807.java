package four;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 10807 개수 세기
public class Main10807 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 컴파일러가 특정 종류의 경고를 표시하지 않도록 지시하는 애너테이션
        @SuppressWarnings("unused")
        // 첫째 줄 : 정수의 개수 N 입력
		int n = Integer.parseInt(br.readLine());
        // 둘째 줄 : 공백으로 구분된 N개의 정수 입력
        String[] numbers = br.readLine().split(" ");
        // 셋째 줄 : 찾으려는 정수 v 입력
        int v = Integer.parseInt(br.readLine());
        int count = 0;

        for (String num : numbers) {
            if (Integer.parseInt(num) == v) {
                count++;
            }
        }

        // 결과 출력
        System.out.println(count);
    }
}
