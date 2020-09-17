# 두 배열의 원소 교체

n,k = map(int,input().split()) 
for _ in range(2) : 
    if _ == 0 : 
        a = list(map(int,input().split()))
    else : 
        b = list(map(int,input().split()))

a.sort()
b.sort(reverse=True)

for i in range(k) :
    if a[i] < b[i] : 
        a[i],b[i] = b[i],a[i]
    else: break

print(sum(a))
