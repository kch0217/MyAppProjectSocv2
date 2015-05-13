package hk.ust.cse.comp4521.eventmaker.Event;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import hk.ust.cse.comp4521.eventmaker.restEvent.restClientEvent;
import retrofit.Callback;
import retrofit.RetrofitError;

/**
 * Created by User on 5/4/2015.
 */
public class Event_T{
    String TAG="VZXYZ";
    List<Event> test;
    Event returnevt;
    String testid;

    public Event_T(){}
    public void createEvent(){
        Event2 test=new Event2();
      restClientEvent.get().addEvent(test, new Callback<retrofit.client.Response>() {
          @Override
          public void success(retrofit.client.Response response, retrofit.client.Response response2) {
              Log.i(TAG, "Add Response is " + response.getBody().toString());
          }

          @Override
          public void failure(RetrofitError retrofitError) {
              Log.i(TAG,"cannot conect");
          }
      });
    }

    public List<Event> getAllEvent(){

        restClientEvent.get().getEvents(new Callback<ArrayList<Event>>() {
            @Override
            public void success(ArrayList<Event> events, retrofit.client.Response response) {
                test = events;
                if (test.size() > 0) {
                    for (int i = 0; i < test.size(); i++) {
                        Log.i(TAG, test.get(i)._id);
                    }
                }
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                Log.i(TAG, "youknowwhat");
            }
        });
        return test;
    }

    public void updateEvent(Event2 evt, final String id){
        restClientEvent.get().updateEvent(evt, id, new Callback<retrofit.client.Response>() {
            @Override
            public void success(retrofit.client.Response response, retrofit.client.Response response2) {
                Log.i(TAG, "update successfully on" + id);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                Log.i(TAG, "failed update");
            }
        });
    }

    public void deleteEvent(String id){
        restClientEvent.get().deleteEvent(id, new Callback<retrofit.client.Response>() {
            @Override
            public void success(retrofit.client.Response response, retrofit.client.Response response2) {
                Log.i(TAG, "delete ok");
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                Log.i(TAG, "delete fail");
            }
        });
    }

    public Event getEvent(String id){
        restClientEvent.get().getEvent(id, new Callback<Event>() {
            @Override
            public void success(Event event, retrofit.client.Response response) {
                Log.i(TAG,"get event ok"+event._id);
                returnevt=event;
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                Log.i(TAG,"FAIL get");
            }
        });
        return returnevt;
    }


}
