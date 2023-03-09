package su22_07_2slot_tuandm_se150430;

/**
 *
 * @author SE150430
 */
public class Account {

    String userName;
    String password;

    /**
     * get by username
     * @return 
     */
    public String getUserName() {
        return userName;
    }

    /**
     *  set by username
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * get by password
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * set password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Create new account
     * @param userName
     * @param password
     */
    //tạo đối đượng
    public Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
