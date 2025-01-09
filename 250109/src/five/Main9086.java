package five;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 9086 문자열
public class Main9086 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 개수 입력
        int T = Integer.parseInt(br.readLine());

        // 각 테스트 케이스 처리
        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            char first = str.charAt(0);
            char last = str.charAt(str.length() - 1);

            System.out.println(first + "" + last);
        }
    }
}
