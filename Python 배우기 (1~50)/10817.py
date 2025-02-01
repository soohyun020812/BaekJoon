# 세 수

# 세 정수 A, B, C 입력 받기
A, B, C = map(int, input().split())

# 세 수를 리스트로 만든 후 정렬
nums = [A, B, C]
nums.sort()

# 두 번째로 큰 정수 출력 (정렬된 리스트에서 두 번째 마지막 값)
print(nums[1])