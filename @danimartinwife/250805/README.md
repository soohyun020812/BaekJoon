### 메모리 초과 
> n이 최대 2000일 경우, 이중 루프는 약 2,000,000개 간선을 생성
> 각 간선을 (비용, 밭1, 밭2) 형태로 저장 → 약 48바이트 × 2백만 = 약 90MB 이상 소요

```python
edges = [] 

for i in range(n):
    for j in range(i + 1, n):
        dist = (x1 - x2) ** 2 + (y1 - y2) ** 2 
        if dist >= c:
            edges.append((dist, i, j)) 
```

### 메모리 초과 수정
> Prim 기반 최소 스패닝 트리

```python
heap = [(0, 0)]

while heap:
    cost, current = heapq.heappop(heap)
    if visited[current]:
        continue
    visited[current] = True
    total_cost += cost
    edge_count += 1
    if edge_count == n:
        break
    for next_node in range(n):
        if not visited[next_node]:
            dist = (x1 - x2) ** 2 + (y1 - y2) ** 2
            if dist >= c:
                heapq.heappush(heap, (dist, next_node))
```

| 항목       | 기존 (Kruskal 기반)                            | 수정 (Prim 기반)                        |
| -------- | --------------------------------------------- | -------------------------------------- |
| 간선 생성 방식 | 모든 밭 쌍의 거리 계산 후 리스트에 저장 (`O(N²)`)             | 연결 가능한 노드에 대해서만 거리 계산 (`O(N log N)`)   |
| 간선 저장 구조 | `edges[]`에 최대 `N*(N-1)/2` 간선 저장               | 최소 힙 `heapq`만 사용하여 필요 시마다 동적 삽입        |
| 메모리 사용량  | O(N²) 간선 저장 + 유니온 파인드용 배열 등 → 128MB 초과 위험 | O(N) 힙 구조 + 방문 배열만 사용 → 안정적 메모리 관리 |
| 시간복잡도    | `O(E log E)` (간선 정렬) + `O(α(N))` (유니온 파인드)    | `O(N log N)` (우선순위 큐 연산)               |
| 핵심 차이점   | 모든 거리/간선을 미리 계산 및 저장                      | 거리 계산은 필요한 순간에만 수행, 간선 저장하지 않음     |
