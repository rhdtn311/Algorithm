# 백준 14716 현수막 문제 
# 백준 4963 섬의 개수 문제와 똑같다. 복습하는 김에 풀었는데 while queue 문이 if graph[i][j] == 1 :
# 안에 있어야 한다는 것을 알았다. 밖에 있으면 2중 for문이 실행될 때마다 result가 1씩 올라가고
# queue에 값이 있다 하더라도 바로 while 문에서 queue를 pop해주기 때문에 항상 else 문이 실행되게된다.

from collections import deque

m,n = map(int,input().split())
graph = [] 
for _ in range(m) : 
    graph.append(list(map(int,input().split())))

dx = [-1,1,0,0,1,1,-1,-1]
dy = [0,0,1,-1,1,-1,1,-1]

result = 0
queue = deque()
for i in range(m) : 
    for j in range(n) : 
        if graph[i][j] == 1 : 
            graph[i][j] = 2 
            queue.append((i,j))           
        
            while queue :                 
                x,y = queue.popleft()
                for k in range(8) : 
                    nx = x + dx[k]
                    ny = y + dy[k]

                    if nx >= 0 and ny >= 0 and nx < m and ny < n : 
                        if graph[nx][ny] == 1 : 
                            queue.append((nx,ny))
                            graph[nx][ny] = 2        
            else : result += 1 

print(result)