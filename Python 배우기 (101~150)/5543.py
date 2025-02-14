# 상근날드

burger1 = int(input())
burger2 = int(input())
burger3 = int(input())

drink1 = int(input())
drink2 = int(input())

# 가장 저렴한 햄버거와 음료 선택
min_burger = min(burger1, burger2, burger3)
min_drink = min(drink1, drink2)

# 세트 메뉴 가격 계산
set_price = min_burger + min_drink - 50

print(set_price)