from collections import deque 

dx = (2, 1, -1, -2, -2, -1, 1, 2)
dy = (1, 2, 2, 1, -1, -2, -2, -1)

def bfs() : 
    queue = deque()
    queue.append((first_x,first_y))

    while queue : 
        x,y = queue.popleft()

        if x == goal_x and y == goal_y :
            return chess[x][y]

        for i in range(8) : 
            nx = x + dx[i]
            ny = y + dy[i]

            if nx >= 0 and ny >= 0 and nx < l and ny < l :
                if chess[nx][ny] == 0 : 
                    chess[nx][ny] = chess[x][y] + 1 
                    queue.append((nx,ny))

for _ in range(int(input())) : 
    l = int(input())
    chess = [[0] * l for j in range(l)]
    first_x,first_y = map(int,input().split())
    goal_x,goal_y = map(int,input().split())

    print(bfs())