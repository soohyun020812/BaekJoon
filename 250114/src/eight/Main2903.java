package eight;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 2903 중앙 이동 알고리즘
public class Main2903 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 : 반복 횟수 N
        int N = Integer.parseInt(br.readLine());

        // 점의 개수 계산 : (2^N + 1)^2
        int sideLength = (int) Math.pow(2, N) + 1;
        int totalPoints = sideLength * sideLength;

        System.out.println(totalPoints);
    }
}
