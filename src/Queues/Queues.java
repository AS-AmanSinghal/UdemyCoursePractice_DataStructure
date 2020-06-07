package Queues;

//Implementation of Queue Using Linked List
public class Queues {
    Node front, rear;

    public static void main(String[] args) {
        Queues queues = new Queues();
        queues.enqueue(queues, 23);
        queues.printQueues(queues);
        queues.enqueue(queues, 24);
        queues.printQueues(queues);
        queues.enqueue(queues, 25);
        queues.printQueues(queues);
        queues.enqueue(queues, 26);
        queues.dequeue(queues);
        queues.peek(queues);
        queues.printQueues(queues);
        queues.dequeue(queues);
        queues.printQueues(queues);
        queues.dequeue(queues);
        queues.printQueues(queues);
        queues.dequeue(queues);
        queues.printQueues(queues);
        queues.dequeue(queues);
        queues.printQueues(queues);
    }

    public Queues enqueue(Queues queues, int value) {
        Node newNode = new Node(value);
        if (queues.front == null) {
            queues.front = newNode;
        } else {
            queues.rear.next = newNode;
        }
        queues.rear = newNode;
        return queues;
    }

    public Queues dequeue(Queues queues) {
        Node node = queues.front;
        if (node == null) {
            System.out.println("No Queue Found");
        } else {
            queues.front = queues.front.next;
            if (queues.front == null)
                queues.rear = null;
        }
        return queues;
    }

    public void peek(Queues queues) {
        if (queues.front == null)
            System.out.println("No Queue Found");
        else {
            System.out.println(queues.front.value);
        }
    }

    public void printQueues(Queues queues) {
        Node node = queues.front;
        if (node == null)
            System.out.println("Queue Empty");
        else {
            while (node != null) {
                if (node.next == null)
                    System.out.println(node.value);
                else
                    System.out.print(node.value + "-->");
                node = node.next;
            }
        }
    }

    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
}