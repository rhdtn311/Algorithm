# 백준 2437 저울 문제 2021/01/08

''' 
혼자 생각하다가 도저히 못풀겠어서 코드를 봤다. 문제를 푸는 방법은
오름차순으로 정렬되어 있는 배열을 기준으로 가장 작은수부터 시작하여
현재까지의 누적합 + 1 < 다음 수 라면 현재까지의 누적합 +1이 만들 수 
없는 최소의 무게가 된다. 
'''

n = int(input())
array = list(map(int,input().split()))
array.sort()

num = 0
for i in range(len(array)) : 
    if num + 1 < array[i] : 
        break
    else : 
        num += array[i]

print(num+1)