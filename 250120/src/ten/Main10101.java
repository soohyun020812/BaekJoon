package ten;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// 10101 삼각형 외우기
public class Main10101 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int angle1 = Integer.parseInt(br.readLine());
        int angle2 = Integer.parseInt(br.readLine());
        int angle3 = Integer.parseInt(br.readLine());
        
        // 세 각의 합 계산
        int sum = angle1 + angle2 + angle3;
        
        // 조건에 따른 출력
        if (sum != 180) {
            System.out.println("Error");
        } else {
            if (angle1 == 60 && angle2 == 60 && angle3 == 60) {
                System.out.println("Equilateral");
            } else if (angle1 == angle2 || angle2 == angle3 || angle1 == angle3) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        }
    }
}
