/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su22_14_2slot_tuandm_se150430;

/**
 *
 * @author Dang Minh Tuan SE150430
 */
public class Element {
    //tạo đối tượng
    private String Number;
    private String Character;
    private String inputStr;
    private int liPerfectSquare;
    private int liOdd;
    private int liEven;
    private int liAll;
    private String uppercase;
    private String lowercase;
    private String special;
    private String allCharacter;
//tạo phương thức
    public Element(String inputStr) {
        this.inputStr = inputStr;
    }

//    public Element(int liPerfectSquare, int liOdd, int liEven, int liAll) {
//        this.liPerfectSquare = liPerfectSquare;
//        this.liOdd = liOdd;
//        this.liEven = liEven;
//        this.liAll = liAll;
//    }
//
//    public Element(String uppercase, String lowercase, String special, String allCharacter) {
//        this.uppercase = uppercase;
//        this.lowercase = lowercase;
//        this.special = special;
//        this.allCharacter = allCharacter;
//    }

    public String getInputStr() {
        return inputStr;
    }

    public void setInputStr(String inputStr) {
        this.inputStr = inputStr;
    }

    public Element() {
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String Number) {
        this.Number = Number;
    }

    public String getCharacter() {
        return Character;
    }

    public void setCharacter(String Character) {
        this.Character = Character;
    }

    public int getLiPerfectSquare() {
        return liPerfectSquare;
    }

    public void setLiPerfectSquare(int liPerfectSquare) {
        this.liPerfectSquare = liPerfectSquare;
    }

    public int getLiOdd() {
        return liOdd;
    }

    public void setLiOdd(int liOdd) {
        this.liOdd = liOdd;
    }

    public int getLiEven() {
        return liEven;
    }

    public void setLiEven(int liEven) {
        this.liEven = liEven;
    }

    public int getLiAll() {
        return liAll;
    }

    public void setLiAll(int liAll) {
        this.liAll = liAll;
    }

    public String getUppercase() {
        return uppercase;
    }

    public void setUppercase(String uppercase) {
        this.uppercase = uppercase;
    }

    public String getLowercase() {
        return lowercase;
    }

    public void setLowercase(String lowercase) {
        this.lowercase = lowercase;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }

    public String getAllCharacter() {
        return allCharacter;
    }

    public void setAllCharacter(String allCharacter) {
        this.allCharacter = allCharacter;
    }

    
    
    
}
