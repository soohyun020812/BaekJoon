package greedy;
import java.io.*;
import java.util.*;

// 2212 센서 
public class Main2212 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        
        int[] sensors = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }
        
        // 센서 위치 정렬
        Arrays.sort(sensors);

        // 센서 간 거리 차이 저장
        int[] diffs = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            diffs[i] = sensors[i + 1] - sensors[i];
        }

        // 거리 차이 정렬
        // 큰 값부터 제거하기 위해 내림차순
        Arrays.sort(diffs);

        // 가장 큰 K-1개의 구간을 제거 
        // 나머지 거리의 합 계산
        int minTotalLength = 0;
        for (int i = 0; i < n - k; i++) {
            minTotalLength += diffs[i];
        }

        System.out.println(minTotalLength);
    }
}
