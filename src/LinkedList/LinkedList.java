package LinkedList;

public class LinkedList {

    Node head;

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList insert(LinkedList list, int value) {
        Node newNode = new Node(value);
        if (list.head == null) {
            list.head = newNode;
        } else {
            Node last = list.head;
            while (last.next != null)
                last = last.next;
            last.next = newNode;
        }
        return list;
    }

    public LinkedList insertAtBeginning(LinkedList list, int value) {
        Node newNode = new Node(value);
        if (list.head == null)
            list.head = newNode;
        else {
            Node node = list.head;
            list.head = newNode;
            newNode.next = node;
        }
        return list;
    }

    public LinkedList insertAtIndex(LinkedList list, int index, int value) {
        Node newNode = new Node(value);
        if (list.head == null)
            list.head = newNode;
        Node node = list.head;
        int counter = 0;

        if (index == 0) {
            list = list.insertAtBeginning(list, value);
        } else {
            while (counter != (index - 1)) {
                if (node.next != null) {
                    node = node.next;
                } else
                    break;
                counter++;
            }
            Node previousData = node.next;
            node.next = newNode;
            newNode.next = previousData;
        }
        return list;
    }

    public void printList(LinkedList list) {
        Node node = list.head;
        System.out.println("Linked List");
        while (node != null) {
            if (node.next != null)
                System.out.print(node.value + "-->");
            else
                System.out.println(node.value);
            node = node.next;
        }
        System.out.println();
    }

    public LinkedList delete(LinkedList list, int value) {
        Node node = list.head;
        Node previous = null;
        while (node != null) {
            if (node.value == value) {
                if (previous == null) {
                    list.head = node.next;
                    break;
                } else {
                    previous.next = node.next;
                    break;
                }
            }
            previous = node;
            node = node.next;
        }
        if (node == null) {
            System.out.println("NO Found");
        } else {
            System.out.println("DELETED");
        }
        return list;
    }

    public LinkedList deleteByIndex(LinkedList list, int index) {
        Node node = list.head;
        int counter = 0;
        if (index == 0) {
            list.head = node.next;
        } else {
            while (counter != (index - 1)) {
                if (node != null) {
                    node = node.next;
                    counter++;
                } else {
                    System.out.println("Index Not Found");
                    break;
                }
            }
            if (node != null)
                node.next = node.next.next;
        }
        return list;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(list, 5);
        list.insert(list, 6);
        list.printList(list);
        list.insertAtBeginning(list, 4);
        list.insertAtBeginning(list, 8);
        list.printList(list);
        list.insertAtIndex(list, 2, 2);
        list.printList(list);
        list.insertAtIndex(list, 100, 10);
        list.printList(list);
        list.insertAtIndex(list, 4, 13);
        list.printList(list);
        list.deleteByIndex(list, 5);
        list.printList(list);
        list.deleteByIndex(list, 5);
        list.printList(list);
    }
}
