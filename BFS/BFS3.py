# 백준 7562 BFS 문제 
# 처음에 문제를 보고 DFS문제라 생각했는데 그림을 그려 확인해보니 BFS 가 맞다.
# 최단거리를 구하는 문제는 BFS가 DFS보다 더 효과적이라는 것을 알았다.

from collections import deque

dx = (2, 1, -1, -2, -2, -1, 1, 2)   
dy = (1, 2, 2, 1, -1, -2, -2, -1)   # 8방향 이동경로

def bfs() : 
    queue = deque()
    queue.append((first_x,first_y)) # 시작 좌표를 큐에 대입

    while queue :   # 큐에 값이 있다면         
        x,y = queue.popleft()   # 큐에 있는 좌표를 x,y 에 각각 대입
        if x == goal_x and y == goal_y :             
            return chess[x][y]
        for i in range(8) : 
            nx = x + dx[i]
            ny = y + dy[i]

            if nx >= 0 and ny >= 0 and nx < l and ny < l :
                if chess[nx][ny] == 0 :
                    chess[nx][ny] = chess[x][y] + 1 
                    queue.append((nx,ny))

for _ in range(int(input())) :  # 테스트 케이스 횟수
    l = int(input())    # 체스 판의 가로, 세로 길이
    chess = [[0]*l for i in range(l)]   # 체스판
    first_x,first_y = map(int,input().split())  # 시작 좌표
    goal_x,goal_y = map(int,input().split())   # 목표 좌표

    print(bfs())