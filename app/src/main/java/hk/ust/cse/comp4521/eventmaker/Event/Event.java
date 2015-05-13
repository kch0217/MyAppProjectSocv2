package hk.ust.cse.comp4521.eventmaker.Event;

/**
 * Created by User on 5/3/2015.
 */
public class Event {
    String _id;
    String _ownerid;
    String interest;
    double longitude;
    double latitude;
    int numOfPart; //default as 3

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
