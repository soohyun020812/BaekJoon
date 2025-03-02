package brute_force;
import java.io.*;
import java.util.*;

// 2309 일곱 난쟁이 
public class Main2309 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 9명의 난쟁이 키 저장
        int[] dwarfs = new int[9]; 
        // 전체 키의 합
        int totalSum = 0; 

        // 9명의 난쟁이 키 입력
        for (int i = 0; i < 9; i++) {
            dwarfs[i] = Integer.parseInt(br.readLine());
            totalSum += dwarfs[i]; // 총합 계산
        }

        // 2명의 난쟁이 찾기 (브루트 포스 알고리즘)
        int fake1 = -1, fake2 = -1;
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
            	// 두 명을 제외했을 때 합이 100인지 확인
                if (totalSum - (dwarfs[i] + dwarfs[j]) == 100) { 
                    fake1 = i;
                    fake2 = j;
                    break;
                }
            }
            
            if (fake1 != -1) break;
        }

        // 7명의 난쟁이 키 리스트 생성 및 정렬
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
        	// 가짜 난쟁이 제외
            if (i != fake1 && i != fake2) { 
                result.add(dwarfs[i]);
            }
        }

        // 오름차순 정렬
        Collections.sort(result); 
        for (int height : result) {

        	System.out.println(height);
        }
    }
}
