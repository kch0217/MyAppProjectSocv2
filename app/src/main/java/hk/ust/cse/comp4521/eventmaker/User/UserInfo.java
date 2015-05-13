package hk.ust.cse.comp4521.eventmaker.User;

/**
* Created by Ken on 25/4/2015.
*/
public class UserInfo implements Cloneable {
    public String _id;
    public String Name;
    public int Age;
    public String Gender;
    public String Interest;
    public String Interest2;
    public String Phone;
    public String NamePrivacy;
    public String AgePrivacy;
    public String GenderPrivacy;

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
