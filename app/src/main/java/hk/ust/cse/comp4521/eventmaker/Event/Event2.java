package hk.ust.cse.comp4521.eventmaker.Event;

/**
 * Created by User on 5/4/2015.
 */
public class Event2 extends Event {
    transient String _id;
    transient String _ownerid;

    public Event2(){
        longitude=0.0;
        latitude=0.0;
        numOfPart=0;
        interest="";
        _id="";
        _ownerid="";
    }

    public Event2(double lon,double lat,int num,String interest){
        longitude=lon;
        latitude=lat;
        numOfPart=num;
        this.interest=interest;
    }

    public Event2(Event2 evt) {
        super(evt);
    }
}
