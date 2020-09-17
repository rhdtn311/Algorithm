# 백준 1427 소트인사이드

n=input()
n=sorted(n,reverse=True)

for i in range(len(n)) :
    print(n[i],end="")