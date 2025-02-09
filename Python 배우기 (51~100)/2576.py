# 홀수 

nums = [int(input()) for _ in range(7)] 
# 홀수만 필터링
odds = [num for num in nums if num % 2 == 1] 

if odds:
    print(sum(odds)) 
    print(min(odds)) 
else:
    # 홀수가 없을 경우
    print(-1) 