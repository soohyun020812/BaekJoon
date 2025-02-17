# 숫자의 합 

N = int(input().strip())

numbers = input().strip()

# 각 숫자를 정수로 변환한 후 모두 더하기
total = sum(map(int, numbers))

print(total)