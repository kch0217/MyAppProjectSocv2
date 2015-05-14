package hk.ust.cse.comp4521.eventmaker.restForUser;

import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.Executor;

import hk.ust.cse.comp4521.eventmaker.Constants;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by Ken on 25/4/2015.
 */
public class RestClient {
    private static userServerAPI restClient;

    static {
        setupRestClient();
    }

    public static void restart(){
        restClient = null;
        setupRestClient();
    }

    private RestClient() {}

    public static userServerAPI get() {
        return restClient;
    }

    private static void setupRestClient() {
        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(Constants.SERVER_URL)
                .setErrorHandler(new RetrofitErrorHandler())
                .setClient(new OkClient(new OkHttpClient()))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setExecutors(new executeRest(), new executeRest()) ;

        RestAdapter restAdapter = builder.build();
        restClient = restAdapter.create(userServerAPI.class);
    }

    private static class executeRest implements Executor{

        @Override
        public void execute(Runnable runnable) {
            new Thread(runnable).start();
        }
    }
}
