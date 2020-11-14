# 백준 2805번 나무자르기 문제

n,m = map(int,input().split())
trees = list(map(int,input().split()))

# 절단기는 가장 큰 나무보다 작아야 하기 때문에 가장 큰 나무를 max 값으로 지정
start = 0
end = max(trees)    
while start <= end : 
    
    mid = (start + end) // 2  # mid는 절단기의 길이
    print("start=",start,"end=",end,"mid=",mid,end=" ")
    target = 0  # 자르고 난 후의 나무길이를 더하기 위한 변수
    for i in trees :  # 나무가 잘린다면 target에 다 더함.
        if i > mid : 
            target += (i-mid)

    if target >= m :  # 잘린 나무 길이의 합이 목표 길이보다 길거나 같으면 시작 값을 크게 함으로써 절단기 값을 키움.
        result = mid  # 절단기의 길이가 최대가 될 때 정답
        start = mid + 1
    else :
        end = mid - 1
    print("target=",target)


print(result)


