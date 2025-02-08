# 도미노 

N = int(input()) 

total_points = 0 

# 0부터 N까지
for i in range(N + 1): 
    # i부터 N까지
    for j in range(i, N + 1): 
        # i와 j의 합을 더함
        total_points += (i + j) 

print(total_points) 