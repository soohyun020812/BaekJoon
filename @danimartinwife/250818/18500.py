from collections import deque

R, C = map(int, input().split())
cave = [list(input().strip()) for _ in range(R)]
N = int(input())
throws = list(map(int, input().split()))

# 방향 전환 (왼->오, 오->왼)
# 오른쪽, 왼쪽
dx = [1, -1] 

def throw_stick(height, turn):
    """막대기를 던져서 미네랄을 부수는 함수"""
    # 문제에서 높이 1은 바닥
    r = R - height 
    # 짝수번째는 왼쪽에서 오른쪽
    if turn % 2 == 0: 
        for c in range(C):
            if cave[r][c] == 'x':
                cave[r][c] = '.'
                break
    # 홀수번째는 오른쪽에서 왼쪽
    else: 
        for c in range(C-1, -1, -1):
            if cave[r][c] == 'x':
                cave[r][c] = '.'
                break

def find_clusters():
    """땅과 연결되지 않은 클러스터를 찾아서 리스트로 반환"""
    visited = [[False]*C for _ in range(R)]
    cluster = []
    
    for r in range(R):
        for c in range(C):
            if cave[r][c] == 'x' and not visited[r][c]:
                q = deque()
                q.append((r,c))
                visited[r][c] = True
                tmp = [(r,c)]
                is_floating = True
                
                while q:
                    cr, cc = q.popleft()
                    for dr, dc in [(-1,0),(1,0),(0,-1),(0,1)]:
                        nr, nc = cr+dr, cc+dc
                        if 0 <= nr < R and 0 <= nc < C and not visited[nr][nc] and cave[nr][nc] == 'x':
                            visited[nr][nc] = True
                            q.append((nr,nc))
                            tmp.append((nr,nc))
                    if cr == R-1:
                        # 땅과 연결되어 있다면 떠 있는 클러스터 아님
                        is_floating = False 
                
                if is_floating:
                    cluster.append(tmp)
    return cluster

def drop_cluster(cluster):
    """떠 있는 클러스터를 중력에 의해 떨어뜨리는 함수"""
    # 클러스터를 제거
    for r, c in cluster:
        cave[r][c] = '.'

    # 최대 떨어지는 거리 계산
    drop = 0
    while True:
        can_drop = True
        for r, c in cluster:
            nr = r + drop + 1
            if nr >= R or cave[nr][c] == 'x':
                can_drop = False
                break
        if not can_drop:
            break
        drop += 1
    
    # 클러스터를 떨어뜨리기
    for r, c in cluster:
        cave[r+drop][c] = 'x'

# 막대기 던지기 반복
for turn, height in enumerate(throws):
    throw_stick(height, turn)
    
    # 떠 있는 클러스터 찾기
    clusters = find_clusters()
    
    # 떠 있는 클러스터가 있으면 떨어뜨리기 
    # 문제 조건 : 동시에 여러 클러스터 떨어지지 않음
    if clusters:
        drop_cluster(clusters[0])

for row in cave:
    print(''.join(row))
