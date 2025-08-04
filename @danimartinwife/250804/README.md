# 15591 MooTube (Silver) 

### 시간 초과 발생
> BFS 방식

```python
for k, v in questions:
    visited = [False] * (n + 1)
    visited[v] = True
    queue = deque([(v, float('inf'))])
    count = 0
    while queue:
        now, usado = queue.popleft()
        for next_node, next_usado in graph[now]:
            if not visited[next_node]:
                visited[next_node] = True
                min_usado = min(usado, next_usado)
                if min_usado >= k:
                    count += 1
                    queue.append((next_node, min_usado))
```

### 시간 초과 수정
> 오프라인 쿼리 + 유니온파인드 (Disjoint Set)

```python
# USADO 기준 내림차순 정렬
edges.sort(reverse=True)
# K 기준 내림차순 정렬
questions.sort(reverse=True)
uf = UnionFind(n)
res = [0] * len(questions)
idx = 0

for k, v, i in questions:
    while idx < len(edges) and edges[idx][2] >= k:
        u, v2, usado = edges[idx]
        uf.union(u, v2)
        idx += 1
    res[i] = uf.size(v) - 1
```

| 항목           | 기존 코드                                      | 수정 코드                                                     |
|----------------|-----------------------------------------------|---------------------------------------------------------------|
| 정렬 기준       | 쿼리마다 BFS를 새로 수행함 → O(Q * E)          | edges, queries를 미리 USADO 내림차순 정렬하여 한 번만 유니온 수행 |
| 연결 탐색 방식   | BFS로 매 쿼리마다 유사도 이상 간선만 순회       | 유니온 파인드로 빠르게 연결 여부 및 크기 파악                    |
| 시간복잡도       | 쿼리마다 BFS: 최악 O(Q * N) → 시간 초과         | 전체 간선과 쿼리를 정렬 후 한 번만 스캔: O(N log N + Q log Q + α(N)) |
| 핵심 최적화     | 없음                                           | 간선과 쿼리 모두 정렬해가며 유니온 수행 후 답 즉시 계산           |

