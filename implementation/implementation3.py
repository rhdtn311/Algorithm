# 처음에 x좌표와 y좌표를 따로 for문을 이용하여 대입했는데 한 번에 대입하는 법을 알아냈다.

position = input()
x_position = int(ord(position[0])) - ord("a") + 1   # x좌표를 아스키 코드를 활용하여 숫자로 표현(1~8)
y_position = int(position[1])   # y좌표를 숫자로 표현
count = 0

steps = [(-2,-1), (-2,1), (2,1), (2,-1), (-1,2),(1,2), (-1,-2), (1,-2)] # 나이트가 움직일 수 있는 범위를 x,y 좌표를 합쳐서 리스트 안 튜플로 표현

for step in steps :     
  next_x = step[0] + x_position # 이동할 x좌표
  next_y = step[1] + y_position # 이동할 y좌표 

  if next_x <= 8 and next_x >= 1 and next_y >= 1 and next_y <= 8 :  # 궁극적으로 이동할 수 있는 곳이 범위 안을 만족한다면
    count += 1  # 경우의 수에 포함시킨다.

print(count)
