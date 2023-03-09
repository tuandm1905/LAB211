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
public class SU22_08_2slot_TuanDM_SE150430 {

    /**
     * @param args the command line arguments
     */
    private static BinarySearch bi;
    private static ElementArrays a;

    public static void main(String[] args) {
        bi = new BinarySearch();
        a = new ElementArrays();
        System.out.println("Enter number of array:");
        // Nhập n
        int n = bi.Input();
        // Nhập giá trị mảng random
        bi.inputNumberOfArray(n);
        System.out.print("Array: ");
        bi.displayArray();
        System.out.println("\nEnter search value:");
        // Nhập giá trị cần tìm vị trí
        int searcher = bi.Input();
        // Sắp xếp
        bi.bubbleSort();
        System.out.print("Sorted array: ");
        // In ra mảng đã được sắp xếp
        bi.displayArray();
        // Tìm kiếm giá trị
        bi.searchBinary(searcher);
    }
}
