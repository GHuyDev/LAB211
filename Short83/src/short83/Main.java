package short83;

public class Main {

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        
        stack.push(1);
        stack.push(6);
        stack.push(25);
        
        stack.display();
        
        System.out.println("Top value: " + stack.get());

        stack.pop();  
        stack.display();   

        stack.pop();
        stack.display();
        
    }      
}
