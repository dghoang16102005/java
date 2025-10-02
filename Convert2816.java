/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package convert2816;
import  java.math.BigInteger;

/**
 *
 * @author Duong Hoang
 */

public class BasConvert{
    public BigInteger binaryToDecimal(BigInteger binary){
        char[] bitBinary= binary.toString().toCharArray();
        BigInteger result = BigInteger.ZERO;
        for(int i = 0; i<bitBinary.length;i++){
            result = result.multiply(BigInteger.valueOf(2));
            if(bitBinary[i] == '1') result = result.add(BigInteger.ONE);
        }
        return result;
    }
    
    // Decimal (BigInteger) -> Binary
    public static String decimalToBinary(BigInteger decimal) {
        if (decimal.equals(BigInteger.ZERO)) return "0";
        StringBuilder sb = new StringBuilder();
        BigInteger two = BigInteger.valueOf(2);
        while (decimal.compareTo(BigInteger.ZERO) > 0) {
            BigInteger[] divRem = decimal.divideAndRemainder(two);
            sb.append(divRem[1]); // phần dư (0 hoặc 1)
            decimal = divRem[0];
        }
        return sb.reverse().toString();
    }

    // Hex -> Decimal (BigInteger)
    public static BigInteger hexToDecimal(String hex) {
        BigInteger result = BigInteger.ZERO;
        for (int i = 0; i < hex.length(); i++) {
            char c = hex.charAt(i);
            int value = (c >= '0' && c <= '9') ? c - '0' : (c - 'A' + 10);
            result = result.multiply(BigInteger.valueOf(16));
            result = result.add(BigInteger.valueOf(value));
        }
        return result;
    }

    // Decimal (BigInteger) -> Hex
    public  BigInteger decimalToHex(BigInteger decimal) {
        if (decimal.equals(BigInteger.ZERO)) return "0";
        StringBuilder sb = new StringBuilder();
        BigInteger sixteen = BigInteger.valueOf(16);
        while (decimal.compareTo(BigInteger.ZERO) > 0) {
            BigInteger[] divRem = decimal.divideAndRemainder(sixteen);
            int remainder = divRem[1].intValue();
            char hexChar = (remainder < 10) ? (char) ('0' + remainder) : (char) ('A' + remainder - 10);
            sb.append(hexChar);
            decimal = divRem[0];
        }
        return sb.reverse().toString();
    }

    // Binary -> Hex
    public static BigInteger binaryToHex(BigInteger binary) {
        BigInteger decimal = binaryToDecimal(binary);
        return decimalToHex(decimal);
    }

    // Hex -> Binary
    public static String hexToBinary(String hex) {
        BigInteger decimal = hexToDecimal(hex);
        return decimalToBinary(decimal);
    }

    
    
}
public class Convert2816 {
    
    public static BigInteger inputBigInteger(String msg, int base, BigInteger min, BigInteger max) {
    Scanner sc = new Scanner(System.in);

    while (true) {
        System.out.print(msg);
        String input = sc.nextLine().trim().toUpperCase();

        // Bước 1: kiểm tra định dạng theo hệ cơ số
        if (!isValidFormat(input, base)) {
            System.err.println("❌ Định dạng không hợp lệ cho hệ cơ số " + base);
            continue;
        }

        // Bước 2: chuyển sang BigInteger
        BigInteger value;
        try {
            value = new BigInteger(input, base);
        } catch (NumberFormatException e) {
            System.out.println("❌ Không thể chuyển đổi sang số nguyên lớn.");
            continue;
        }

        // Bước 3: kiểm tra khoảng
        if (value.compareTo(min) < 0 || value.compareTo(max) > 0) {
            System.out.println("❌ Giá trị phải nằm trong khoảng từ " + min + " đến " + max);
            continue;
        }

        return value;
    }
}
    
    private static boolean isValidFormat(String input, int base) {
    
        switch (base) {
        case 2: return input.matches("[01]+");
            case 10:
                return input.matches("[0-9]+");
            case 16:
                return input.matches("[0-9A-F]+");
            default:
                return false; // chỉ hỗ trợ 2, 10, 16
        }
}

     
            
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
