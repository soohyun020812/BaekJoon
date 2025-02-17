# ROT13

def rot13(text):
    result = []
    
    for char in text:
        # 대문자 처리
        '''
        ord(char) - ord('A') : A를 0으로 변환
        +13 : 13글자 이동
        %26 : Z를 넘어가면 다시 A부터 시작
        + ord('A') : 다시 문자로 변환
        '''
        if 'A' <= char <= 'Z': 
            result.append(chr((ord(char) - ord('A') + 13) % 26 + ord('A')))
        # 소문자 처리
        elif 'a' <= char <= 'z': 
            result.append(chr((ord(char) - ord('a') + 13) % 26 + ord('a')))
        # 알파벳이 아닌 경우 그대로 저장
        else: 
            result.append(char)
    
    return ''.join(result)

S = input()

print(rot13(S))

# ord() : 문자의 아스키(유니코드) 값을 반환
# chr() : 아스키(유니코드) 값을 문자로 변환
# %26 연산을 통해 알파벳 범위를 벗어나지 않게 함