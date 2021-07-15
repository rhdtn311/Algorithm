package LinkedList;

import java.util.Arrays;

public class LinkedList {

    private Node head;
    private Node tail;
    private int size = 0;


    private class Node {

        private Object data;
        private Node next = null;

        public Node(Object data) {
            this.data = data;
        }
    }

    // list 출력
    @Override
    public String toString() {
        Node nowNode = head;

        StringBuilder nodeData = new StringBuilder();
        if (nowNode == null) {
            return "{}";
        }
        nodeData.append("{").append(nowNode.data);

        while(nowNode.next != null) {
            nowNode = nowNode.next;
            nodeData.append(", ").append(nowNode.data);
        }
        nodeData.append("}");

        return nodeData.toString();
    }

    // list 맨 앞에 데이터 삽입
    public void addFirst(Object data) {

        Node newNode = new Node(data);  // 삽입할 데이터를 가진 노드를 생성한다.

        newNode.next = head;    // 새로운 노드의 next 값을 head로 변경

        head = newNode; // head는 새로운 노드가 됌

        size++; // list 의 사이즈 증가

        if (head.next == null) {    // head 의 next 가 null 이라면 ( list 의 size 가 1이라면 )
            tail = newNode; // tail 은 새로운 노드
        }
    }

    public void addLast(Object data) {

        Node newNode = new Node(data);  // list 마지막에 넣을 노드 추가

        if (size == 0) {    // list의 사이즈가 0이라면
            this.addFirst(data); // addFirst 메소드로 노드 삽입
        } else {
            tail.next = newNode;    // tail Node의 next 값으로 newNode를 지정
            tail = newNode; // tail을 newNode로 지정
            size ++;    // size++
        }
    }

    public void removeFirst() {

        if (size != 0) {

            Node newHead = head.next;   // head의 다음 노드를 새로운 head로 지정

            head = newHead;

            size--; // size--

            if (size == 1) {
                tail = newHead;
            }

        }
    }

    public void removeLast() {

        Node node = head;
        if (size != 0) {
            while (node.next != tail) { // tail 노드의 바로 전 노드를 찾음
                node = node.next;
            }
            node.next = null; // tail 노드를 삭제
            tail = node;
            size--;
        }
    }
}
