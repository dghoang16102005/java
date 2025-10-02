/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package giaiphuongtrinhbac1bac2;

/**
 *
 * @author Duong Hoang
 */


import java.util.*;

/* ======================= MODEL ======================= */
/**
 * Lưu trữ hệ số và nghiệm của phương trình
 */
class EquationModel {
    private float a, b, c;
    private List<Float> solutions = new ArrayList<>();

    public EquationModel(float a, float b) {
        this.a = a;
        this.b = b;
    }

    public EquationModel(float a, float b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public float getA() { return a; }
    public float getB() { return b; }
    public float getC() { return c; }

    public void setSolutions(Float... sols) {
        solutions.clear();
        solutions.addAll(Arrays.asList(sols));
    }

    public List<Float> getSolutions() {
        return solutions;
    }
}

/* ======================= VIEW ======================= */
/**
 * Hiển thị giao diện và thông tin cho người dùng
 */
class EquationView {
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("========= Equation Program =========");
        System.out.println("1. Giải phương trình bậc nhất");
        System.out.println("2. Giải phương trình bậc hai");
        System.out.println("3. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    public float getFloat(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Float.parseFloat(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ.");
            }
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showSolutions(List<Float> solutions) {
        if (solutions.isEmpty()) {
            System.out.println("Không có nghiệm.");
        } else if (solutions.size() == 1) {
            System.out.printf("Nghiệm: x = %.3f\n", solutions.get(0));
        } else {
            System.out.printf("Nghiệm: x1 = %.3f, x2 = %.3f\n", solutions.get(0), solutions.get(1));
        }
    }

    public void showNumberTypes(List<Float> numbers) {
        List<Float> even = new ArrayList<>();
        List<Float> odd = new ArrayList<>();
        List<Float> square = new ArrayList<>();

        for (Float num : numbers) {
            if (NumberUtils.isEven(num)) even.add(num);
            else odd.add(num);
            if (NumberUtils.isPerfectSquare(num)) square.add(num);
        }

        System.out.println("Số chẵn: " + even);
        System.out.println("Số lẻ: " + odd);
        System.out.println("Số chính phương: " + square);
    }
}

/* ======================= CONTROLLER ======================= */
/**
 * Xử lý logic chương trình
 */
class EquationController {
    private final EquationView view = new EquationView();

    public void run() {
        while (true) {
            view.showMenu();
            String choice = new Scanner(System.in).nextLine();
            switch (choice) {
                case "1": solveSuperlative();
                case "2": solveQuadratic();
                case "3": {
                    view.showMessage("Đã thoát chương trình.");
                    return;
                }
                default: view.showMessage("Lựa chọn không hợp lệ.");
            }
        }
    }

    private void solveSuperlative() {
        float a = view.getFloat("Nhập A: ");
        float b = view.getFloat("Nhập B: ");
        EquationModel model = new EquationModel(a, b);

        if (a == 0) {
            if (b == 0) view.showMessage("Phương trình có vô số nghiệm.");
            else view.showMessage("Phương trình vô nghiệm.");
        } else {
            float x = -b / a;
            model.setSolutions(x);
            view.showSolutions(model.getSolutions());
            view.showNumberTypes(Arrays.asList(a, b, x));
        }
    }

    private void solveQuadratic() {
        float a = view.getFloat("Nhập A: ");
        float b = view.getFloat("Nhập B: ");
        float c = view.getFloat("Nhập C: ");
        EquationModel model = new EquationModel(a, b, c);

        float delta = b * b - 4 * a * c;
        if (delta < 0) {
            view.showMessage("Phương trình vô nghiệm.");
        } else {
            float x1 = (-b + (float)Math.sqrt(delta)) / (2 * a);
            float x2 = (-b - (float)Math.sqrt(delta)) / (2 * a);
            model.setSolutions(x1, x2);
            view.showSolutions(model.getSolutions());
            view.showNumberTypes(Arrays.asList(a, b, c, x1, x2));
        }
    }
}

/* ======================= UTILS ======================= */
/**
 * Các hàm tiện ích kiểm tra số
 */
class NumberUtils {
    public static boolean isEven(float num) {
        return num % 2 == 0;
    }

    public static boolean isPerfectSquare(float num) {
        if (num < 0) return false;
        int sqrt = (int)Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}

/* ======================= MAIN ======================= */
/**
 * Điểm khởi chạy chương trình
 */
public class EquationProgram {
    public static void main(String[] args) {
        new EquationController().run();
    }
}
