INF = int(1e9)  # 무한대를 나타내는 INF

n,m = map(int,input().split())  # n는 노드의 개수, m은 간선의 개수 
graph = [[INF] * (n + 1) for _ in range(n + 1)]  # 2차원 리스트를 모두 무한대의 값으로 초기화

# 자기 자신까지의 거리는 0으로 초기화
for a in range(1,n+1) :     
    for b in range(1,n+1) :
        if a == b :
            graph[a][b] = 0

# 간선에 대한 정보를 graph에 입력
for _ in range(m) : 
    a, b, c = map(int,input().split())
    graph[a][b] = c

# 플로이드 워셜 알고리즘 수행 k는 현재 수행중인 노드, a는 출발노드 b는 도착노드
for k in range(1, n+1) : 
    for a in range(1, n+1) : 
        for b in range(1, n+1) :
            graph[a][b] = min(graph[a][b],graph[a][k]+graph[k][b])

# 출력
for a in range(1, n+1) : 
    for b in range(1, n+1) :
        if graph[a][b] == INF : 
            print("INFINITY", end = " ")
        else : 
            print(graph[a][b], end= " ")
    print()