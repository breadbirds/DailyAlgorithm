arr = []

for i in range(20):
    arr.append(list(input().split()))
        
# 학점 총합
score_hap = 0
aaa = 0

for _, score, grade in arr:
    if grade == "P":
        continue
    
    score = float(score)
    
    # 계산!
    score_hap += score
    
    aa = 0.0
    if grade == "A+":
        aa = 4.5
    elif grade == "A0":
        aa = 4.0
    elif grade == 'B+':
        aa = 3.5
    elif grade == 'B0':
        aa = 3.0
    elif grade == 'C+':
        aa = 2.5
    elif grade == 'C0':
        aa = 2.0
    elif grade == 'D+':
        aa = 1.5
    elif grade == 'D0':
        aa = 1.0
    else:
        aa = 0.0
    
    # 학점*과목평점 합 구하기
    aaa += (score * aa)
    
    
print(aaa/score_hap)
    