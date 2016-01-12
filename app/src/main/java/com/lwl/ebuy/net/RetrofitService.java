package com.lwl.ebuy.net;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lwl.ebuy.bean.User;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.RxJavaCallAdapterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.Header;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;
import rx.Subscriber;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by lwl on 1/6/2016.
 */
public class RetrofitService implements RetrofitInterface {
    private static RetrofitService retrofitService = null;
    private RetrofitInterface retrofitInterface;
    private String methodName;
    private static Context rContext;

    private RetrofitService(){initRetrofit();}

    public static RetrofitService getInstance(Context context){
        rContext =  context;
        if(retrofitService == null){
            retrofitService = new RetrofitService();
        }
        return retrofitService;
    }

    private void initRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        retrofitInterface = retrofit.create(RetrofitInterface.class);
    }






    public Call<User> rGetUser1()
    {

        methodName="rGetUser1";
        Call<User> call =  retrofitInterface.rGetUser1();
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Response<User> response) {
                Log.e(methodName+":success",response.body().toString());
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.e(methodName+":fail",throwable.toString());
            }
        });

        return call;



    }

    @Override
    public Call<User> rGetUser2() {
        methodName = "rGetUser2";
        Call<User> call = retrofitInterface.rGetUser2();
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Response<User> response) {
                Log.e(methodName+":success",response.body().toString());
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.e(methodName+":fail",throwable.toString());
            }
        });

        return call;


    }

    @Override
    public Call<User> rGetUser3(@Path("next") String path, @Query("gsonBean") String str) {
        methodName = "rGetUser3";
        Call<User> call = retrofitInterface.rGetUser3("next",(new Gson()).toJson(new User("from手机",methodName)) );
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Response<User> response) {
                Log.e(methodName+":success",response.body().toString());
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.e(methodName+":fail",throwable.toString());
            }
        });

        return call;
    }

    @Override
    public Call<User> rGetUser4(@Path("next") String path, @QueryMap Map<String, String> options) {
        methodName = "rGetUser4";
        HashMap<String,String> h = new HashMap<String, String>();
        h.put("gsonBean",(new Gson()).toJson(new User("from手机",methodName)));
        Call<User> call = retrofitInterface.rGetUser4("next",h);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Response<User> response) {
                Log.e(methodName+":success",response.body().toString());
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.e(methodName+":fail",throwable.toString());
            }
        });

        return call;
    }

    @Override
    public Call<User> rGetUser5() {
        methodName = "rGetUser5";
        Call<User> call = retrofitInterface.rGetUser5();
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Response<User> response) {
                Log.e(methodName+":success",response.body().toString());
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.e(methodName+":fail",throwable.toString());
            }
        });

        return call;

    }

    @Override
    public Call<User> rGetUser6() {
        methodName = "rGetUser6";
        Call<User> call = retrofitInterface.rGetUser6();
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Response<User> response) {
                Log.e(methodName+":success",response.body().toString());
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.e(methodName+":fail",throwable.toString());
            }
        });

        return call;

    }

    @Override
    public Call<User> rGetUser7(@Header("Authorization") String authorization) {
        methodName = "rGetUser7";
        Call<User> call = retrofitInterface.rGetUser7("lwl");
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Response<User> response) {
                Log.e(methodName+":success",response.body().toString());
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.e(methodName+":fail",throwable.toString());
            }
        });

        return call;
    }

    @Override
    public Call<User> rPostUser1(@Body User user) {
        methodName = "rPostUser1";
        Call<User> call = retrofitInterface.rPostUser1(new User("from手机",methodName));
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Response<User> response) {
                Log.e(methodName+":success",response.body().toString());
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.e(methodName+":fail",throwable.toString());
            }
        });

        return call;
    }

    @Override
    public Call<User> rPostUser2(@Field("gsonBean") String obj) {
        methodName = "rPostUser2";
        Call<User> call = retrofitInterface.rPostUser2((new Gson()).toJson(new User("from手机",methodName)));
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Response<User> response) {
                Log.e(methodName+":success",response.body().toString());
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.e(methodName+":fail",throwable.toString());
            }
        });

        return call;
    }

    /**
     * 注意，每一次return的对象不是同一个observable对象，所以一般要连续调用RxJava的函数
     * @param obj
     * @return
     */
    @Override
    public Observable<User> rPostUser3(@Field("gsonBean") String obj) {
        methodName = "rPostUser3";
        Observable<User> observable = retrofitInterface.rPostUser3((new Gson()).toJson(new User("from手机",methodName)));
        observable.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<User>() {
                     @Override
                    public void onCompleted() {

                         Toast.makeText( rContext,
                                 "onCompleted",
                                 Toast.LENGTH_SHORT)
                                 .show();
                    }

                    @Override
                    public void onError(Throwable throwable) {

                        Toast.makeText( rContext,
                               throwable.toString(),
                                Toast.LENGTH_SHORT)
                                .show();
                    }

                    @Override
                    public void onNext(User user) {

                        Toast.makeText( rContext,
                               user.toString(),
                                Toast.LENGTH_LONG)
                                .show();
                    }

                });
        return observable;
    }

    @Override
    public Call<User> rPutUser1(@Part("gsonBean") User user) {
        methodName = "rPutUser1";
        Call<User> call = retrofitInterface.rPutUser1(new User("from手机",methodName));
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Response<User> response) {
                Log.e(methodName+":success",response.body().toString());
            }

            @Override
            public void onFailure(Throwable throwable) {
                Log.e(methodName+":fail",throwable.toString());
            }
        });

        return call;
    }




}
