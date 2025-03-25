package sw;
import java.util.*;

// 17140 이차원 배열과 연산 
public class Main17140 {
	static int r, c, k;
	// 최대 크기 100x100
    static int[][] A = new int[101][101]; 
    // 초기 배열 크기 
    static int rowSize = 3, colSize = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 목표 위치 r
        r = sc.nextInt();
        // 목표 위치 c
        c = sc.nextInt();
        // 목표 값 k
        k = sc.nextInt();
        
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        // 초기 3x3 배열 입력 받기
        System.out.println(solve());
        sc.close();
    }

    // 연산을 수행하여 최소 시간을 찾는 함수
    static int solve() {
    	// 100초 초과 시 종료
        for (int time = 0; time <= 100; time++) {
        	// 목표 값이 되면 반환
        	if (A[r][c] == k) return time;
        	// 행의 개수가 크거나 같다면 R 연산
        	if (rowSize >= colSize) ROperation();
        	// 열의 개수가 더 크다면 C 연산
        	else COperation();
        }
        
        // 100초 내에 조건을 만족하지 못하면 -1 반환
        return -1;
    }

    // R 연산 : 각 행을 정렬하여 변환
    static void ROperation() {
        int maxCol = 0;
        int[][] newA = new int[101][101];
        
        for (int i = 1; i <= rowSize; i++) {
        	// 숫자 개수 저장
        	Map<Integer, Integer> countMap = new HashMap<>(); 
        	// (숫자, 등장 횟수) 리스트
        	List<int[]> sortedList = new ArrayList<>(); 
            
            for (int j = 1; j <= colSize; j++) {
            	// 0은 무시
            	if (A[i][j] == 0) continue; 
                countMap.put(A[i][j], countMap.getOrDefault(A[i][j], 0) + 1);
            }
            
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                sortedList.add(new int[]{entry.getKey(), entry.getValue()});
            }
            
            // 등장 횟수 오름차순 정렬, 같으면 숫자 기준 오름차순
            sortedList.sort((a, b) -> a[1] == b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
            
            int index = 1;
            for (int[] pair : sortedList) {
            	// 최대 크기 초과 방지
            	if (index > 100) break; 
                newA[i][index++] = pair[0];
                if (index > 100) break;
                newA[i][index++] = pair[1];
            }
            
            // 최대 열 크기 갱신
            maxCol = Math.max(maxCol, index - 1); 
        }
        
        // 배열 갱신
        A = newA; 
        // 열 크기 업데이트
        colSize = maxCol; 
    }

    // C 연산 : 각 열을 정렬하여 변환
    static void COperation() {
        int maxRow = 0;
        int[][] newA = new int[101][101];
        
        for (int j = 1; j <= colSize; j++) {
        	// 숫자 개수 저장
            Map<Integer, Integer> countMap = new HashMap<>(); 
            // (숫자, 등장 횟수) 리스트
            List<int[]> sortedList = new ArrayList<>(); 
            
            for (int i = 1; i <= rowSize; i++) {
            	// 0은 무시
            	if (A[i][j] == 0) continue; 
                countMap.put(A[i][j], countMap.getOrDefault(A[i][j], 0) + 1);
            }
            
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                sortedList.add(new int[]{entry.getKey(), entry.getValue()});
            }
            
            // 등장 횟수 오름차순 정렬, 같으면 숫자 기준 오름차순
            sortedList.sort((a, b) -> a[1] == b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
            
            int index = 1;
            for (int[] pair : sortedList) {
            	// 최대 크기 초과 방지
            	if (index > 100) break; 
                newA[index++][j] = pair[0];
                if (index > 100) break;
                newA[index++][j] = pair[1];
            }
            
            // 최대 행 크기 갱신
            maxRow = Math.max(maxRow, index - 1); 
        }
        
        // 배열 갱신
        A = newA; 
        // 행 크기 업데이트
        rowSize = maxRow; 
    }
}
