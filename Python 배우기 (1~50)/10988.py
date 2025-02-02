# 팰린드롬인지 확인하기 

word = input()

# 단어가 팰린드롬인지 확인
# [::-1] : 문자열을 뒤집는 슬라이싱(Slicing) 기법
if word == word[::-1]:
    print(1)
else:
    print(0)