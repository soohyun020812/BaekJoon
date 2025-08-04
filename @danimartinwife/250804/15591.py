import sys
input = sys.stdin.readline

sys.setrecursionlimit(10**6)

# 유니온 파인드 구조 (Disjoint Set Union)
def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(x, y):
    root_x = find(x)
    root_y = find(y)
    if root_x != root_y:
        parent[root_y] = root_x
        # 연결된 컴포넌트의 크기를 업데이트
        size[root_x] += size[root_y] 

# 입력 처리
# n : 동영상 수, q : 질문 수
n, q = map(int, input().split()) 

# 간선 정보 : (USADO, 동영상1, 동영상2)
edges = [] 
for _ in range(n - 1):
    p, q_, r = map(int, input().split())
    edges.append((r, p, q_))

# 질문 정보 저장 : (K, V, 쿼리 번호)
queries = []
for i in range(q):
    k, v = map(int, input().split())
    queries.append((k, v, i))

# USADO 내림차순 정렬
edges.sort(reverse=True)
queries.sort(reverse=True)

# 유니온 파인드 초기화
parent = [i for i in range(n + 1)]
# 각 노드가 포함된 연결 컴포넌트 크기
size = [1] * (n + 1) 
# 각 쿼리의 결과를 저장할 배열
answers = [0] * q 
# 현재 간선 인덱스
edge_idx = 0 

# 모든 쿼리를 처리 (내림차순 기준으로)
for k, v, idx in queries:
    # 조건을 만족하는 간선을 연결(유니온)하면서 진행
    while edge_idx < len(edges) and edges[edge_idx][0] >= k:
        _, a, b = edges[edge_idx]
        union(a, b)
        edge_idx += 1

    # v가 포함된 컴포넌트의 크기 - 1 (자기 자신 제외)
    answers[idx] = size[find(v)] - 1

# 결과 출력
for res in answers:
    print(res)

# 1. 간선을 USADO 내림차순 정렬
# 2. 쿼리도 K 내림차순으로 정렬
# 3. 쿼리마다 USADO ≥ K인 간선을 연결(유니온)
# 4. 유니온-파인드로 연결된 컴포넌트 크기를 이용해 추천 개수 계산
# 5. 각 쿼리의 결과를 저장하고 출력