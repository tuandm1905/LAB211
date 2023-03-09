/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SU22_05_TuanDM_SE150430;

import java.util.Scanner;
import static SU22_05_TuanDM_SE150430.StringCount.DemKyTu;
import static SU22_05_TuanDM_SE150430.StringCount.DemTu;

/**
 *
 * @author SE150430
 */
public class SU22_05_TuanDM_SE150430 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Enter your content ");
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        //String str = "     hello    world     ";
        str = str.replaceAll("\\s\\s+", " ").trim();
        DemTu(str);
        DemKyTu(str);
    }
}
