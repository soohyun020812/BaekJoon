# 10부제 

day = int(input().strip())

# 5대의 자동차 번호 일의 자리 숫자 입력
cars = list(map(int, input().split()))

# 날짜와 같은 숫자의 개수 세기
violations = cars.count(day)

print(violations)