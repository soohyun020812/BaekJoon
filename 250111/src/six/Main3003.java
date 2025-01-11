package six;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 3003 킹, 퀸, 룩, 비숍, 나이트, 폰
public class Main3003 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 체스의 올바른 흰색 피스 개수
        int[] correctSet = {1, 1, 2, 2, 2, 8};

        // 현재 흰색 피스 개수 입력받기
        String[] input = br.readLine().split(" ");
        int[] currentSet = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            currentSet[i] = Integer.parseInt(input[i]);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < correctSet.length; i++) {
            result.append(correctSet[i] - currentSet[i]).append(" ");
        }

        System.out.println(result.toString().trim());
    }
}
