package eight;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 2869 달팽이는 올라가고 싶다
public class Main2869 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 처리
        String[] input = br.readLine().split(" ");
        // 낮에 올라가는 거리
        int A = Integer.parseInt(input[0]); 
        // 밤에 미끄러지는 거리
        int B = Integer.parseInt(input[1]); 
        // 나무 막대의 높이
        int V = Integer.parseInt(input[2]); 

        // 총 일수 계산
        int days = (V - A + (A - B) - 1) / (A - B) + 1;

        System.out.println(days);
    }
}
