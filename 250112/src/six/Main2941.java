package six;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 2941 크로아티아 알파벳
public class Main2941 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        // 크로아티아 알파벳 배열
        String[] croatiaAlphabets = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        // 크로아티아 알파벳 치환
        for (String alphabet : croatiaAlphabets) {
        	// 크로아티아 알파벳을 *로 치환
            input = input.replace(alphabet, "*"); 
        }

        // 남은 문자열의 길이 == 크로아티아 알파벳 개수
        System.out.println(input.length());
    }
}
