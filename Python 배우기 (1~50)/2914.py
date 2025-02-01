# 저작권 

# math : 수학 관련 기능(함수, 상수 등)을 제공하는 모듈
import math

# 앨범에 수록된 곡의 개수 A, 평균값 I 입력
A, I = map(int, input().split())

# 적어도 몇 곡이 저작권이 있는 멜로디인지 계산
min_melodies = A * (I - 1) + 1

print(min_melodies)