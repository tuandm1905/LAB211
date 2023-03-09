/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package su22_02_tuandm_se150430;

/**
 *
 * @author SE150430
 */
public class FileException extends Exception {

    public FileException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "FileException: " + super.getMessage();
    }

}
