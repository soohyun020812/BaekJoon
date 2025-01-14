package eight;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 2292 벌집
public class Main2292 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine()); 
        // 현재 방 번호
        long room = 1; 
        // 껍질 번호 (최소 방 개수)
        long layer = 1; 

        // 껍질 계산
        while (N > room) {
        	// 다음 껍질의 끝 번호
            room += 6 * layer; 
            layer++;
        }

        System.out.println(layer); 
    }
}
