package Queues;

import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public static void main(String[] args) {
        QueueUsingStack queueUsingStack = new QueueUsingStack();
        queueUsingStack.enqueue(24);
        queueUsingStack.enqueue(23);
    }

    public void enqueue(int value) {
        while (!s1.isEmpty())
            s2.push(s1.pop());
        s1.push(value);
        while (!s2.isEmpty())
            s1.push(s2.pop());
    }

    public void dequeue() {
        if (s1.isEmpty())
            System.out.println("NO Queue");
        else {
            s1.pop();
        }
    }
}
