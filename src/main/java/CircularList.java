/*
You are given a list of numbers.
When you reach the end of the list you will come back to the beginning of the list (a circular list).
Write the most efficient algorithm to find the minimum # in this list.
Find any given # in the list.
The numbers in the list are always increasing but
you don’t know where the circular list begins, ie: 38, 40, 55, 89, 6, 13, 20, 23, 36.
*/

class CircularListNode {
    Integer number;
    CircularListNode next;

    CircularListNode(Integer number) {
        this.number = number;
    }
}

class CircularList {

    private CircularListNode head = null;
    private CircularListNode tail = null;
    private int size = 0;

    private void insert(CircularListNode node) {
        if (size == 0) {
            head = node;
            tail = node;
            node.next = head;
        } else {
            tail.next = node;
            tail = node;
            tail.next = head;
        }
        size++;
    }

    private CircularListNode getByIngex(Integer index) {
        if (index > size) {
            return null;
        }
        CircularListNode node = head;
        while (index - 1 != 0) {
            node = node.next;
            index--;
        }
        return node;
    }

    private Integer findMinimum(Integer index) {
        Integer min = null;
        CircularListNode node = getByIngex(index);
        if (node != null) {
            min = findMinimum(node);
        }
        return min;
    }

    private Integer findMinimum(CircularListNode node) {
        int numberOfIterations = 0;
        Integer min = node.number;
        CircularListNode next = node.next;
        while (next != node) {
            numberOfIterations++;
            if (next.number < min) {
                min = next.number;
                break;
            }
            next = next.next;
        }
        System.out.println("Number of iterations = " + numberOfIterations);
        return min;
    }

    public static void main(String[] args) {
        CircularList list = new CircularList();
        list.insert(new CircularListNode(6));
        list.insert(new CircularListNode(13));
        list.insert(new CircularListNode(20));
        list.insert(new CircularListNode(23));
        list.insert(new CircularListNode(36));
        list.insert(new CircularListNode(38));
        list.insert(new CircularListNode(40));
        list.insert(new CircularListNode(55));
        list.insert(new CircularListNode(89));
        System.out.println(list.findMinimum(1));
    }

}

class CircularListAlternative {

    private static Integer findMinimum(CircularListNode node) {
        int numberOfIterations = 0;
        Integer min = node.number;
        CircularListNode next = node.next;
        while (next != node) {
            numberOfIterations++;
            if (next.number < min) {
                min = next.number;
                break;
            }
            next = next.next;
        }
        System.out.println("Number of iterations = " + numberOfIterations);
        return min;
    }

    public static void main(String[] args) {
        CircularListNode nine = new CircularListNode(36);
        CircularListNode eight = new CircularListNode(23);
        CircularListNode seven = new CircularListNode(20);
        CircularListNode six = new CircularListNode(13);
        CircularListNode five = new CircularListNode(6);
        CircularListNode four = new CircularListNode(89);
        CircularListNode three = new CircularListNode(55);
        CircularListNode two = new CircularListNode(40);
        CircularListNode one = new CircularListNode(38);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = eight;
        eight.next = nine;
        nine.next = one;

        System.out.println(findMinimum(one));
    }

}

