# 사분면 

n = int(input()) 

# 사분면 및 축 개수를 딕셔너리로 관리
counts = {"Q1": 0, "Q2": 0, "Q3": 0, "Q4": 0, "AXIS": 0}

# if-elif-elif-elif 구조 대신
# dict["Q1" if 조건 else "Q2" if 조건 else ...] += 1 구조로 변경
for _ in range(n):
    x, y = map(int, input().split())

    if x == 0 or y == 0:
        counts["AXIS"] += 1
    else:
        counts["Q1" if x > 0 and y > 0 else
            "Q2" if x < 0 and y > 0 else
            "Q3" if x < 0 and y < 0 else
            "Q4"] += 1

for key in ["Q1", "Q2", "Q3", "Q4", "AXIS"]:
    print(f"{key}: {counts[key]}")