package foundations_of_mathematics;
import java.util.*;

// 22864 피로도 
public class Main22864 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // A : 한 시간 일할 때 쌓이는 피로도
        // B : 한 시간 일할 때 처리하는 일
        // C : 한 시간 쉴 때 감소하는 피로도
        // M : 최대 피로도 한계
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int M = sc.nextInt();

        // 현재 피로도
        int fatigue = 0; 
        // 처리한 일의 양
        int workDone = 0; 
        
        // 하루는 24시간
        for (int i = 0; i < 24; i++) { 
        	// 피로도가 한계를 넘지 않으면 일하기
            if (fatigue + A <= M) { 
                fatigue += A;
                workDone += B;
            // 피로도가 한계를 넘으면 쉼
            } else { 
            	// 피로도를 C만큼 줄이되 음수 방지
                fatigue = Math.max(0, fatigue - C); 
            }
        }
        
        // 하루 동안 최대 처리한 일 출력
        System.out.println(workDone); 
    }
}
