# 백준 1260번 DFS와 BFS

import sys
from collections import deque

n,m,v = map(int,sys.stdin.readline().split())   # 정점의 개수 n, 간선의 개수 m, 시작할 정점의 번호v
array=[]    # 입력값을 받을 임시의 배열 선언
graph = [[] for _ in range(n+1) for _2 in range(1)] # array에 있는 배열을 인접리스트로 저장할 배열

for _ in range(m) : 
    array.append(list(map(int,sys.stdin.readline().split())))

for i,j in array :  # array의 연결 노드를 받아 인접 리스트로 변환 
    graph[i].append(j)  
    graph[j].append(i)  

for k in range(len(graph)) : # 더 작은 노드부터 탐색하기 위해 정렬
    graph[k].sort()

def bfs(graph,visited,start) :  # bfs 함수 선언
    queue = deque([start])
    visited[start] = True

    while queue :
        v = queue.popleft()
        print(v,end=" ")
        for i in graph[v] : 
            if not visited[i] : 
                queue.append(i)
                visited[i] = True

def dfs(graph,v,visited) :  # dfs 함수 선언
    print(v,end=" ")
    visited[v] = True
    for i in graph[v] : 
        if not visited[i] : 
            dfs(graph,i,visited)

visited= [False] * (n+1)    # 방문했는지 검사하는 배열 초기화
dfs(graph,v,visited)
print()
visited= [False] * (n+1)
bfs(graph,visited,v)
