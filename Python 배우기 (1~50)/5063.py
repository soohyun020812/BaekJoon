# TGN

N = int(input())

for _ in range(N):
    # r : 광고를 하지 않았을 때 수익
    # e : 광고를 했을 때의 수익
    # c : 광고 비용
    r, e, c = map(int, input().split()) 

    # 광고를 했을 때의 순수익
    profit = e - c 

    if profit > r:
        # 광고를 하는 것이 이득
        print("advertise") 
    elif profit < r:
        # 광고를 하지 않는 것이 이득
        print("do not advertise") 
    else:
        # 광고 여부가 수익에 영향 없음
        print("does not matter") 