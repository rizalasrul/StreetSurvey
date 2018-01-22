package dishub.streetsurvey.classumum;

/**
 * Created by 4741G on 08/12/2017.
 */

public class user {
    private String _username;
    private String _password;
    private String _id;

    public void set_username(String ival){
        _username = ival;
    }

    public String get_username(){
        return _username;
    }

    public void set_password(String ival){
        _password = ival;
    }

    public String get_password(){
        return _password;
    }

    public void set_id(String ival){
        _id = ival;
    }

    public String get_id(){
        return _id;
    }
}
