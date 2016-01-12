package com.lwl.ebuy.presenter;

import android.view.View;
import android.widget.AdapterView;

import android.widget.Toast;

import com.lwl.ebuy.net.RetrofitService;
import com.lwl.ebuy.view.activity.NetWorkActivity;

import rx.Subscriber;


/**
 * Created by jonn on 2016/1/5.
 */
public class NewWorkPresenter extends RxPresenter<NetWorkActivity> implements AdapterView.OnItemClickListener{





    public NewWorkPresenter(NetWorkActivity view) {
        super(view);
       // ObservableAction();
    }


    public String subscribeDone() {
        return "subscriber called.";
    }


    // 订阅者, 接收字符串, 提示信息
    Subscriber<String> mToastSubscriber = new Subscriber<String>() {
        @Override public void onCompleted() {

        }

        @Override public void onError(Throwable e) {

        }

        //回调
        @Override public void onNext(String s) {
            Toast.makeText(getRxView(), s, Toast.LENGTH_SHORT).show();
        }
    };






    @Override
    public void ObservableAction( ){

    

    }




    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String item = getRxView().getAdapter().getItem(position);

        if(item.equals("rGetUser1")){
            RetrofitService.getInstance(getRxView().getApplicationContext()).rGetUser1();
        }else if(item.equals("rGetUser2")){
            RetrofitService.getInstance(getRxView().getApplicationContext()).rGetUser2();
        }else if(item.equals("rGetUser3")) {
            RetrofitService.getInstance(getRxView().getApplicationContext()).rGetUser3(null,null);
        }
        else if(item.equals("rGetUser4")) {
            RetrofitService.getInstance(getRxView().getApplicationContext()).rGetUser4(null,null);
        }else if(item.equals("rGetUser5")) {
            RetrofitService.getInstance(getRxView().getApplicationContext()).rGetUser5();
        }else if(item.equals("rGetUser6")) {
            RetrofitService.getInstance(getRxView().getApplicationContext()).rGetUser6();
        }else if(item.equals("rGetUser7")) {
            RetrofitService.getInstance(getRxView().getApplicationContext()).rGetUser7(null);
        } else if(item.equals("rPostUser1")){
            RetrofitService.getInstance(getRxView().getApplicationContext()).rPostUser1(null);
        }else if(item.equals("rPostUser2")){
            RetrofitService.getInstance(getRxView().getApplicationContext()).rPostUser2(null);
        }else if(item.equals("rPostUser3")){
            RetrofitService.getInstance(getRxView().getApplicationContext()).rPostUser3(null);
        }else if(item.equals("rPutUser1")){
            RetrofitService.getInstance(getRxView().getApplicationContext()).rPutUser1(null);
        }

    }
}
