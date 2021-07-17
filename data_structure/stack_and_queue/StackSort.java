package stack_and_queue;

// 스택을 단 두 개만 사용하여 적은 숫자가 가장 위로오게 정렬하는 알고리즘
public class StackSort {

    public void method1(Stack stack) {

        // 임시 저장 스택
        Stack buffer = new Stack();

        /* 스택에서 원소 하나를 뽑아내 임시 변수(temp)에 저장한다. 만약 buffer 에 데이터가 존재한다면 buffer 의 데이터와
        *  temp 에 저장한 데이터를 비교하여 buffer 의 데이터가 더 크다면 buffer 의 데이터를 stack 으로 옮기고
        *  buffer 의 데이터가 더 작은 순간이 온다면 그 순간에 temp 의 데이터를 buffer 에 push 한다. 위 과정을 반복하면
        *  buffer 에는 가장 큰 데이터가 가장 위에 있고 가장 작은 데이터가 가장 아래에 있게 된다. 그 buffer 을 차례로 pop
        *  하여 stack 에 push 하면 stack 은 오름차순으로 정렬된다.
        */
        while(!stack.isEmpty()) {
            int temp = (Integer)stack.pop();

            while (!buffer.isEmpty() && temp < (Integer) buffer.peek()) {
                stack.push(buffer.pop());
            }
            buffer.push(temp);
        }

        while (!buffer.isEmpty()) {
            stack.push(buffer.pop());
        }
    }
}