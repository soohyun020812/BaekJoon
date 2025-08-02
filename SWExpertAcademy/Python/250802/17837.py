# 17837 체스판 게임 시뮬레이션
# 말 K개가 N×N 체스판에서 규칙에 따라 이동하며 하나의 칸에 말이 4개 이상 쌓이면 게임이 종료

# 말 이동 방향 정의 (인덱스를 1부터 사용)
# 1 : 오른쪽, 2 : 왼쪽, 3 : 위, 4 : 아래

dx = [0, 0, 0, -1, 1]   # x좌표 이동
dy = [0, 1, -1, 0, 0]   # y좌표 이동

# 방향을 반대로 바꾸는 함수
def reverse_direction(direction):
    if direction == 1: return 2
    if direction == 2: return 1
    if direction == 3: return 4
    if direction == 4: return 3

# 체스판 범위 확인 함수
def is_in_bounds(x, y, N):
    return 0 <= x < N and 0 <= y < N

# 게임 시뮬레이션 함수
def simulate_game(N, K, board_colors, horse_info, horse_map):
    turn = 0

    while turn <= 1000:
        turn += 1

        # 모든 말을 순서대로 이동
        for horse_id in range(K):
            x, y, direction = horse_info[horse_id]

            current_stack = horse_map[x][y]
            # 말이 현재 스택에서 어디에 있는지 찾기
            index_in_stack = current_stack.index(horse_id)
            # 이동할 말들만 추출
            moving_horses = current_stack[index_in_stack:] 
            # 이동하지 않는 말들만 남김
            horse_map[x][y] = current_stack[:index_in_stack]

            # 이동하려는 위치
            nx = x + dx[direction]
            ny = y + dy[direction]

            # 파란색이거나 체스판 밖인 경우 - 방향 반대로 바꿔 재시도
            if not is_in_bounds(nx, ny, N) or board_colors[nx][ny] == 2:
                direction = reverse_direction(direction)
                # 방향 업데이트
                horse_info[horse_id][2] = direction

                nx = x + dx[direction]
                ny = y + dy[direction]

                # 재시도도 실패하면 원래 자리에 다시 쌓기
                if not is_in_bounds(nx, ny, N) or board_colors[nx][ny] == 2:
                    horse_map[x][y].extend(moving_horses)
                    continue

            # 흰색(0) 그대로 쌓음
            if board_colors[nx][ny] == 0:
                horse_map[nx][ny].extend(moving_horses)

            # 빨간색(1) 쌓는 순서를 뒤집음
            elif board_colors[nx][ny] == 1:
                horse_map[nx][ny].extend(reversed(moving_horses))

            # 이동한 말들의 좌표 정보 갱신
            for moving_id in moving_horses:
                horse_info[moving_id][0] = nx
                horse_info[moving_id][1] = ny

            # 종료 조건: 말이 4개 이상 쌓이면 게임 종료
            if len(horse_map[nx][ny]) >= 4:
                return turn

    # 1000턴 넘게 지나도 끝나지 않으면 -1
    return -1

# 입력 처리
# 체스판 크기 N, 말의 수 K
N, K = map(int, input().split())

# 체스판 색 정보 (0 : 흰, 1 : 빨, 2 : 파)
board_colors = [list(map(int, input().split())) for _ in range(N)]

# 각 칸에 말이 쌓인 상태를 저장할 2차원 리스트
horse_map = [[[] for _ in range(N)] for _ in range(N)]

# 말 정보 : [x좌표, y좌표, 방향]
horse_info = []

for horse_id in range(K):
    r, c, d = map(int, input().split())
    # 0-indexed 처리
    r -= 1 
    c -= 1
    horse_info.append([r, c, d])
    # 처음 위치에 말 번호 쌓기
    horse_map[r][c].append(horse_id)

# 시뮬레이션 실행 및 결과 출력
print(simulate_game(N, K, board_colors, horse_info, horse_map))
