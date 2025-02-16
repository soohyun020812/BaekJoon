# KMP는 왜 KMP일까?

long_name = input()

# 하이픈('-')으로 구분하여 각 부분의 첫 글자만 추출
short_name = ''.join(word[0] for word in long_name.split('-'))

print(short_name)