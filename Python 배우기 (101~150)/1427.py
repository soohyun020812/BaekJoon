# 소트인사이드 

N = input()

# 각 자리수 내림차순 정렬
sorted_N = ''.join(sorted(N, reverse=True))

print(sorted_N)