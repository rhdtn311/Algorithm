n = int(input())
in_put = input().split() 

x_position = 1
y_position = 1

for move in in_put :
  if move == "U" : 
    if x_position == 1 :
      continue
    x_position -= 1
    
  elif move == "D" :
    if x_position == n : 
      continue
    x_position += 1

  elif move == "R" :
    if y_position == n :
      continue
    y_position += 1
  
  elif move == "L" :
    if y_position == 1 :
      continue
    y_position -= 1

print(str(x_position), str(y_position))
