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
public class Type {
// tạo đối tượng

    private String idType;
    private String name;
// tạo phương thức

    public Type(String idType, String name) {
        this.idType = idType;
        this.name = name;
    }
// tạo hàm get set

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
