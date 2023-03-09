package su22_01_tuandm_se150430;

/**
 *
 * @author SE150430
 */
public class FileException extends Exception {
    
    // Create a File Exception
    public FileException(String message) {
        super(message);
    }
   // Get the messenger of File Exception
    @Override
    public String getMessage() {
        return "FileException: " + super.getMessage(); 
    }

}
