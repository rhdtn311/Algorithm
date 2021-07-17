package stack_and_queue;

public class Stack {

    private Node last;  // 가장 최근에 들어온 노드
    public int size;   // 노드 수

    public static class Node {    // 값을 갖는 노드

        private Object data;    // 값
        private Node next;  // 바로 전에 들어온 노드

        public Node(Object data) {
            this.data =data;
        }

    }

    // 스택 출력 ( 가장 먼저 들어온 노드가 가장 뒤에 )
    public String stackToString() {
        StringBuilder s = new StringBuilder();
        s.append("{");

        Node node = last;
        while (node != null) {
            s.append(node.data);
            if(node.next != null) {
                s.append(", ");
            }
            node = node.next;
        }
        s.append("}");

        return s.toString();
    }

    public void push(Object data) {
        Node newNode = new Node(data);

        newNode.next = last;    // 가장 최근에 들어왔던 노드를 이 노드의 다음 노드로 설정
        last = newNode; // 가장 최근 노드를 이 노드로 설정
        size++;
    }

    public Object pop() {

        if (last == null) {
            System.out.println("널값입니다.");
        } else {
            Object data = last.data;    // 가장 최근에 들어온 노드의 값
            last = last.next;   // 가장 최근 노드의 다음 노드를 가장 최근 노드로 설정
            size--;
            return data;
        }
        return null;
    }

    public Object peek() {

        if (last == null) {
            System.out.println("널값입니다.");
        } else {
            return last.data;   // 가장 최근에 들어온 노드의 값을 반환
        }

        return last.data;
    }

    public boolean isEmpty() {
        if (last == null) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Stack stack= new Stack();

        System.out.println(stack.size);




    }
}
