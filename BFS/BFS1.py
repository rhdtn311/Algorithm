from collections import deque

while True : 
    w,h = map(int,input().split())  
    if w == 0 and h == 0 :  
        break
    graph = [list(map(int,input().split())) for _ in range(h)]  

    dx = [-1,1,0,0,1,1,-1,-1]   
    dy = [0,0,1,-1,1,-1,1,-1]

    queue = deque() 
    result = 0  
    for i in range(w) : 
        for j in range(h) : 
            if graph[i][j] == 1 :   
                queue.append((i,j)) 
                graph[i][j] = 2 
                while queue : 
                    x,y = queue.popleft()   
                    for k in range(8) : 
                        nx = x + dx[k]  
                        ny = y + dy[k]

                        if nx >= 0 and ny >= 0 and nx < h and ny < w :  
                            if graph[nx][ny] == 1 : 
                                queue.append((nx,ny))  
                                graph[nx][ny] = 2   
                    
                else : result += 1  

    print(result) 