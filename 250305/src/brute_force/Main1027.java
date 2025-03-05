package brute_force;
import java.io.*;
import java.util.*;

// 1027 고층 건물 
public class Main1027 {
	// 빌딩 개수
	static int N; 
	// 빌딩 높이 배열
	static int[] heights; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 빌딩 개수 입력
        N = Integer.parseInt(br.readLine());
        heights = new int[N];

        // 빌딩 높이 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        // 최대로 보이는 빌딩 개수 저장
        int maxVisibleBuildings = 0; 

        // 모든 빌딩에 대해 보이는 빌딩 개수를 계산
        for (int current = 0; current < N; current++) {
            maxVisibleBuildings = Math.max(maxVisibleBuildings, countVisibleBuildings(current));
        }

        System.out.println(maxVisibleBuildings);
    } 

/*
 * 특정 빌딩에서 보이는 다른 빌딩 개수를 계산하는 함수
 * @param index 현재 빌딩의 인덱스
 * @return 보이는 빌딩 개수
*/
    
    public static int countVisibleBuildings(int index) {
    	// 보이는 빌딩 개수
    	int count = 0; 
    	// 왼쪽 방향 최대 기울기 (초기값 : 무한대)
    	double maxLeftSlope = Double.POSITIVE_INFINITY;  
    	// 오른쪽 방향 최소 기울기 (초기값 : -무한대)
    	double maxRightSlope = Double.NEGATIVE_INFINITY; 

        // 왼쪽 빌딩 탐색 (기울기가 감소해야 함)
        for (int i = index - 1; i >= 0; i--) {
            double slope = calculateSlope(i, index); 
            // 기울기가 더 작아야 보임
            if (slope < maxLeftSlope) { 
                maxLeftSlope = slope;
                count++;
            }
        }

        // 오른쪽 빌딩 탐색 (기울기가 증가해야 함)
        for (int i = index + 1; i < N; i++) {
            double slope = calculateSlope(index, i);
            // 기울기가 더 커야 보임
            if (slope > maxRightSlope) { 
                maxRightSlope = slope;
                count++;
            }
        }

        return count;
    }

/*
 * 두 빌딩 사이의 기울기를 계산하는 함수
 * @param x1 첫 번째 빌딩 인덱스
 * @param x2 두 번째 빌딩 인덱스
 * @return 기울기 값
*/

    private static double calculateSlope(int x1, int x2) {
    
    	return (double) (heights[x2] - heights[x1]) / (x2 - x1);
    }
}

