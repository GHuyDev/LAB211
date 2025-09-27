
package short83;

import java.util.ArrayList;
import java.util.List;

public class MyStack {
    
    private List<Integer> stackValues;

    public MyStack() {
        this.stackValues = new ArrayList<>();
    }

    public void push(int value) {
        stackValues.add(value);
        System.out.println("Pushed: " + value);
    }

    public int pop() {
        if (stackValues.isEmpty()) {
            System.out.println("Stack is empty, cannot pop.");
            return -1;
        }
        int value = stackValues.remove(stackValues.size() - 1);
        System.out.println("Popped: " + value);
        return value;
    }

    public int get() {
        if (stackValues.isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        return stackValues.get(stackValues.size() - 1);
    }

    public void display() {
        System.out.println("Stack: " + stackValues);
    }
}

