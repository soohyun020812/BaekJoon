package implementation;
import java.io.*;
import java.util.*;

// 20006 랭킹전 대기열
public class Main20006 {
	// 플레이어 정보 저장하는 클래스 
	static class Player {
		// 플레이어 레벨
		int level;
		// 플레이어 닉네임 
		String nickname;

        Player(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }
    }

	// 방 정보 저장하는 클래스
    static class Room {
    	// 방의 입장 가능한 최소, 최대 레벨과 최대 정원
    	int minLevel, maxLevel, maxSize;
    	// 방에 있는 플레이어 리스트
        List<Player> players = new ArrayList<>();

        // 방 생성자 : 처음 입장한 플레이어의 레벨을 기준으로 -10 ~ +10 범위 설정
        Room(int level, int maxSize) {
            this.minLevel = level - 10;
            this.maxLevel = level + 10;
            this.maxSize = maxSize;
        }

        // 플레이어가 방에 입장할 수 있는지 확인하는 메서드
        boolean canJoin(Player player) {
            return players.size() < maxSize && player.level >= minLevel && player.level <= maxLevel;
        }

        // 방에 플레이어 추가
        void addPlayer(Player player) {
            players.add(player);
        }

        // 방의 상태를 출력하는 메서드
        void printRoomStatus() {
        	// 닉네임 기준으로 정렬
            players.sort(Comparator.comparing(p -> p.nickname));
            System.out.println(players.size() >= maxSize ? "Started!" : "Waiting!");
            for (Player p : players) {
                System.out.println(p.level + " " + p.nickname);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 플레이어 수
        int p = Integer.parseInt(st.nextToken());
        // 방의 최대 정원
        int m = Integer.parseInt(st.nextToken());

        // 방 리스트 
        List<Room> rooms = new ArrayList<>();
        
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            // 플레이어 레벨
            int level = Integer.parseInt(st.nextToken());
            // 플레이어 닉네임
            String nickname = st.nextToken();
            
            Player newPlayer = new Player(level, nickname);
            boolean matched = false;
            
            // 기존 방에 입장 가능한지 확인
            for (Room room : rooms) {
            	// 입장 가능하면 추가하고 종료
            	if (room.canJoin(newPlayer)) {
                    room.addPlayer(newPlayer);
                    matched = true;
                    break;
                }
            }
            
            // 입장 가능한 방이 없으면 새로운 방 생성
            if (!matched) {
                Room newRoom = new Room(level, m);
                newRoom.addPlayer(newPlayer);
                rooms.add(newRoom);
            }
        }
        
        for (Room room : rooms) {
            room.printRoomStatus();
        }
    }
}
