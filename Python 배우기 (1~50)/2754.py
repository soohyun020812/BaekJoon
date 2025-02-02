# 학점계산 

# Dictionary : 키(Key)와 값(Value)을 쌍으로 저장하는 자료구조
# 성적과 평점을 매핑하는 딕셔너리 생성 ({} 또는 dict())
grade_to_gpa = {
    "A+": 4.3, "A0": 4.0, "A-": 3.7,
    "B+": 3.3, "B0": 3.0, "B-": 2.7,
    "C+": 2.3, "C0": 2.0, "C-": 1.7,
    "D+": 1.3, "D0": 1.0, "D-": 0.7,
    "F": 0.0
}

grade = input().strip()

print(grade_to_gpa[grade])

'''
딕셔너리 예제

scores = {
    "lee": 95,
    "kim": 80,
    "park": 88
}

# 95 출력
print(scores["lee"]) 
'''