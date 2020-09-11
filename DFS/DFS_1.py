#  백준 2210번 숫자판 점프 문제 

def dfs(x,y,number) :   # 함수 dfs를 선언하고 (x좌표, y좌표, 더해질 숫자(str) 값을 파라미터로 정의한다.)
    if len(number) == 6 :   # 계속 추가된 값의 길이가 6이라면
        result.add(number)  # 결과 값에 추가한다.
        return result
    
    dx = [0,0,-1,1]
    dy = [1,-1,0,0]

    for i in range(4) : 
        nx = x + dx[i]
        ny = y + dy[i]

        if nx >= 0 and ny >= 0 and nx < 5 and ny < 5 :  # 다음 좌표가 5X5 배열 안에 존재한다면
            dfs(nx,ny,number+graph[nx][ny])  # 다음 좌표에 대한 재귀함수를 호출하고 number에 number+graph[nx][ny]를 해줌으로서 얻은 값을 더해준다.(str로)

result = set()  # 중복되는 값이 없어야 하기 때문에 result 는 set로 선언한다.
graph = [list(map(str,input().split())) for _ in range(5) ] 

for i in range(5) :
    for j in range(5) :     # 모든 배열에 대하여 dfs를 호출한다.
        dfs(i,j,graph[i][j])    # 좌표 (0,0) 에서 (4,4) 까지, 값 graph[0][0] 에서 값 graph[4][4] 까지 모두 dfs를 수행한다.

print(len(result))