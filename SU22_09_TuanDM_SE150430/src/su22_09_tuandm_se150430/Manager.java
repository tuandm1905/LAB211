/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su22_09_tuandm_se150430;

/**
 *
 * @author Dang Minh Tuan SE150430
 */
public class Manager {

    public static Validate val = new Validate();
    public static ElementEquation E = new ElementEquation();

    //Menu lựa chọn
    public int menu() {
        System.out.println("======== Equation Program ========");
        System.out.println("1. Calculate Superlative Equation");
        System.out.println("2. Calculate Quadratic Equation");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int choice = val.checkInput(1, 3);
        return choice;
    }
// Nhập giá trị vào Superlative

    public void InputSuperlative() {
        System.out.println("----- Calculate Equation -----");
        System.out.print("Enter A: ");
        double a = val.checkValueDouble();
        System.out.print("Enter B: ");
        double b = val.checkValueDouble();
        double x = -b / a;
        E = new ElementEquation(a, b, x); // gán giá trị vào thuộc tính
    }
// Nhập giá trị vào Quadratic

    public void InputQuadratic() {
        System.out.println("----- Calculate Quadratic Equation -----");
        System.out.print("Enter A: "); // nhập giá trị A
        double a = val.checkValueDouble(); // Kiểm tra giá trị nhập vào
        System.out.print("Enter B: "); // nhập giá trị B
        double b = val.checkValueDouble();// Kiểm tra giá trị nhập vào
        System.out.print("Enter C: "); // nhập giá trị C
        double c = val.checkValueDouble(); // Kiểm tra giá trị nhập vào
        double delta = b * b - 4 * a * c;
        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
        double x2 = (-b - Math.sqrt(delta)) / (2 * a);
        E = new ElementEquation(a, b, c, delta, x1, x2); // gán giá trị vào thuộc tính
    }

//Khởi tạo phương thức nhập
//Khởi tạo hàm Superlative
    public void Superlative() {
        System.out.printf("Solution: x = %.3f", E.getX());
        System.out.print("\nNumber is Odd: ");
        if (val.Odd(E.getA())) {
            System.out.println(E.getA() + " ");
        } else if (val.Odd(E.getB())) {
            System.out.println(E.getB() + " ");
        } else if (val.Odd(E.getX())) {
            System.out.println(E.getX() + " ");
        }
        System.out.print("Number is Even: ");
        if (val.Even(E.getA())) {
            System.out.println(E.getA() + " ");
        } else if (val.Even(E.getB())) {
            System.out.println(E.getB() + " ");
        } else if (val.Even(E.getX())) {
            System.out.println(E.getX() + " ");
        }
        System.out.print("Number is Perfect Square: ");
        if (val.SquareNumber(E.getA())) {
            System.out.println(E.getA() + " ");
        } else if (val.SquareNumber(E.getB())) {
            System.out.println(E.getB() + " ");
        } else if (val.SquareNumber(E.getX())) {
            System.out.println(E.getX() + " ");
        }
    }

    //Khởi tạo phương thức nhập
// Khởi tạo hàm Quadratic
    public void Quadratic() {
        System.out.printf("Solution: x1 = %.3f", E.getX1());
        System.out.printf(" and x2 = %.3f", E.getX2());
        System.out.print("\nNumber is odd: ");
        if (val.Odd(E.getA())) {
            System.out.print(E.getA() + " ");
        } else if (val.Odd(E.getB())) {
            System.out.print(E.getB() + " ");
        } else if (val.Odd(E.getC())) {
            System.out.print(E.getC() + " ");
        } else if (val.Odd(E.getX1())) {
            System.out.print(E.getX1() + " ");
        } else if (val.Odd(E.getX2())) {
            System.out.print(E.getX2() + " ");
        }
        System.out.println();
        System.out.print("Number is Even: ");
        if (val.Even(E.getA())) {
            System.out.print(E.getA() + " ");
        } else if (val.Even(E.getB())) {
            System.out.print(E.getB() + " ");
        } else if (val.Even(E.getC())) {
            System.out.print(E.getB() + " ");
        } else if (val.Even(E.getX1())) {
            System.out.print(E.getX1() + " ");
        } else if (val.Even(E.getX2())) {
            System.out.print(E.getX1() + " ");
        }
        System.out.println();
        System.out.print("Number is Perfect Square: ");
        if (val.SquareNumber(E.getA())) {
            System.out.print(E.getA() + " ");
        } else if (val.SquareNumber(E.getB())) {
            System.out.print(E.getB() + " ");
        } else if (val.SquareNumber(E.getC())) {
            System.out.print(E.getC() + " ");
        } else if (val.SquareNumber(E.getX1())) {
            System.out.print(E.getX1() + " ");
        } else if (val.SquareNumber(E.getX2())) {
            System.out.print(E.getX2() + " ");
        }
        System.out.println();
    }
}
