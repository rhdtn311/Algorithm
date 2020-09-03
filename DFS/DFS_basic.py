# 재귀함수를 이용한 기본 DFS 알고리즘 
# graph 는 주어질 그래프, v는 최상단 노드, visited 는 방문한 노드를 기록
n = 1 # 주어질 그래프의 노드 수 

def dfs (graph,v,visited) :
  visited[v] = True 
  print(v,end=" ")

  for i in graph[v] : 
    if not visited[i] :
      dfs(graph,i,visited)  # 재귀 함수를 이용하여 스택의 성질을 구현

visited = [False] * (n+1) # 노드는 1번 노드부터 시작이기 때문에 n+1을 해준다.
