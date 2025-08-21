import re
import sys
import operator
from itertools import permutations

# 수식의 길이 (숫자 + 연산자 포함)
length = int(sys.stdin.readline())
# 실제 수식 문자열
expression = sys.stdin.readline()
# 연산자 기호와 실제 파이썬 연산 함수를 매핑
matcher = {
    '*': operator.mul,      # 곱하기
    '+': operator.add,      # 더하기
    '-': operator.sub,      # 빼기
    '/': operator.floordiv  # 정수 나눗셈 (여기서는 쓰이지 않음)
}
# 정규표현식으로 숫자만 뽑아서 리스트로 저장 (피연산자들)
digit = list(map(int, re.findall('\\d', expression)))
# 정규표현식으로 연산자만 뽑아서 리스트로 저장
# 맨 끝에 공백 문자 제거를 위해 [: -1] 사용
oper = list(re.findall('\\D', expression))[:-1]
# 결과를 저장할 리스트
answer = []

def calc(opd, opt):
    """
    재귀적으로 수식을 줄여가며 가능한 모든 계산 순서를 탐색
    :param opd: 현재 남아 있는 피연산자 리스트
    :param opt: 현재 남아 있는 연산자 리스트
    """
    # 더 이상 계산할 연산자가 없으면 결과를 저장 
    if len(opd) == 1:
        answer.append(opd) # 최종 계산된 숫자 하나가 결과
        return

    # 모든 연산자 위치를 하나씩 선택하여 계산 시도
    for i in range(len(opt)):
        # i번째 연산자를 적용하여 새로운 피연산자 리스트 생성
        # ex) [3, 8, 7], ['+', '*'] → (3+8)=11 → [11, 7]
        new_opd = opd[:i] + [matcher[opt[i]](opd[i], opd[i + 1])] + opd[i + 2:]

        # i번째 연산자를 제거한 새로운 연산자 리스트
        new_opt = opt[:i] + opt[i + 1:]

        # 줄어든 수식으로 재귀 호출
        calc(new_opd, new_opt)
    return

# 초기 호출: 전체 피연산자와 연산자 리스트로 시작
calc(digit, oper)
# 결과 리스트에서 가장 큰 값을 찾기
# 각 결과는 단일 숫자 리스트이므로, max를 사용하여 가장 큰 숫자를 찾음
print(max(answer)[0])
