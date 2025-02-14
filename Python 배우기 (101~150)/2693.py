# N번째 큰 수 

T = int(input()) 

for _ in range(T):
    # 10개의 숫자 입력
    numbers = list(map(int, input().split())) 
    # 내림차순 정렬
    numbers.sort(reverse=True) 
    print(numbers[2])