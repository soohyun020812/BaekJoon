# 수 정렬하기 

N = int(input())

# N개의 수 입력
numbers = [int(input()) for _ in range(N)]

# 오름차순 정렬
numbers.sort()

for num in numbers:
    print(num)