package ten;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
// Arrays : 배열을 다루기 위한 다양한 메서드가 포함
import java.util.Arrays;

// 5073 삼각형과 세 변
public class Main5073 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            // 종료 조건
            if (a == 0 && b == 0 && c == 0) break;

            // 변의 길이를 정렬
            int[] sides = {a, b, c};
            Arrays.sort(sides);
            a = sides[0];
            b = sides[1];
            c = sides[2];

            // 삼각형 성립 조건 확인
            if (c >= a + b) {
                sb.append("Invalid").append("\n");
            } else {
                // 삼각형 종류 판별
                if (a == b && b == c) {
                    sb.append("Equilateral").append("\n");
                } else if (a == b || b == c || a == c) {
                    sb.append("Isosceles").append("\n");
                } else {
                    sb.append("Scalene").append("\n");
                }
            }
        }
        
        System.out.print(sb.toString());
    }
}
