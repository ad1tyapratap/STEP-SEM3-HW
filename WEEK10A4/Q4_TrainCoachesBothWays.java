public class Q4_TrainCoachesBothWays {

    static class Node {
        String name;
        Node prev, next;

        Node(String name) {
            this.name = name;
        }
    }

    static Node head, tail;

    static void addLast(String name) {
        Node n = new Node(name);

        if (head == null) {
            head = tail = n;
        } else {
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
    }

    static void remove(String name) {
        Node temp = head;

        while (temp != null && !temp.name.equals(name))
            temp = temp.next;

        if (temp == null)
            return;

        if (temp == head)
            head = temp.next;
        else
            temp.prev.next = temp.next;

        if (temp == tail)
            tail = temp.prev;
        else
            temp.next.prev = temp.prev;
    }

    static void printForward() {
        Node temp = head;
        System.out.print("Forward: ");

        while (temp != null) {
            System.out.print(temp.name);
            if (temp.next != null)
                System.out.print(" <-> ");
            temp = temp.next;
        }
        System.out.println();
    }

    static void printBackward() {
        Node temp = tail;
        System.out.print("Backward: ");

        while (temp != null) {
            System.out.print(temp.name);
            if (temp.prev != null)
                System.out.print(" <-> ");
            temp = temp.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        addLast("Engine");
        addLast("A1");
        addLast("B1");
        addLast("B2");
        addLast("Guard");

        remove("B1");

        printForward();
        printBackward();
    }
}