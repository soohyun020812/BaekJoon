package greedy;
import java.io.*;
import java.util.*;

// 21758 꿀 따기 
public class Main21758 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 장소 개수
        int n = Integer.parseInt(br.readLine()); 

        // 각 장소의 꿀 양
        int[] honey = new int[n]; 
        // 누적 합 배열
        int[] prefixSum = new int[n + 1]; 

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            honey[i] = Integer.parseInt(st.nextToken());
            // 누적 합 계산
            prefixSum[i + 1] = prefixSum[i] + honey[i]; 
        }

        int maxHoney = 0;
        // 전체 꿀의 합
        int totalHoney = prefixSum[n]; 

        // 1. 벌통이 맨 오른쪽
        // 벌이 0 ~ n-2 위치 가능
        for (int i = 1; i < n - 1; i++) {
        	// 왼쪽 벌
        	int leftBee = totalHoney - honey[0] - honey[i]; 
        	// 오른쪽 벌
        	int rightBee = totalHoney - prefixSum[i + 1]; 
            maxHoney = Math.max(maxHoney, leftBee + rightBee);
        }

        // 2. 벌통이 맨 왼쪽
        // 벌이 1 ~ n-1 위치 가능
        for (int i = 1; i < n - 1; i++) {
        	// 오른쪽 벌
        	int rightBee = totalHoney - honey[n - 1] - honey[i]; 
        	// 왼쪽 벌
        	int leftBee = prefixSum[i]; 
            maxHoney = Math.max(maxHoney, rightBee + leftBee);
        }

        // 3. 벌통이 가운데 
        // 벌이 양 끝에 있음
        for (int i = 1; i < n - 1; i++) {
            int centerHoney = (prefixSum[i + 1] - honey[0]) + (totalHoney - prefixSum[i] - honey[n - 1]);
            maxHoney = Math.max(maxHoney, centerHoney);
        }

        System.out.println(maxHoney);
    }
}
