package ten;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 3009 네 번째 점
public class Main3009 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 좌표 입력
        int[] x = new int[3];
        int[] y = new int[3];
        for (int i = 0; i < 3; i++) {
            String[] input = br.readLine().split(" ");
            x[i] = Integer.parseInt(input[0]);
            y[i] = Integer.parseInt(input[1]);
        }
        
        // x좌표 중 한 번만 나타난 값 찾기
        int fourthX = (x[0] == x[1]) ? x[2] : (x[0] == x[2] ? x[1] : x[0]);
        
        // y좌표 중 한 번만 나타난 값 찾기
        int fourthY = (y[0] == y[1]) ? y[2] : (y[0] == y[2] ? y[1] : y[0]);
        
        // 네 번째 점 출력
        System.out.println(fourthX + " " + fourthY);
    }
}
