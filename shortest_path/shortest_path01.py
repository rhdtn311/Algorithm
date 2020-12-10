# 이것이 코딩 테스트다 with 파이썬 (나동빈) 미래도시 문제

INF = int(1e9)
n,m = map(int,input().split())
graph = [[INF] * (n+1) for _ in range(n+1)]

# 간선의 정보 초기화
for _ in range(m) : 
    a,b = map(int,input().split())
    graph[a][b] = 1 
    graph[b][a] = 1

# 자기 자신으로 가는 건 0으로 초기화
for i in range(n+1) :
    for j in range(n+1) :
        if i == j : 
            graph[i][j] = 0

# 도착지와 경유지 지정
x,k = map(int,input().split())

# 플로이드- 워셜 알고리즘 수행
for k in range(1,n+1) :
    for a in range(1,n+1) :
        for b in range(1,n+1) :
            graph[a][b] = min(graph[a][b], graph[a][k]+graph[k][b])

# 알고리즘을 수행 후 1번 노드에서 출발하여 k번 노드를 경유하고 x번 노드로 도착하는 최솟값을 distance에 저장
distance = graph[1][k] + graph[k][x]

#출력
if distance >= INF : 
    print(-1)
else : 
    print(distance)