# 백준 2217번 로프문제 2021/01/08

''' 
로프들을 들 수 있는 무게 순으로 내림차순으로 정렬한다. 그리고
n번째에 있는 로프가 들 수 있는 무게 * n의 값이 가장 큰 값이 답이라 할 수 있다.
'''

n = int(input())    # 로프의 개수
array = []  # 로프를 담을 배열

# 배열에 로프를 담음
for _ in range(n) :
    array.append(int(input()))

# 로프가 들 수 있는 중량을 기준으로 내림차순으로 정렬
array.sort(reverse=True)

# 가장 무거운 무게를 들 수 있는 로프가 우선 선택된다.
maxWeight = array[0]

# 만약 첫 번째~ n 번째 로프가 들 수 있는 무게를 합한 무게가 더 무겁다면 그것에 maxWeight
for i in range(1,len(array)) : 
    if maxWeight < array[i]*(i+1) :
        maxWeight = array[i]*(i+1)

print(maxWeight)