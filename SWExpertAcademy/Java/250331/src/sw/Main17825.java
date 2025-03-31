package sw;
import java.util.*;

// 17825 주사위 윷놀이 
public class Main17825 {
	static class Node {
        int score, next, blueNext;
        boolean isBlue, isEnd;

        Node(int score, int next, boolean isBlue, int blueNext) {
            this.score = score;
            this.next = next;
            this.isBlue = isBlue;
            this.blueNext = blueNext;
            this.isEnd = false;
        }
    }

	// 게임판
    static Node[] board = new Node[33]; 
    // 주사위 값
    static int[] dice = new int[10]; 
    // 말들의 현재 위치
    static int[] horse = new int[4]; 
    // 위치 방문 여부
    static boolean[] visited = new boolean[33]; 
    static int maxScore = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for (int i = 0; i < 10; i++) {
            dice[i] = sc.nextInt();
        }
        
        initBoard();
        dfs(0, 0);
        
        System.out.println(maxScore);
    }

    // 게임판 초기화
    static void initBoard() {
        for (int i = 0; i < 33; i++) board[i] = new Node(0, 0, false, -1);
        
        // 기본 경로
        int[] scores = {0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40};
        for (int i = 0; i < 20; i++) {
            board[i].score = scores[i];
            board[i].next = i + 1;
        }
        board[20] = new Node(40, 32, false, -1);
        board[32] = new Node(0, 32, false, -1);
        board[5].isBlue = true;
        board[10].isBlue = true;
        board[15].isBlue = true;

        // 파란색 경로
        board[5].blueNext = 21;
        board[21] = new Node(13, 22, false, -1);
        board[22] = new Node(16, 23, false, -1);
        board[23] = new Node(19, 24, false, -1);
        board[24] = new Node(25, 30, false, -1);

        board[10].blueNext = 25;
        board[25] = new Node(22, 26, false, -1);
        board[26] = new Node(24, 24, false, -1);

        board[15].blueNext = 27;
        board[27] = new Node(28, 28, false, -1);
        board[28] = new Node(27, 29, false, -1);
        board[29] = new Node(26, 24, false, -1);

        // 합류 지점
        board[30] = new Node(30, 31, false, -1);
        board[31] = new Node(35, 20, false, -1);
    }

    // 백트래킹 탐색
    static void dfs(int turn, int score) {
        if (turn == 10) {
            maxScore = Math.max(maxScore, score);

            return;
        }

        int move = dice[turn];

        for (int i = 0; i < 4; i++) {
            int curPos = horse[i];
            // 이미 도착한 말 제외
            if (curPos == 32) continue; 

            int nextPos = getNextPosition(curPos, move);
            // 다른 말이 있는 경우 이동 불가
            if (nextPos != 32 && visited[nextPos]) continue; 

            visited[curPos] = false;
            visited[nextPos] = true;
            horse[i] = nextPos;

            dfs(turn + 1, score + board[nextPos].score);

            visited[nextPos] = false;
            visited[curPos] = true;
            horse[i] = curPos;
        }
    }

    // 현재 위치에서 이동할 위치 계산
    static int getNextPosition(int pos, int move) {
        if (board[pos].isBlue) pos = board[pos].blueNext;
        else pos = board[pos].next;

        for (int i = 1; i < move; i++) {
            if (pos == 32) break;
            pos = board[pos].next;
        }
        
        return pos;
    }
}
