# 오늘 날짜 

from datetime import datetime

# 현재 날짜 가져오기
today = datetime.today()

# YYYY-MM-DD 형식으로 출력
print(today.strftime("%Y-%m-%d"))