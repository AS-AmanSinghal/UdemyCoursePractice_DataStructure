package Stack;
//Implementation of Queues Using Array
public class Stack2 {
    int size = 6;
    int top;
    int[] a = new int[size];


    public Stack2() {
        top = -1;
    }

    public static void main(String[] args) {
        Stack2 stack2 = new Stack2();
        stack2.push(24);
        stack2.printStack();
        stack2.push(45);
        stack2.push(1);
        stack2.push(23);
        stack2.push(4);
        stack2.push(5);
        stack2.printStack();
        stack2.push(11);
        stack2.push(123);
        stack2.printStack();
        stack2.pop();
        stack2.pop();
        stack2.pop();
        stack2.pop();
        stack2.pop();
        stack2.printStack();
        stack2.peek();
    }

    public boolean push(int value) {
        if (top >= (size - 1)) {
            System.out.println("Stack Overflow");
            return false;
        } else {
            a[++top] = value;
            return true;
        }
    }

    public boolean pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return false;
        } else {
            top--;
            return true;
        }
    }

    public void peek() {
        if (top < 0)
            System.out.println("Stack UnderFlow");
        else
            System.out.println(a[top]);
    }

    public void printStack() {
        if (top < 0)
            System.out.println("Stack UnderFlow");
        else {
            System.out.print(a[top]);
            for (int i = top - 1; i >= 0; i--)
                System.out.print("<--" + a[i]);
            System.out.println();
        }
    }
}
