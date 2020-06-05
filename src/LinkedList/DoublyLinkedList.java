package LinkedList;

public class DoublyLinkedList {
    Node head;

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert(list, 5);
        list.printList(list);
        list.insert(list, 6);
        list.printList(list);
        list.insert(list, 8);
        list.printList(list);
        list.insertAtBeginning(list, 21);
        list.printList(list);
        list.insertAtIndex(list, 21, 84);
        list.printList(list);
        list.insertAtIndex(list, 3, 88);
        list.printList(list);
        list.deleteAtIndex(list, 0);
        list.printList(list);
    }

    public DoublyLinkedList insert(DoublyLinkedList list, int value) {
        Node newNode = new Node(value);
        if (list.head == null)
            list.head = newNode;
        else {
            Node last = list.head;
            while (last.next != null)
                last = last.next;
            last.next = newNode;
            newNode.previous = last;
        }
        return list;
    }

    public DoublyLinkedList insertAtBeginning(DoublyLinkedList list, int value) {
        Node newNode = new Node(value);
        if (list.head == null)
            list.head = newNode;
        else {
            Node last = list.head;
            last.previous = newNode;
            list.head = newNode;
            newNode.next = last;
        }
        return list;
    }

    public DoublyLinkedList insertAtIndex(DoublyLinkedList list, int index, int value) {
        Node newNode = new Node(value);
        Node node = list.head;
        int counter = 0;
        if (node == null || index == 0)
            list.insertAtBeginning(list, value);
        else {
            while (counter != (index - 1)) {
                if (node.next != null) {
                    node = node.next;
                } else {
                    break;
                }
                counter++;
            }
            Node leader = node.next;
            node.next = newNode;
            newNode.previous = node;
            newNode.next = leader;
        }
        return list;
    }

    public DoublyLinkedList delete(DoublyLinkedList list, int value) {
        Node node = list.head;
        if (node == null)
            System.out.println("No Doubly Linked List Found");
        else {
            while (node != null) {
                if (node.value == value) {
                    if (node.previous == null) {

                        list.head = node.next;
                        if (node.next != null)
                            node.next.previous = null;
                        break;
                    } else {
                        if (node.next == null) {
                            node.previous.next = null;
                        } else {
                            Node previous = node.previous;
                            node.previous.next = node.next;
                            node.next.previous = previous;
                        }
                        break;
                    }
                }
                node = node.next;
            }
            if (node == null)
                System.out.println("No Value Found");
        }
        return list;
    }

    public DoublyLinkedList deleteAtIndex(DoublyLinkedList list, int index) {
        Node node = list.head;
        int counter = 0;
        if (index == 0) {
            list.head = node.next;
            if (node.next != null)
                node.next.previous = null;
        } else {
            while (counter != index) {
                if (node.next != null) {
                    node = node.next;
                } else {
                    System.out.println("Index Not Found");
                    return list;
                }
                counter++;
            }
            Node previous = node.previous;
            if (node.next != null)
                node.next.previous = previous;
            node.previous.next = node.next;
        }
        return list;
    }

    public void printList(DoublyLinkedList list) {
        Node node = list.head;
        if (node == null)
            System.out.println("No Doubly Linked List Found");
        else {
            while (node != null) {
                if (node.next != null)
                    System.out.print(node.value + "-->");
                else
                    System.out.println(node.value);
                node = node.next;
            }
        }
    }

    static class Node {
        int value;
        Node previous, next;

        public Node(int value) {
            this.value = value;
            this.next = null;
            this.previous = null;
        }
    }

}
