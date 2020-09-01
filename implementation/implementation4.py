# 오류가 있는데 모르겠다. 다시 찾아봐야지

n,m = map(int,input().split())
x,y,direction = map(int,input().split()) 

d = [[0]*m for _ in range(n)]  # 이미 지나간 길을 저장
d[x][y] = 1 

dx = [-1,0,1,0] # 북 동 남 서
dy = [0,1,0,-1]

array = [] 
for i in range(m) : 
  array.append(list(map(int,input().split())))  # 바다와 육지를 포함한 맵 설정

def turn_left() :   # 왼쪽으로 회전 
  global direction 
  direction -= 1 
  if direction  == -1 : 
    direction = 3 

count = 1
game_over = 0

while True : 
  turn_left() # 첫 번째 규칙 ( 왼쪽으로 회전하기 )

  nx = x + dx[direction]  # 현재 x 좌표에 북 또는 남으로 이동할때의 값을 대입
  ny = y + dy[direction]  # 현재 y 좌표에 동 또는 서로 이동할 때의 값을 대입 
  
  if d[nx][ny] == 0 and array[nx][ny] == 0 :  # 아동 값을 방문한 적이 없거나 육지라면
    d[nx][ny] = 1 # 방문한 적이 있음으로 표시하고 
    count += 1 # 값을 올림
    x = nx  # 현재의 값을 수정
    y = ny  
    game_over = 0 
    continue 
  
  else : 
    game_over += 1 # 방문한 적이 있거나 바다라면 
  
  if game_over == 4 :  #동,서,남,북 어디로든 이동 불가능 하다면 
    nx = x -dx[direction] # 다음 이동 값은 현재 위치에서 뒤로 한 칸 이동
    ny = y -dx[direction]

    if array[nx][ny] == 0 : # 뒤에 육지가 있다면 
      x = nx  # 이동
      y = ny
    else : 
      break
    turn_time = 0

print(count)
