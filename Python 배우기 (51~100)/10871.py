# X보다 작은 수 

# 첫째 줄에는 N과 X
N, X = map(int, input().split()) 
# 둘째 줄에는 수열 A
A = list(map(int, input().split())) 

# X보다 작은 수를 필터링하여 출력
print(*[num for num in A if num < X])