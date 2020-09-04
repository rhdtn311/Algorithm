from collections import deque   # deque 라이브러리를 불러옴

def bfs(graph,start,visited) :  # BFS 메서드를 정의 (그래프, 시작노드, 방문 노드 리스트)
    queue = deque([start])  # deque 라이브러리를 이용하여 큐를 구현. queue 에는 시작노드를 삽입
    visited[start] = True   # 시작 노드를 방문 노드 리스트에 추가

    while queue :   # 큐에 하나라도 데이터가 있다면 반복
        v = queue.popleft() # v 라는 변수를 만들어 queue에 가장 먼저 들어간 노드를 v에 삽입 (first in firt out)
        print(v,end= " ")   # v를 출력

        for i in graph[v] : # 주어진 그래프에 현재 꺼낸 노드(v)와 인접한 노드들을 순서대로 i에 삽입한다.
            if not visited[i] : # 인접노드인 i가 방문하지 않은 노드라면 
                queue.append(i) # i를 queue에 추가하고 
                visited[i] = True   # i노드를 방문 노드 리스트에 추가한다.

graph = [ 
    [],
    [2,4,8],
    [1,7],
    [1,4,5],
    [3,5],
    [3,4],
    [7],
    [2,6,8],
    [1,7]
]

visited = [False] * 9 

bfs(graph,1,visited)