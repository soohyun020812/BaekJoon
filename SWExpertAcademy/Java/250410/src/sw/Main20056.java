package sw;
import java.io.*;
import java.util.*;

// 마법사 상어와 파이어볼 
public class Main20056 {
	static int N, M, K;
    static List<Fireball>[][] map;
    // 0~7 방향 (위에서 시계 방향)
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1}; 
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static List<Fireball> fireballs = new ArrayList<>();

    static class Fireball {
        int r, c, m, s, d;

        Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        initMap(N);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            // 0-indexed
            int r = Integer.parseInt(st.nextToken()) - 1; 
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            fireballs.add(new Fireball(r, c, m, s, d));
        }

        while (K-- > 0) {
            moveFireballs();
            splitFireballs();
        }

        int answer = 0;
        for (Fireball fb : fireballs) {
            answer += fb.m;
        }

        System.out.println(answer);
    }

    @SuppressWarnings("unchecked")
    static void initMap(int N) {
        map = new ArrayList[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                map[i][j] = new ArrayList<>();
    }

    static void moveFireballs() {
        // 맵 초기화
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                map[i][j].clear();

        // 모든 파이어볼 이동
        for (Fireball fb : fireballs) {
            int nr = (fb.r + dr[fb.d] * fb.s % N + N) % N;
            int nc = (fb.c + dc[fb.d] * fb.s % N + N) % N;
            map[nr][nc].add(new Fireball(nr, nc, fb.m, fb.s, fb.d));
        }
        fireballs.clear();
    }

    static void splitFireballs() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int size = map[i][j].size();
                if (size == 0) continue;
                if (size == 1) {
                    fireballs.add(map[i][j].get(0));
                    continue;
                }

                int sumM = 0, sumS = 0;
                boolean allEven = true, allOdd = true;

                for (Fireball fb : map[i][j]) {
                    sumM += fb.m;
                    sumS += fb.s;
                    if (fb.d % 2 == 0) allOdd = false;
                    else allEven = false;
                }

                int newM = sumM / 5;
                if (newM == 0) continue;

                int newS = sumS / size;
                int[] nd = allEven || allOdd ? new int[]{0, 2, 4, 6} : new int[]{1, 3, 5, 7};
                for (int d : nd) {
                    fireballs.add(new Fireball(i, j, newM, newS, d));
                }
            }
        }
    }
}
