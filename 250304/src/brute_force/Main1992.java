package brute_force;
import java.io.*;

// 1992 쿼드트리 
public class Main1992 {
	static int N;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        System.out.println(compress(0, 0, N));
    }

    // (x, y)에서 시작하여 size × size 영역을 압축하는 함수
    static String compress(int x, int y, int size) {
    	// 모든 값이 동일한 경우
    	if (isUniform(x, y, size)) { 
    		
            return String.valueOf(map[x][y]);
        }

        int newSize = size / 2;
        return "("
        		// 왼쪽 위
        		+ compress(x, y, newSize)
        		// 오른쪽 위
        		+ compress(x, y + newSize, newSize)
        		// 왼쪽 아래
        		+ compress(x + newSize, y, newSize)
        		// 오른쪽 아래
        		+ compress(x + newSize, y + newSize, newSize) 
                + ")";
    }

    // (x, y)에서 시작하는 size × size 영역이 모두 같은 값인지 확인
    static boolean isUniform(int x, int y, int size) {
        char first = map[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] != first) return false;
            }
        }
        
        return true;
    }
}
