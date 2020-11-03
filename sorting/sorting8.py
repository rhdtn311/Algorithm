# 백준 11656 접미사배열 문제

s = input()
array = []

for i in range(len(s)) :
    array.append(s[i:])

array.sort()
for i in array : 
    print(i)
