# 대회 자리 

K = int(input()) 

for _ in range(K):
    # 참가자의 수 P, 자리의 수 M 
    P, M = map(int, input().split()) 
    # 이미 배정된 자리 저장
    occupied = set() 
    # 참가하지 못한 사람 수
    rejected = 0 

    for _ in range(P):
        # 참가자가 원하는 자리 번호 입력
        seat = int(input()) 
        # 이미 배정된 자리라면
        if seat in occupied: 
            # 참가하지 못함
            rejected += 1 
        else:
            # 배정 완료
            occupied.add(seat) 

    # 참가하지 못한 사람 수 
    print(rejected) 