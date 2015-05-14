package hk.ust.cse.comp4521.eventmaker.Event;

/**
 * Created by User on 5/3/2015.
 */
public class Event {
    public String _id;
    public String _ownerid;
    public String interest;
    public double longitude;
    public double latitude;
    public int numOfPart; //default as 3

    public Event(){    }

    public Event(Event evt){
        longitude=evt.longitude;
        latitude=evt.latitude;
        numOfPart=evt.numOfPart;
        _id=evt._id;
        _ownerid=evt._ownerid;
        interest=evt.interest;
    }
}
