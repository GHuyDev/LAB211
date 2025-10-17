package long23;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FruitShop {

    private List<Fruit> fruits = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void run() {
        addFruits();
//        showFruits();
        menuLoop();
    }

    private void addFruits() {
        fruits.add(new Fruit("01", "banana", 3.0, 12, "VN"));
        fruits.add(new Fruit("02", "orange", 3.5, 120, "VN"));
        fruits.add(new Fruit("03", "watermelon", 4.0, 150, "VN"));
        fruits.add(new Fruit("04", "apple", 1.4, 100, "VN"));
    }

    private void showFruits() {
        System.out.println("Danh muc kho: ");
        System.out.println("| Item | Fruit Name | Origin | Price | Quantity |");
        int i = 1;
        for (Fruit f : fruits) {
            System.out.printf("%-5d | %-10s | %-10s | %.2f$ | %d\n",
                    i++, f.getName(), f.getOrigin(), f.getPrice(), f.getQuantity());
        }
    }

    private void menuLoop() {
        while (true) {
            System.out.println("\nFRUIT SHOP SYSTEM");
            System.out.println("1. Create Fruit");
            System.out.println("2. View orders");
            System.out.println("3. Shopping (for buyer)");
            System.out.println("4. Exit");
            System.out.print("Please choose 1-4: ");
            String c = sc.nextLine().trim();
            switch (c) {
                case "1" ->
                    createFruit();
                case "2" ->
                    viewOrders();
                case "3" ->
                    shopping();
                case "4" -> {
                    System.out.println("Bye!");
                    return;
                }
                default ->
                    System.out.println("Invalid. Try again.");
            }
        }
    }
    //Create Fruit

    private void createFruit() {
        do {
            String id = Validator.nonEmpty(sc, "Fruit Id: ");
            String name = Validator.nonEmpty(sc, "Fruit Name: ");
            double price = Validator.positiveDouble(sc, "Price: ");
            int qty = Validator.positiveInt(sc, "Quantity: ");
            String origin = Validator.nonEmpty(sc, "Origin: ");
            fruits.add(new Fruit(id, name, price, qty, origin));
        } while (Validator.yesNo(sc, "Do you want to continue (Y/N)? "));

        // Sau khi tạo xong, hiển thị danh sách
        showFruits();
    }
    //View Order

    private void viewOrders() {
        System.out.println("Danh sach chi tiet mua hang: ");
        if (orders.isEmpty()) {
            System.out.println("No orders.");
            return;
        }
        for (Order od : orders) {
            System.out.print(od); // toString() của Order đã in đúng mẫu + Total
        }
    }
    //Shopping
//       private void shopping() {
//           Order order1 = new Order("Huy");
//           List<OrderDetail> bag = new ArrayList<>();
//           
//            Fruit item1 = fruits.get(1);
//            int qty1 = 10;
//            item1.setQuantity(item1.getQuantity() - qty1);
//            bag.add(new OrderDetail(item1, qty1));
//            
//            Fruit item2 = fruits.get(2);
//            int qty2 = 10;
//            item2.setQuantity(item2.getQuantity() - qty2);
//            bag.add(new OrderDetail(item2, qty2));
//          for(OrderDetail od : bag){
//              order1.addDetail(od);
//          }
//          orders.add(order1);
//        }
//       

    private void shopping() {
        String customer = Validator.nonEmpty(sc, "Customer name: ");
        Order order = new Order(customer);

        while (true) {  // Hiển thị danh sách fruit
            System.out.println("\nList of Fruit:");
            System.out.println("| Item | Fruit Name | Origin     | Price  | Quantity |");
            for (int i = 0; i < fruits.size(); i++) {
                Fruit f = fruits.get(i);
                System.out.printf("%-5d | %-10s | %-10s | %6.2f$ | %8d%n",
                        (i + 1), f.getName(), f.getOrigin(), f.getPrice(), f.getQuantity());
            }

            // 3) Chọn fruit
            int idx = Validator.pickIndex(sc, "Select Item (1-" + fruits.size() + "): ", fruits.size());
            Fruit chosen = fruits.get(idx);
            if (chosen.getQuantity() == 0) {
                System.out.println("Mặt hàng này đã hết. Hãy chọn loại khác.");
                continue;
            }

            // Nhập số lượng, không vượt tồn
            int maxQty = chosen.getQuantity();
            int buyQty;
            while (true) {
                buyQty = Validator.positiveInt(sc, "Quantity (max " + maxQty + "): ");
                if (buyQty <= maxQty) {
                    break;
                }
                System.out.println("Vượt quá tồn. Vui lòng nhập ≤ " + maxQty + ".");
            }

            // Trừ tồn và thêm vào đơn
            chosen.setQuantity(chosen.getQuantity() - buyQty);
            order.addDetail(new OrderDetail(chosen, buyQty));

            // 4) Hỏi thanh toán
            if (Validator.yesNo(sc, "Thanh toán ngay? (Y/N): ")) {
                orders.add(order);
                System.out.println("\n===== INVOICE =====");
                System.out.print(order); // toString() của Order đã in đầy đủ
                System.out.println("===================");
                break; // quay lại menu chính
            }

        }
    }
}
