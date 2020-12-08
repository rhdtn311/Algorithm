import heapq
import sys
imput = sys.stdin.readline
INF = int(1e9)

n,m = map(int,input().split())	# 노드, 간선
start = int(input())	# 시작 노드
graph = [[] for i in range(n+1)]	# 노드의 연결 정보 리스트
distance = [INF] * (n+1)	# 최단 경로 값을 저장하는 테이블

for _ in range(m) :	# 간선의 정보 입력 및 graph 리스트에 저장
    a, b, c = map(int,input().split())
    graph[a].append((b,c))
    
def dijkstra(start) : 
    q = []
    # 시작 값 저장
    heapq.heappush(q, (0,start))	# q라는 heap자료구조에 (거리 : 0, 노드 : 시작노드) 값 입력
    distance[start] = 0	
    while q : # q에 데이터가 있으면
        dist, now = heapq.heappop(q)	# dist는 거리, now는 노드의 값을 저장 (거리가 min인 값)
        if  distance[now] < dist : 	# 현재 노드가 이미 처리된 적 있으면 무시
            continue
        for i in graph[now] :	# 현재 노드의 인접 노드를 확인
            cost = dist + i[1]	
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost,i[0]))
                
dijkstra(start)

for i in range(1, n+1) :
    if distance[i] == INF : 
        print("INFINITY")
    else : 
        print(distance[i])