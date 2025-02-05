# 최대공약수와 최소공배수 

import math

a, b = map(int, input().split())

# 최대공약수
gcd = math.gcd(a, b) 
# 최소공배수 (공식 : a * b = gcd * lcm)
lcm = (a * b) // gcd 

print(gcd)
print(lcm)