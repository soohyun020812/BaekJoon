package sw;
import java.io.*;
import java.util.*;

// 15686 치킨 배달 
public class Main15686 {
	static int N, M;
    static List<int[]> houseList = new ArrayList<>();
    static List<int[]> chickenList = new ArrayList<>();
    static int minChickenDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 도시 정보 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) houseList.add(new int[]{i, j});
                if (val == 2) chickenList.add(new int[]{i, j});
            }
        }

        // M개의 치킨집을 선택하는 모든 경우의 수 탐색
        selectChicken(0, 0, new ArrayList<>());

        System.out.println(minChickenDistance);
    }

    // 백트래킹을 이용한 치킨집 선택
    static void selectChicken(int index, int count, List<int[]> selected) {
        if (count == M) {
            minChickenDistance = Math.min(minChickenDistance, calculateChickenDistance(selected));
            
            return;
        }
        if (index == chickenList.size()) return;

        // 현재 치킨집을 선택하는 경우
        selected.add(chickenList.get(index));
        selectChicken(index + 1, count + 1, selected);
        selected.remove(selected.size() - 1);

        // 현재 치킨집을 선택하지 않는 경우
        selectChicken(index + 1, count, selected);
    }

    // 도시의 치킨 거리 계산
    static int calculateChickenDistance(List<int[]> selected) {
        int totalDistance = 0;

        for (int[] house : houseList) {
            int minDist = Integer.MAX_VALUE;
            for (int[] chicken : selected) {
                int distance = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                minDist = Math.min(minDist, distance);
            }
            totalDistance += minDist;
        }

        return totalDistance;
    }
}
