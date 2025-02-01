# 문자열 반복 

# 테스트 케이스의 수를 입력받음
T = int(input())

# 각 테스트 케이스에 대해 반복
for _ in range(T):
    # 반복 횟수와 문자열을 입력받음
    R, S = input().split()
    R = int(R)

    # 결과 문자열을 만들기
    result = ''
    for char in S:
        # 각 문자를 R번 반복하여 result에 추가
        result += char * R 

    print(result)