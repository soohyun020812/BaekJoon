# 약수들의 합 

while True:
    n = int(input()) 
    if n == -1: 
        break

    # 약수 리스트
    divisors = [] 
    # 약수들의 합
    total = 0 

    # √n까지만 검사하여 약수 찾기기
    for i in range(1, int(n ** 0.5) + 1):
        if n % i == 0:
            divisors.append(i)
            total += i
            # 자기 자신 제외, 중복 방지
            if i != 1 and i != n // i: 
                divisors.append(n // i)
                total += n // i

    # 출력 형식에 맞춰 약수 정렬
    divisors.sort() 

    # 완전수 판별
    if total == n: 
        print(f"{n} = {' + '.join(map(str, divisors))}")
    else:
        print(f"{n} is NOT perfect.")