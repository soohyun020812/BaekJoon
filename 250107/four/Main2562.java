package four;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 2562 최댓값 
public class Main2562 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int max = Integer.MIN_VALUE;
        // 최댓값 위치를 저장할 변수
        int index = -1;
        
        for (int i = 1; i <= 9; i++) {
            int num = Integer.parseInt(br.readLine()); 
         // 현재 숫자가 최댓값보다 클 경우 갱신
            if (num > max) { 
                max = num;
                // 최댓값 위치 저장
                index = i; 
            }
        }
        
        System.out.println(max); 
        System.out.println(index); 
    }
}
