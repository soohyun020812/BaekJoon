# 팩토리얼 0의 개수

# count_trailing_zeros : 뒤에 붙은 0의 개수 세는 함수
def count_trailing_zeros(N):
    count = 0
    # divisor : 5부터 시작
    # divisor를 계속해서 5배씩 늘려가며 N을 나눔
    divisor = 5
    while N >= divisor:
        # N // divisor : N 이하의 divisor의 배수의 개수를 나타냄냄
        count += N // divisor
        divisor *= 5
    return count

N = int(input())

print(count_trailing_zeros(N))