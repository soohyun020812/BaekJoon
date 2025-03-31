package sw;
import java.io.*;
import java.util.*;

// 20061 모노미노도미노 2
public class Main20061 {
	static int[][] grid = new int[10][10];
    static int N, score;

    static class Block {
        int type, x, y;
        public Block(int type, int x, int y) {
            this.type = type;
            this.x = x;
            this.y = y;
        }
    }

    // 오른쪽 이동(파란색), 아래 이동(초록색)
    static int[] dx = {0, 1}; 
    static int[] dy = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            Block block = new Block(t, x, y);
            playGame(block, "blue");
            playGame(block, "green");
        }

        System.out.println(score);
        System.out.println(countBlocks());
    }

    // 블록을 이동시키고 점수 체크
    private static void playGame(Block block, String boardColor) {
        placeBlock(block, boardColor);
        List<Integer> fullLines = findFullLines(boardColor);
        score += fullLines.size();
        clearLines(fullLines, boardColor);
        handleSpecialRows(boardColor);
    }

    // 블록을 이동시켜 최종 위치에 배치
    private static void placeBlock(Block block, String boardColor) {
        int x = block.x, y = block.y, t = block.type;
        List<int[]> points = new ArrayList<>();

        points.add(new int[]{x, y});
        // 가로 블록
        if (t == 2) points.add(new int[]{x, y + 1}); 
        // 세로 블록
        if (t == 3) points.add(new int[]{x + 1, y}); 
        
        // 초록 : 아래, 파랑 : 오른쪽
        int dir = boardColor.equals("green") ? 1 : 0;  

        while (true) {
            boolean canMove = true;
            for (int[] p : points) {
                int nx = p[0] + dx[dir], ny = p[1] + dy[dir];
                if (!inRange(nx, ny) || grid[nx][ny] == 1) {
                    canMove = false;
                    break;
                }
            }
            
            if (!canMove) break;

            for (int[] p : points) {
                p[0] += dx[dir];
                p[1] += dy[dir];
            }
        }

        for (int[] p : points) {
            grid[p[0]][p[1]] = 1;
        }
    }

    // 보드의 꽉 찬 행(초록색) 또는 열(파란색) 찾기
    private static List<Integer> findFullLines(String boardColor) {
        List<Integer> fullLines = new ArrayList<>();
        if (boardColor.equals("blue")) {
            for (int col = 6; col <= 9; col++) {
                boolean full = true;
                for (int row = 0; row <= 3; row++) {
                    if (grid[row][col] == 0) full = false;
                }
                if (full) fullLines.add(col);
            }
        } else {
            for (int row = 6; row <= 9; row++) {
                boolean full = true;
                for (int col = 0; col <= 3; col++) {
                    if (grid[row][col] == 0) full = false;
                }
                if (full) fullLines.add(row);
            }
        }

        return fullLines;
    }

    // 블록이 꽉 찬 행/열을 제거하고 위에서 당겨오기
    private static void clearLines(List<Integer> lines, String boardColor) {
        for (int line : lines) {
            if (boardColor.equals("blue")) {
                for (int row = 0; row <= 3; row++) {
                    grid[row][line] = 0;
                }
                for (int j = line; j >= 4; j--) {
                    for (int row = 0; row <= 3; row++) {
                        grid[row][j] = grid[row][j - 1];
                    }
                }
            } else {
                for (int col = 0; col <= 3; col++) {
                    grid[line][col] = 0;
                }
                for (int j = line; j >= 4; j--) {
                    for (int col = 0; col <= 3; col++) {
                        grid[j][col] = grid[j - 1][col];
                    }
                }
            }
        }
    }

    // 연한 영역(0~1번 행/열)에 블록이 있는 경우 처리
    private static void handleSpecialRows(String boardColor) {
        int count = countSpecialRows(boardColor);
        List<Integer> linesToClear = new ArrayList<>();
        for (int i = 0; i < count; i++) linesToClear.add(9);
        clearLines(linesToClear, boardColor);
    }

    // 연한 영역(4~5번째 행/열)에 블록이 있는지 확인
    private static int countSpecialRows(String boardColor) {
        int count = 0;
        for (int i = 4; i <= 5; i++) {
            boolean hasBlock = false;
            if (boardColor.equals("blue")) {
                for (int row = 0; row <= 3; row++) {
                    if (grid[row][i] == 1) hasBlock = true;
                }
            } else {
                for (int col = 0; col <= 3; col++) {
                    if (grid[i][col] == 1) hasBlock = true;
                }
            }
            if (hasBlock) count++;
        }
        
        return count;
    }

    // 보드에 남아 있는 블록 개수 세기
    private static int countBlocks() {
        int count = 0;
        for (int i = 0; i <= 3; i++) {
            for (int j = 6; j <= 9; j++) {
                count += grid[i][j] + grid[j][i];
            }
        }
        
        return count;
    }

    private static boolean inRange(int x, int y) {
        
    	return x >= 0 && x < 10 && y >= 0 && y < 10;
    }
}
