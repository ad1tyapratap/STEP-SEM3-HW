public class Q1_PriorityTokenInsertion {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    static Node head;

    static void addFirst(int token) {
        Node n = new Node(token);
        n.next = head;
        head = n;
    }

    static void addLast(int token) {
        Node n = new Node(token);

        if (head == null) {
            head = n;
            return;
        }

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = n;
    }

    static void insertAt(int index, int token) {
        if (index == 0) {
            addFirst(token);
            return;
        }

        Node temp = head;

        for (int i = 0; i < index - 1; i++)
            temp = temp.next;

        Node n = new Node(token);
        n.next = temp.next;
        temp.next = n;
    }

    static void printList() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        addLast(101);
        addLast(102);
        addLast(103);

        addFirst(100);
        addLast(104);
        insertAt(2, 150);

        printList();
    }
}