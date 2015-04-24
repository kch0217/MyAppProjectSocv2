package hk.ust.cse.comp4521.eventmaker.User;

import android.content.Context;

/**
 * Created by Ken on 7/4/2015.
 */
public class UserController {

    private Context context;
    private static UserController myController = new UserController();


    private UserController(){

    }

    public static UserController getUserController(){
        return myController;
    }

    public void initialize(Context context){
        setContext(context);
    }

    public void setContext(Context context){

        this.context = context;
    }


}
