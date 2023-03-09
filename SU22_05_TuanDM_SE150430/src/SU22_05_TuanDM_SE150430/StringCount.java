/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SU22_05_TuanDM_SE150430;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author SE150430
 */
public class StringCount {

    static void DemKyTu(String str) {
        int counter[] = new int[256];
        int count1=0, count2=0;
        int len = str.length();
        for (int i = 0; i < len; i++) {
                counter[str.charAt(i)]++;
                if (counter[str.charAt(i)] == 1 ) count1++;
                
        }
        char array[] = new char[str.length()];
        System.out.print("{");
        for (int i = 0; i < len; i++) {
            array[i] = str.charAt(i);
            int flag = 0;
            for (int j = 0; j <= i; j++) {
                if (str.charAt(i) == array[j] && str.charAt(i) != ' ') {
                    flag++;
                    
                }
            }
            if (flag == 1) {
                count2++;
                if (count1-1 == count2) {
                    System.out.printf(str.charAt(i)
                            + "=" + counter[str.charAt(i)]);
                } else {
                    System.out.printf(str.charAt(i)
                            + "=" + counter[str.charAt(i)] + ", ");
                }
            }
        }
        System.out.println("}");
    }

    static void DemTu(String str) {
        str = str.replaceAll(",", "");
        String[] arr = str.split(" ");
        String key = "";
        Integer value;
        TreeMap<String, Integer> map = new TreeMap<String, Integer>();
        int len = arr.length;
        for (int i = 0; i < arr.length; i++) {
            key = arr[i];
            if (map.containsKey(key)) {
                value = map.get(key);
                map.put(key, value + 1);
                map.remove(key);
            } else {
                map.put(key, new Integer(1));
            }
        }
        Set set = map.keySet();
        Iterator i = set.iterator();
        int count=0;
        System.out.print("{");
        while (i.hasNext()) {
            key = (String) i.next();
            count++;
            if (count == len)
            System.out.print("" + key + "=" + map.get(key));
            else {
                System.out.print("" + key + "=" + map.get(key) + ", ");
            }
        }
        System.out.println("}");
    }
}
