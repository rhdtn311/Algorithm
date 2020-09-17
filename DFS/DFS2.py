# 백준 1260 DFS 문제 
n = int(input())+1  # n은 노드수 (문제는 1번 노드부터 시작이므로 +1을 해준다.)
m = int(input())    # m은 노드와 연결된 간선의 수
graph = []  # 처음 입력 받을 그래프
for i in range(m) : 
    graph.append(list(map(int,input().split())))

computer = [[] for _ in range(n)] # graph를 정렬시킨 그래프
for j,k in graph : 
    computer[j].append(k)  # computer의 j번째 인덱스에 k를 대입
    computer[k].append(j)  # computer의 k번째 인덱스에 j를 삽입
# 즉 computer에는 0번 노드부터 n번 노드까지 n번 인덱스는 n번 노드를 나타내며
# 숫자는 그 노드와 연결된 다른 노드를 의미한다.

visited = [False] * n   
count = 0
def dfs(computer,v,visited) :   #dfs 함수를 선언 
    visited[v] = True   
    global count
    count += 1

    for i in computer[v] :
        if not visited[i] : 
            dfs(computer,i,visited)
    
    return count-1

print(dfs(computer,1,visited))
