# 주차의 신 

T = int(input()) 

for _ in range(T):
    # 상점의 개수
    n = int(input()) 
    # 상점들의 위치
    nums = list(map(int, input().split())) 
    
    # 상점들 위치 오름차순 정렬
    nums.sort() 
    
    # 주차장에서 가장 가까운 상점까지 가고
    # 모든 상점들을 순차적으로 방문 후 다시 주차장으로 돌아옴

    # 가장 먼 상점에서 가장 가까운 상점까지 가는 거리와 다시 돌아오는 거리
    total_distance = (nums[-1] - nums[0]) * 2 
    
    print(total_distance)