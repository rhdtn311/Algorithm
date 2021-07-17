package stack_and_queue;

public class Queue {
    private Node first; // 가장 먼저 들어간 노드
    private Node last;  // 가장 최근에 들어간 노드


    private class Node {

        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }
    }

    // 리스트의 끝부분에 노드 추가
    public void add(Object data) {

        Node newNode = new Node(data);

        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
    }

    // 리스트의 첫 번째 항목 제거
    public Object remove() {
        if (first == null ) {
            System.out.println("삭제할 노드가 없습니다.");
        } else {
            Object data = first.data;
            first = first.next;
            return data;
        }
        return null;
    }

    // 큐에서 가장 위에 있는 항목을 반환
    public Object peek() {

        return first.data;

    }

    // 큐가 비었는지 확인
    public boolean isEmpty() {
        if (first != null) {
            return false;
        }
        return true;
    }

    // 큐를 출력
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("{");

        Node node = first;
        while (node != null) {
            s.append(node.data);
            if (node.next != null) {
                s.append(", ");
            }
            node = node.next;
        }
        s.append("}");

        return s.toString();
    }
}
