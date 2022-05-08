package kakao2022intern;

import java.util.*;

public class Solution5 {


    public static void main(String[] args) {
//        Node node = new Node(0, true, null, null, null, null);
//        Node temp = new Node(node.data, node.isStart, node.up, node.down, node.left, node.right);
//        temp.data = 1010;
//        System.out.println(node);
//        System.out.println(temp);
        Solution5 s = new Solution5();
        int[][] solution = s.solution(new int[][]{{1, 2, 3,4}, {5, 6,7,8}, {9,10,11,12}}, new String[]{"Rotate", "ShiftRow"});
        System.out.println(Arrays.deepToString(solution));
    }

    static LinkedList<LinkedList<Node>> list = new LinkedList<>();

    static int colSize = 0;
    static int rowSize = 0;

    public static int[][] solution(int[][] rc, String[] operations) {

        colSize = rc[0].length;
        rowSize = rc.length;

        for (int i = 0; i < rc.length; i++) {
            list.add(new LinkedList<>());
        }

        int num = 1;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (i == 0 && j == 0) {
                    list.get(0).add(new Node(num, true, false, null, null, null, null));
                    num++;
                    continue;
                }

                boolean isLast = false;
                if (i == rowSize - 1 && j == 0) {
                    isLast = true;
                }

                Node leftNode = null, upNode = null;

                if (i > 0) upNode = list.get(i - 1).get(j);
                if (j > 0) leftNode = list.get(i).get(j - 1);

                Node nowNode = new Node(num, false, isLast ,upNode, null, leftNode, null);
                list.get(i).add(nowNode);

                if (i > 0) {
                    list.get(i - 1).get(j).down = nowNode;
                }

                if (j > 0) {
                    list.get(i).get(j - 1).right = nowNode;
                }
                num++;
            }
        }

        for (String operation : operations) {
            if (operation.equals("Rotate")) {
                rotate();
            } else {
                shiftRow();
            }
        }

        int start = 0;
        for (int i = 0; i < rowSize; i++) {
            if (list.get(i).get(0).isStart) {
                start = i;
            }
        }

        int count = 0;
        int[][] answer = new int[rowSize][colSize];
        while (true) {
            for (int i = 0; i < colSize; i++) {
                answer[count][i] = list.get(start).get(i).data;
            }

            start = start == rowSize - 1 ? 0 : start + 1;

            count++;
            if (count == rowSize) {
                break;
            }
        }

        return answer;
    }

    static void shiftRow() {
        int startIndex = 0;
        int lastIndex = 0;
        for (int i = 0; i < rowSize; i++) {
            if (list.get(i).get(0).isStart) {
                startIndex = i;
            }

            if (list.get(i).get(0).isLast) {
                lastIndex = i;
            }
        }

        list.get(startIndex).getFirst().isStart = false;
        list.get(lastIndex).getFirst().isStart = true;
        list.get(lastIndex).getFirst().isLast = false;

        list.get(lastIndex == 0 ? rowSize - 1 : lastIndex - 1).getFirst().isLast = true;


        int index = startIndex;
        for (int i = 0; i < colSize; i++) {
            Node startNode = list.get(startIndex).get(i);
            Node lastNode = list.get(lastIndex).get(i);
            Node prevLastNode = list.get(lastIndex == 0 ? rowSize - 1 : lastIndex - 1).get(i);
            startNode.up = lastNode;
            prevLastNode.down = null;
            lastNode.down = startNode;
            lastNode.up = null;
        }
    }

    static void rotate() {
//        int startIndex = 0;
//        int lastIndex = 0;
//        for (int i = 0; i < rowSize; i++) {
//            if (list.get(i).get(0).isStart) {
//                startIndex = i;
//            }
//
//            if (list.get(i).get(0).isLast) {
//                lastIndex = i;
//            }
//        }
//
//        Node startNode = list.get(startIndex).get(0);
//        Node startDownNode = list.get(startIndex == rowSize - 1 ? 0 : startIndex + 1).get(0);
//        Node lastNode = list.get(lastIndex).get(0);
//        Node lastUpNode = list.get(lastIndex == 0 ? rowSize - 1 : lastIndex - 1).get(0);
//
//        startNode.left = startDownNode;
//        lastNode.right = lastUpNode.right;
//        lastNode.down = lastNode.right;
//
//
//        for (int i = 0; i < colSize - 2; i++) {
//            Node upNode = list.get(startIndex).get(i);
//            Node downNode = list.get(startIndex == rowSize - 1 ? 0 : startIndex + 1).get(i + 1);
//
//            upNode.down = downNode;
//            downNode.up = upNode;
//        }
//        list.get(startIndex - 1).get(colSize - 1).down = list.get(startIndex - 1).get(colSize - 1).right;
//        list.get(startIndex - 1).get(colSize - 1)
//
//        for (int i = colSize - 1; i > 1; i--) {
//            Node downNode = list.get(lastIndex).get(i);
//            Node upNode = list.get(lastIndex == 0 ? rowSize - 1 : lastIndex - 1).get(i - 1);
//
//            downNode.up = upNode;
//            upNode.down = downNode;
//        }
//        list.get(lastIndex).get(0).up = list.get(lastIndex).get(0).left;
//        list.get(lastIndex == 0 ? )
//
//        for (int i = 0; i < )
    }

    static class Node {
        int data;
        boolean isStart;
        boolean isLast;
        Node up;
        Node down;
        Node left;
        Node right;

        public Node(int data ,boolean isStart,boolean isLast, Node up, Node down, Node left, Node right) {
            this.data = data;
            this.isStart = isStart;
            this.isLast = isLast;
            this.up = up;
            this.down = down;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", isStart=" + isStart +
                    ", isLast=" + isLast +
                    ", up=" + (up == null ? "0" : up.data) +
                    ", down=" + (down == null ? "0" : down.data) +
                    ", left=" + (left == null ? "0" : left.data) +
                    ", right=" + (right == null ? "0" : right.data) +
                    '}';
        }
    }
}
