# 개수 세기 

N = int(input())

numbers = list(map(int, input().split()))

# 찾고자 하는 정수 v 입력
v = int(input())

# v가 몇 번 나타나는지 세기
count_v = numbers.count(v)

print(count_v)