/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su22_19_tuandm_se150430;

/**
 *
 * @author Đặng Minh Tuấn SE150430
 */
public class Zoo {
// tạo đối tượng

    private String idAnimal;
    private String name;
    private double weight;
    private String idType;
// tạo phương thức

    public Zoo(String idAnimal, String name, double weight, String idType) {
        this.idAnimal = idAnimal;
        this.name = name;
        this.weight = weight;
        this.idType = idType;
    }
// tạo hàm get set

    public String getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(String idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

}
