n = int(input())
count = 0
asdf= 0

for i in range(n+1) :
  for j in range(60) :
    for k in range(60) :
      if "3" in str(i) + str(j) + str(k) : # 시, 분, 초를 문자열로 바꾸어서 3시 10분 20초를 031020 이라는 문자로 바꾸어서 그 문자열 안에 3이라는 문자가 있는지 확인.
        count += 1
      
     
print(count)
