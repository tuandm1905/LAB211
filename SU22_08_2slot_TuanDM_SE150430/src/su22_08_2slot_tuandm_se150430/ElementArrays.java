/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su22_08_2slot_tuandm_se150430;

/**
 *
 * @author TuanDM SE150430
 */
public class ElementArrays {

    private int[] arrayNumber;
    private int search;

    // Tạo một mảng
    public ElementArrays(int[] arrayNumber) {

        this.setArrayNumber(arrayNumber);
    }

    public ElementArrays() {
    }

    // Lấy các phần tử của mảng
    public int[] getArrayNumber() {
        return arrayNumber;
    }

    // Set các phần tử của mảng
    public void setArrayNumber(int[] arrayNumber) {
        this.arrayNumber = arrayNumber;
    }

}
