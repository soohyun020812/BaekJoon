import sys
input = sys.stdin.readline

# 입력의 방향 : 1→, 2←, 3↑, 4↓
dr = [0, 0, 0, -1, 1]
dc = [0, 1, -1, 0, 0]
# 반대 방향: 1↔2, 3↔4
opp = {1:2, 2:1, 3:4, 4:3} 

N, K = map(int, input().split())
color = [list(map(int, input().split())) for _ in range(N)]

# pieces[i] = [r, c, d] (0-based r,c)
pieces = []
# board[r][c] : 그 칸에 쌓여 있는 말의 번호 목록 (바닥에서 맨위)
board = [[[] for _ in range(N)] for __ in range(N)]

for i in range(K):
    r, c, d = map(int, input().split())
    r -= 1; c -= 1
    pieces.append([r, c, d])
    board[r][c].append(i)

# 1부터 1000까지 턴 반복
for turn in range(1, 1001):
    finished = False
    for i in range(K):
        r, c, d = pieces[i]

        # 자기 차례에 '가장 아래'에 있지 않으면 이동하지 않음
        if board[r][c][0] != i:
            continue

        nr = r + dr[d]; nc = c + dc[d]

        # 파란칸(또는 범위 밖)이면 방향을 바꾸고 한 번 다시 시도
        if not (0 <= nr < N and 0 <= nc < N) or color[nr][nc] == 2:
            nd = opp[d]
            # 방향 정보는 바뀜 (문제 규칙)
            pieces[i][2] = nd 
            d = nd
            nr = r + dr[d]; nc = c + dc[d]
            # 바꾼 후에도 파란칸(또는 범위 밖)이면 이동하지 않음
            if not (0 <= nr < N and 0 <= nc < N) or color[nr][nc] == 2:
                continue

        # 아래에 있는 말만 움직이므로 '그 칸의 전체 스택'이 이동
        moving = board[r][c][:]
        board[r][c] = []

        # 흰칸 : 순서 그대로 올리기
        if color[nr][nc] == 0:
            board[nr][nc].extend(moving)
        else:
            # 빨간칸 : 올리기 전에 순서 반전
            moving.reverse()
            board[nr][nc].extend(moving)

        # 이동한 말들의 위치 업데이트
        for m in moving:
            pieces[m][0] = nr
            pieces[m][1] = nc

        # 쌓인 수가 4개 이상이면 현재 턴을 출력하고 종료
        if len(board[nr][nc]) >= 4:
            print(turn)
            finished = True
            break

    if finished:
        break
else:
    # 1000턴 넘으면 -1
    print(-1)
