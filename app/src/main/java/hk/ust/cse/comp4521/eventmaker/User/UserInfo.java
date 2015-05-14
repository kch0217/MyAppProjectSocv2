package hk.ust.cse.comp4521.eventmaker.User;

/**
* Created by Ken on 25/4/2015.
*/
public class UserInfo implements Cloneable {
    String _id;
    String Name;
    int Age;
    String Gender;
    String Interest;
    String Interest2;
    String Phone;
    String NamePrivacy;
    String AgePrivacy;
    String GenderPrivacy;

    public UserInfo(){

    }
    public UserInfo(UserInfo info) {
        this._id = info._id;
        Name = info.Name;
        Age = info.Age;
        Gender = info.Gender;
        Interest = info.Interest;
        Interest2 = info.Interest2;
        Phone = info.Phone;
        NamePrivacy = info.NamePrivacy;
        AgePrivacy = info.AgePrivacy;
        GenderPrivacy = info.GenderPrivacy;
    }
}
