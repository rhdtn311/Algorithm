package stack_and_queue;

// Queue 는 First In First Out
// Stack 은 Last In First Out
// stack1에는 push 할 때 모든 원소를 담고, stack2에는 pop 할 때 stack1에 있는 모든 원소를 pop 하여 stack2에 담은 뒤
// stack2에서 pop 을 하여 역순으로 pop 할 수 있게 한다. 다시 push 가 나온다면 stack2에 있는 모든 원소를 pop 을 하여
// 다시 stack1에 담은 뒤 stack1에 원소를 push 한다.
public class MakeQueueUseTwoStacks extends Stack{

    Stack stack1 = new Stack();
    Stack stack2 = new Stack();

    public class Node {    // 값을 갖는 노드

        public Object data;    // 값
        private Node next;  // 바로 전에 들어온 노드

        public Node(Object data) {
            this.data =data;
        }

    }

    public void push(Object data) {

        Node newNode = new Node(data);

        if (stack2.isEmpty()) {
            stack1.push(newNode);
        } else {
            while(!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            stack1.push(newNode);
        }
    }

    public Object pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        } else {
            return stack2.pop();
        }
    }

    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append(stack1);

        return s.toString();
    }
}
