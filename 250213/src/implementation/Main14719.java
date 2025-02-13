package implementation;
import java.io.*;
import java.util.*;

// 14719 빗물 
public class Main14719 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] height = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getTrappedWater(H, W, height));
    }

    public static int getTrappedWater(int H, int W, int[] height) {
    	// 블록이 2개 이하이면 물이 고일 수 없음
    	if (W < 3) return 0;  

        int[] leftMax = new int[W];
        int[] rightMax = new int[W];

        // 왼쪽에서부터 최대 높이 계산
        leftMax[0] = height[0];
        for (int i = 1; i < W; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // 오른쪽에서부터 최대 높이 계산
        rightMax[W - 1] = height[W - 1];
        for (int i = W - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // 물의 양 계산
        int totalWater = 0;
        for (int i = 0; i < W; i++) {
            totalWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return totalWater;
    }
}
