package five;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 10809 알파벳 찾기
public class Main10809 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        // a부터 z까지 순회하며 위치 확인
        StringBuilder result = new StringBuilder();
        for (char c = 'a'; c <= 'z'; c++) {
            result.append(S.indexOf(c)).append(" ");
        }

        System.out.println(result.toString().trim());
    }
}
