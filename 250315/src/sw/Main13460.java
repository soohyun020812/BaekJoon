package sw;
import java.io.*;
import java.util.*;

// 13460 구슬 탈출 2 
public class Main13460 {
	// 상, 하, 좌, 우 방향 
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class State {
        int rx, ry, bx, by, moves;
        State(int rx, int ry, int bx, int by, int moves) {
            this.rx = rx; this.ry = ry;
            this.bx = bx; this.by = by;
            this.moves = moves;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];
        // 방문 체크
        boolean[][][][] visited = new boolean[N][M][N][M]; 
        
        int rx = 0, ry = 0, bx = 0, by = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'R') {
                    rx = i; ry = j;
                    board[i][j] = '.';
                } else if (board[i][j] == 'B') {
                    bx = i; by = j;
                    board[i][j] = '.';
                }
            }
        }

        // BFS 탐색을 위한 큐
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        while (!queue.isEmpty()) {
            State cur = queue.poll();
            int curRx = cur.rx, curRy = cur.ry;
            int curBx = cur.bx, curBy = cur.by;
            int moves = cur.moves;

            // 10번 초과 시 종료
            if (moves >= 10) break;

            // 네 방향 탐색
            for (int i = 0; i < 4; i++) {
                int nRx = curRx, nRy = curRy;
                int nBx = curBx, nBy = curBy;

                boolean redHole = false, blueHole = false;

                // 빨간 구슬 이동
                while (board[nRx + dx[i]][nRy + dy[i]] != '#') {
                    nRx += dx[i];
                    nRy += dy[i];
                    if (board[nRx][nRy] == 'O') {
                        redHole = true;
                        break;
                    }
                }

                // 파란 구슬 이동
                while (board[nBx + dx[i]][nBy + dy[i]] != '#') {
                    nBx += dx[i];
                    nBy += dy[i];
                    if (board[nBx][nBy] == 'O') {
                        blueHole = true;
                        break;
                    }
                }

                // 파란 구슬이 구멍에 빠지면 실패
                if (blueHole) continue;

                // 빨간 구슬만 구멍에 빠졌다면 정답 출력 후 종료
                if (redHole) {
                    System.out.println(moves + 1);
                    return;
                }

                // 두 구슬이 같은 위치라면 조정
                if (nRx == nBx && nRy == nBy) {
                    if (Math.abs(nRx - curRx) + Math.abs(nRy - curRy) > 
                        Math.abs(nBx - curBx) + Math.abs(nBy - curBy)) {
                        nRx -= dx[i];
                        nRy -= dy[i];
                    } else {
                        nBx -= dx[i];
                        nBy -= dy[i];
                    }
                }

                // 방문하지 않았다면 큐에 추가
                if (!visited[nRx][nRy][nBx][nBy]) {
                    visited[nRx][nRy][nBx][nBy] = true;
                    queue.add(new State(nRx, nRy, nBx, nBy, moves + 1));
                }
            }
        }
        
        // 10번 이하로 성공하지 못한 경우 -1 출력
        System.out.println(-1);
    }
}
