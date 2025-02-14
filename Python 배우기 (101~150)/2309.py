# 일곱 난쟁이 

# 9명의 난쟁이 키 입력
dwarfs = [int(input()) for _ in range(9)]

# 전체 키의 합 구하기
total_sum = sum(dwarfs)

# 두 명을 찾아서 제외
found = False
for i in range(9):
    for j in range(i + 1, 9):
        if total_sum - (dwarfs[i] + dwarfs[j]) == 100:
            fake1, fake2 = dwarfs[i], dwarfs[j]
            found = True
            break
    if found:
        break

# 7명의 난쟁이만 남기고 정렬 후 출력
real_dwarfs = [d for d in dwarfs if d != fake1 and d != fake2]
real_dwarfs.sort()

for height in real_dwarfs:
    print(height)