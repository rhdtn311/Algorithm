package stack_and_queue;

import java.util.ArrayList;

// 일정 용량 이상 쌓이면 다른 스택을 생성해서 저장하는 자료구조 : SetOfStacks
public class SetOfStacks {

    ArrayList<Stack> arrayList = new ArrayList<>();
    int capacity;

    public class Node {    // 값을 갖는 노드

        public Object data;    // 값
        private Stack.Node next;  // 바로 전에 들어온 노드

        public Node(Object data) {
            this.data =data;
        }

    }

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    public void push(Object data) {

        Node node = new Node(data);

        if (arrayList.size() == 0) {
            Stack firstStack = new Stack();
            firstStack.push(node);
            arrayList.add(firstStack);
        } else {

            Stack stack = arrayList.get(arrayList.size() - 1);

            if (stack.size == capacity) {
                Stack newStack = new Stack();
                newStack.push(node);
                arrayList.add(newStack);
            } else {
                stack.push(node);
            }
        }
    }

    public void pop() {
        Stack stack = arrayList.get(arrayList.size() - 1);

        if (stack.isEmpty()) {
            arrayList.remove(arrayList.size()-1);
            Stack newFinalStack = arrayList.get(arrayList.size() - 1);
            newFinalStack.pop();
        } else {
            stack.pop();
        }

    }

    public static void main(String[] args) {
        SetOfStacks stacks = new SetOfStacks(3);
        stacks.push(1);
        stacks.push(2);
        stacks.push(3);
        stacks.push(4);
        stacks.push(5);
        stacks.push(6);
        stacks.push(7);
        stacks.pop();
        stacks.pop();
        System.out.println(stacks.arrayList.size());

        Stack stack = stacks.arrayList.get(0);
        Object peek = stack.peek();
        System.out.println(stack.stackToString());
    }

}
