# 모음의 개수 

word = input()

# 모음 리스트 정의
vowels = {'a', 'e', 'i', 'o', 'u'}

# 단어에서 모음 개수 세기
count = sum(1 for char in word if char in vowels)

print(count)