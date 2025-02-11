package Implementation;
import java.io.*; 

// 10709 기상캐스터 
public class Main10709 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = br.readLine().split(" ");
        
        // 첫 번째 줄에서 H(행), W(열) 값을 읽고 배열로 저장
        int H = Integer.parseInt(dimensions[0]);
        int W = Integer.parseInt(dimensions[1]);
        
        // 결과를 저장할 2차원 배열 초기화
        int[][] result = new int[H][W];

        for (int i = 0; i < H; i++) {
            String line = br.readLine();
            // 마지막으로 발견된 구름 위치 (없으면 -1)
            int lastCloud = -1; 

            for (int j = 0; j < W; j++) {
            	// 현 위치에 구름이 있으면
                if (line.charAt(j) == 'c') {
                	// 구름이 있는 위치는 0
                    result[i][j] = 0;
                    // 마지막 구름 위치 업데이트
                    lastCloud = j; 
                //이전 구름이 있던 경우
                } else if (lastCloud != -1) {
                	// 현 위치까지 걸린 시간 저장
                    result[i][j] = j - lastCloud;
                } else {
                	// 구름이 도달할 수 없는 위치는 -1
                    result[i][j] = -1; 
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                sb.append(result[i][j]).append(" ");
            }
            // 개행 문자 추가
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}
