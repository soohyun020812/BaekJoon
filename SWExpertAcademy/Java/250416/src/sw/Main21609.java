package sw;
import java.io.*;
import java.util.*;

// 상어 중학교
public class Main21609 {
	static int N, M;
    static int[][] board;
    static boolean[][] visited;
    // 상하좌우 방향 배열
    static int[] dr = {-1, 1, 0, 0}; 
    static int[] dc = {0, 0, -1, 1};
    static int score = 0;

    static class BlockGroup implements Comparable<BlockGroup> {
        int size, rainbowCount, row, col;
        List<int[]> blocks;

        BlockGroup(int size, int rainbowCount, int row, int col, List<int[]> blocks) {
            this.size = size;
            this.rainbowCount = rainbowCount;
            this.row = row;
            this.col = col;
            this.blocks = blocks;
        }

        @Override
        public int compareTo(BlockGroup o) {
            if (this.size != o.size) return o.size - this.size;
            if (this.rainbowCount != o.rainbowCount) return o.rainbowCount - this.rainbowCount;
            if (this.row != o.row) return o.row - this.row;
            return o.col - this.col;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        // 오토 플레이 시작
        while (true) {
            // 가장 큰 그룹 찾기
            BlockGroup group = findLargestGroup(); 
            if (group == null || group.size < 2) break;

            // 점수 추가
            score += group.size * group.size;

            // 그룹 제거
            for (int[] b : group.blocks) {
                // 제거된 블록은 -2로 표시
                board[b[0]][b[1]] = -2; 
            }

            // 중력 작용
            applyGravity(); 
            // 90도 반시계 회전
            rotateBoard(); 
            // 다시 중력 작용
            applyGravity(); 
        }

        System.out.println(score);
    }

    // 가장 큰 블록 그룹 찾기
    static BlockGroup findLargestGroup() {
        visited = new boolean[N][N];
        BlockGroup best = null;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && board[i][j] > 0) {
                    BlockGroup group = bfs(i, j, board[i][j]);
                    if (group.size >= 2) {
                        if (best == null || group.compareTo(best) < 0) {
                            best = group;
                        }
                    }
                }
            }
        }
        return best;
    }

    // BFS로 블록 그룹 구성
    static BlockGroup bfs(int r, int c, int color) {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> blocks = new ArrayList<>();
        List<int[]> rainbows = new ArrayList<>();

        boolean[][] tempVisited = new boolean[N][N];
        q.add(new int[]{r, c});
        blocks.add(new int[]{r, c});
        visited[r][c] = true;
        tempVisited[r][c] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N || tempVisited[nr][nc]) continue;
                if (board[nr][nc] == 0 || board[nr][nc] == color) {
                    q.add(new int[]{nr, nc});
                    blocks.add(new int[]{nr, nc});
                    tempVisited[nr][nc] = true;
                    if (board[nr][nc] == 0) {
                        rainbows.add(new int[]{nr, nc});
                    } else {
                        visited[nr][nc] = true;
                    }
                }
            }
        }

        // 기준 블록 찾기 (무지개 제외)
        int stdR = N, stdC = N;
        for (int[] b : blocks) {
            if (board[b[0]][b[1]] == 0) continue;
            if (b[0] < stdR || (b[0] == stdR && b[1] < stdC)) {
                stdR = b[0];
                stdC = b[1];
            }
        }

        return new BlockGroup(blocks.size(), rainbows.size(), stdR, stdC, blocks);
    }

    // 중력 작용
    static void applyGravity() {
        for (int c = 0; c < N; c++) {
            for (int r = N - 2; r >= 0; r--) {
                if (board[r][c] >= 0) {
                    int nr = r;
                    while (true) {
                        if (nr + 1 >= N || board[nr + 1][c] != -2) break;
                        board[nr + 1][c] = board[nr][c];
                        board[nr][c] = -2;
                        nr++;
                    }
                }
            }
        }
    }

    // 90도 반시계 회전
    static void rotateBoard() {
        int[][] newBoard = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                newBoard[N - 1 - c][r] = board[r][c];
            }
        }
        board = newBoard;
    }
}
