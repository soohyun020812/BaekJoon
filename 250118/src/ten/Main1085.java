package ten;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 1085  직사각형에서 탈출
public class Main1085 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        int w = Integer.parseInt(input[2]);
        int h = Integer.parseInt(input[3]);
        
        // 각 경계선까지의 거리 계산
        // 왼쪽 경계선까지의 거리
        int distanceToLeft = x;
        // 오른쪽 경계선까지의 거리
        int distanceToRight = w - x;
        // 아래쪽 경계선까지의 거리
        int distanceToBottom = y;
        // 위쪽 경계선까지의 거리
        int distanceToTop = h - y; 
        
        // 최소 거리 계산
        int minDistance = Math.min(Math.min(distanceToLeft, distanceToRight),
        							Math.min(distanceToBottom, distanceToTop));
        
        System.out.println(minDistance);
    }
}
