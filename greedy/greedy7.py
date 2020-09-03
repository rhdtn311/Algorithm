# 백준 그리디 알고리즘 10162번 문제 ( https://www.acmicpc.net/problem/10162 )

n = int(input())
count1,count2,count3 = 0,0,0

while n != 0 :
  if n >= 300 : 
    count1 += n // 300
    n %= 300
  elif 300 > n and n >= 60 :
    count2 += n // 60
    n %= 60
    
  elif 60 > n and n>=10 : 
    count3 += n // 10
    n %= 10
    
  else :
    count1,count2,count3 = None,None,None
    print(-1)
    break

if count1 != None and count2 !=None and count3 != None :
  print(count1,count2,count3)
else : pass