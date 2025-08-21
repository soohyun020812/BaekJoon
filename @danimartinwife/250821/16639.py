import re
import sys
import operator
from itertools import permutations

length = int(sys.stdin.readline())
expression = sys.stdin.readline()
matcher = {'*': operator.mul, '+': operator.add, '-': operator.sub, '/': operator.floordiv}
digit = list(map(int, re.findall('\\d', expression)))
oper = list(re.findall('\\D', expression))[:-1]
answer = []

def calc(opd, opt):
    if len(opd) == 1:
        answer.append(opd)
        return

    for i in range(len(opt)):
        new_opd = opd[:i] + [matcher[opt[i]](opd[i], opd[i + 1])] + opd[i + 2:]
        new_opt = opt[:i] + opt[i + 1:]
        calc(new_opd, new_opt)
    return

calc(digit, oper)
print(max(answer)[0])
