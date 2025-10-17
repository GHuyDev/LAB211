package long23;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String customerName;
    private List<OrderDetail> items = new ArrayList<>();
    private double total;

    public Order(String customerName) {
        this.customerName = customerName;
    }
    
    public void addDetail(OrderDetail od){
        items.add(od);
        total += od.getAmount();
    }

    public String getCustomerName() {
        return customerName;
    }
    
    public List<OrderDetail> getDetails(){return items;}
    public double getTotal(){return total;}
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Customer: ").append(customerName).append("\n");
        sb.append("Product    | Qty | Price | Amount\n");
        int i = 1;
        for(OrderDetail od : items){
            sb.append(i++).append(". ").append(od.toString()).append(("\n"));
        }
        sb.append("Total: ").append(String.format("%.2f$", total)).append("\n");
        return sb.toString();
    }
}
