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
public class ElementEquation {
    //Khai báo các thuộc tính
    private double a;
    private double b;
    private double c;
    private double x;
    private double delta;
    private double x1;
    private double x2;
    
    //khởi tạo constructor mặc định
    public ElementEquation(){
        
    }
    //Khởi tạo constructor có tham số

    public ElementEquation(double a, double b, double c, double delta, double x1, double x2) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.delta = delta;
        this.x1 = Math.round(x1 * 100) / 100d;
        this.x2 = Math.round(x1 * 100) / 100d;
    }

    public ElementEquation(double a, double b, double x) {
        this.a = a;
        this.b = b;
        this.x = Math.round(x * 100) / 100d;
    }
//------------------begin getter and setter----------------------

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getDelta() {
        return delta;
    }

    public void setDelta(double delta) {
        this.delta = delta;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

//-----------------------end getter and setter--------------------
    @Override
    public String toString() {
        return "ElementEquation{" + "a=" + a + ", b=" + b + ", x=" + x + '}';
    }

}
