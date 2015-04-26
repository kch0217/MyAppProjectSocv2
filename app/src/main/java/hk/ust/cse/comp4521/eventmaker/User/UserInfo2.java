package hk.ust.cse.comp4521.eventmaker.User;

/**
* Created by Ken on 25/4/2015.
*/
public class UserInfo2 extends UserInfo {
    transient String _id;


    UserInfo2(){
        _id = "";
        Name = "";
        Age =0;
        Gender ="";
        Interest = "";
        Interest2 = "";
        Phone = "";
        NamePrivacy = "";
        AgePrivacy = "";
        GenderPrivacy = "";
    }

    public UserInfo2(UserInfo2 info){
        super(info);
    }
}
