package short51;

public class Calculation {
    private double memory;

    public Calculation(double memory) {
        this.memory = memory;
    }

    public double getMemory() {
        return memory;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }
    
    public void calculate(String op, double num){
        switch(op){
            case "+" :
                memory += num;
                break;
            case "-":
                memory -= num;
                break;
            case "*" :
                memory *= num;
                break;
            case "/" :
                if (num == 0) {
                    System.out.println("Error: Cannot divide by zero!");
                } else {
                    memory /= num;
                }
                break;
            case "^":
                memory = Math.pow(memory, num);
                break;
            default:
                System.out.println("Operator is invalid");
                break;
        }
    }
}
