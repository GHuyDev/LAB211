package short84;

import java.util.Scanner;

class LargeNumber {

    private String value;

    public LargeNumber(String value) {
        this.value = value.replaceAll("\\s+", "").replaceFirst("^0+(?!$)", "");
    }

    // Add two large numbers
    public LargeNumber add(LargeNumber other) {
        String num1 = this.value;
        String num2 = other.value;

        StringBuilder result = new StringBuilder();
        int carry = 0;                      
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry != 0) {
            int digit1 = (i >= 0) ? num1.charAt(i--) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j--) - '0' : 0;
            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            result.append(sum % 10);
        }

        return new LargeNumber(result.reverse().toString());
    }

    //Multiply two large numbers
    public LargeNumber multiply(LargeNumber other) {
        String num1 = this.value;
        String num2 = other.value;

        int len1 = num1.length();
        int len2 = num2.length();
        int[] product = new int[len1 + len2];

        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + product[i + j + 1];
                product[i + j + 1] = sum % 10;
                product[i + j] += sum / 10;
            }
        }

        // Chuyển mảng sang chuỗi
        StringBuilder sb = new StringBuilder();//chuyển mảng kqua product[] thành 1 chỗi hoàn chỉnh
        for (int n : product) {
            if (!(sb.length() == 0 && n == 0)) sb.append(n);
        }

        return new LargeNumber(sb.length() == 0 ? "0" : sb.toString());
    }

    @Override
    public String toString() {
        return value;
    }
}






//StringBuilder();
//giúp nối chuỗi mà kh tạo chuỗi mới liên tục mỗi lần nối
//khởi tạo 1 bộ nhớ tạm để ghép từng chữ số kết quả cộng