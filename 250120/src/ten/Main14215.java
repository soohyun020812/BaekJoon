package ten;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

// 14215 세 막대
public class Main14215 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int[] sides = new int[3];
        
        // 입력받은 세 막대 길이 저장
        for (int i = 0; i < 3; i++) {
            sides[i] = Integer.parseInt(input[i]);
        }
        
        // 정렬하여 a <= b <= c로 만듦
        Arrays.sort(sides);
        int a = sides[0];
        int b = sides[1];
        int c = sides[2];
        
        // 삼각형 조건을 만족하지 않는 경우, c를 조정
        if (c >= a + b) {
            c = a + b - 1;
        }
        
        // 최대 둘레 계산
        int maxPerimeter = a + b + c;
        
        System.out.println(maxPerimeter);
    }
}
