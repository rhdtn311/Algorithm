# 백준 1496 신입사원 문제
# input() 보다 sys 모듈을 import 하여 sys.stdin.readline() 메소드를 사용하는 것이 더 빠르다는 것을 알았다. (이것 때문에 하루종일 고생)
# sys.stdin.readline() 은 input()과 같은 입력 장치지만 띄어쓰기나 \n같은 계행문자도 그대로 출력되기 때문에 .split() , .strip()을 적절히 함께 사용해야한다.

import sys 

t = int(input())

for i in range(t) :
    n = int(input())
    array = []
    result = 0
    for j in range(n) :
        array.append(tuple(map(int,sys.stdin.readline().split())))
    array.sort()

    min_data = array[0][1]

    for j in range(n) : 
        if min_data >= array[j][1] : 
            min_data = array[j][1]
            result += 1 

    print(result)
