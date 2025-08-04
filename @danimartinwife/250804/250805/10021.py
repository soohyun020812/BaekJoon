import sys
input = sys.stdin.readline

# 유니온 파인드 자료구조
def find(x):
    if parent[x] != x:
        # 경로 압축
        parent[x] = find(parent[x]) 
    return parent[x]

def union(x, y):
    x_root = find(x)
    y_root = find(y)
    if x_root != y_root:
        parent[y_root] = x_root
        # 합치기 성공
        return True 
    # 이미 같은 그룹
    return False 

# 입력 처리
# n : 밭 개수, c : 최소 비용
n, c = map(int, input().split()) 
# 밭 좌표 저장
fields = [tuple(map(int, input().split())) for _ in range(n)] 

# 가능한 모든 간선(파이프 후보)을 저장할 리스트
edges = [] 

# 모든 밭 쌍에 대해 간선 후보 만들기
for i in range(n):
    x1, y1 = fields[i]
    for j in range(i + 1, n):
        x2, y2 = fields[j]
        # 거리의 제곱 = 비용 (유클리드 거리의 제곱)
        dist = (x1 - x2) ** 2 + (y1 - y2) ** 2 
        # 최소 비용 이상인 파이프만 가능
        if dist >= c: 
            # (비용, 밭1, 밭2)
            edges.append((dist, i, j)) 

# 비용 기준으로 오름차순 정렬 (크루스칼 준비)
edges.sort()

# 유니온 파인드 초기화
parent = [i for i in range(n)]

# MST 알고리즘 실행
total_cost = 0
edge_count = 0

for cost, a, b in edges:
    # 서로 다른 그룹이면 연결 
    if union(a, b): 
        total_cost += cost
        edge_count += 1
        # 모두 연결되었으면 끝 (n-1개의 간선이면 충분)
        if edge_count == n - 1: 
            break

# 모두 연결되었는지 확인
if edge_count == n - 1:
    print(total_cost)
else:
    # 연결 불가능한 경우
    print(-1) 
