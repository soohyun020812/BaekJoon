# 네 번째 점 

x_list = []
y_list = []

for _ in range(3):
    x, y = map(int, input().split())
    x_list.append(x)
    y_list.append(y)

# 네 번째 점의 x, y 찾기
for x in x_list:
    # x_list.count(x) == 1인 값을 찾아 x4로 저장
    if x_list.count(x) == 1:
        x4 = x
        break

for y in y_list:
    # y_list.count(y) == 1인 값을 찾아 y4로 저장
    if y_list.count(y) == 1:
        y4 = y
        break

print(x4, y4)