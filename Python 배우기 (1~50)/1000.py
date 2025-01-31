# A+B

# 두 정수를 입력받아 정수형으로 변환
A, B = map(int, input().split()) 
# 두 정수의 합을 출력
print(A + B)

'''
map(함수, 반복 가능한 객체) 형태로 사용
반복 가능한 객체(리스트 등)의 각 요소에 함수를 적용하여 반환

numbers = ['3', '5']
# 모든 요소를 정수형(int)으로 변환
int_numbers = map(int, numbers) 
# 출력: [3, 5]
print(list(int_numbers))
'''

'''
split()은 문자열을 공백(or 지정한 구분자) 기준으로 나누어
리스트로 반환하는 함수

text = "3 5"
# 공백 기준으로 분리
numbers = text.split() 
# 출력: ['3', '5']
print(numbers)
'''