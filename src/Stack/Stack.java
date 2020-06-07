package Stack;
//Implementation of Stack Using LinkedList
public class Stack {
    Node top;

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.printStack(stack);
        stack.push(stack, 24);
        stack.printStack(stack);
        stack.push(stack, 25);
        stack.printStack(stack);
        stack.push(stack, 26);
        stack.printStack(stack);
        stack.pop(stack);
        stack.pop(stack);
        stack.printStack(stack);
        stack.pop(stack);
        stack.printStack(stack);
        stack.peek(stack);
    }

    public Stack push(Stack stack, int value) {
        Node newNode = new Node(value);
        if (stack.top == null) {
            stack.top = newNode;
        } else {
            Node holder = stack.top;
            stack.top = newNode;
            stack.top.next = holder;
        }
        return stack;
    }

    public void printStack(Stack stack) {
        Node node = stack.top;
        if (node == null) {
            System.out.println("No Stack Found");
        } else {
            while (node != null) {
                if (node.next == null)
                    System.out.println(node.value);
                else
                    System.out.print(node.value + "<--");
                node = node.next;
            }
        }
    }

    public Stack pop(Stack stack) {
        Node node = stack.top;
        if (node == null)
            System.out.println("No Stack Found");
        else {
            stack.top = node.next;
        }
        return stack;
    }

    public void peek(Stack stack) {
        Node node = stack.top;
        if (node == null)
            System.out.println("No Stack Found");
        else System.out.println(node.value);
    }

    static class Node {
        Node next;
        int value;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

}
