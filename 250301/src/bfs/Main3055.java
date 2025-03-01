package bfs;
import java.io.*;
import java.util.*;

// 3055 탈출1
public class Main3055 {
	static int R, C;
    static char[][] forest;
    static int[][] time;
    static Queue<Point> queue = new LinkedList<>();
    
    // 상하좌우 이동
    static int[] dx = {-1, 1, 0, 0}; 
    static int[] dy = {0, 0, -1, 1};

    static class Point {
        int x, y, time;
        // 'S' : 고슴도치, '*' : 물
        char type; 

        Point(int x, int y, int time, char type) {
            this.x = x;
            this.y = y;
            this.time = time;
            this.type = type;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        forest = new char[R][C];
        time = new int[R][C];

        Point start = null;
        
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                forest[i][j] = line.charAt(j);
                // 초기화
                time[i][j] = -1; 

                if (forest[i][j] == 'S') { 
                	// 고슴도치 위치 저장
                    start = new Point(i, j, 0, 'S'); 
                } else if (forest[i][j] == '*') {
                	// 물 먼저 큐에 추가
                    queue.add(new Point(i, j, 0, '*')); 
                }
            }
        }

        // 고슴도치를 물 다음에 큐에 넣음
        queue.add(start);
        int result = bfs();
        
        System.out.println(result == -1 ? "KAKTUS" : result);
    }

    static int bfs() {
        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                // 돌은 통과 불가
                if (forest[nx][ny] == 'X') continue; 

                // 물 확장
                if (cur.type == '*') { 
                    if (forest[nx][ny] == '.' || forest[nx][ny] == 'S') {
                        forest[nx][ny] = '*';
                        queue.add(new Point(nx, ny, cur.time + 1, '*'));
                    }
                // 고슴도치 이동
                } else if (cur.type == 'S') { 
                	// 비버 굴 도착
                	if (forest[nx][ny] == 'D') { 
                        return cur.time + 1;
                    }
                    // 빈 공간 이동 가능
                    if (forest[nx][ny] == '.') { 
                        forest[nx][ny] = 'S';
                        queue.add(new Point(nx, ny, cur.time + 1, 'S'));
                    }
                }
            }
        }
        
        // 도착 불가능
        return -1; 
    }
}
