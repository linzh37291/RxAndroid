package com.lwl.ebuy.presenter;

import android.widget.Toast;

import com.lwl.ebuy.view.activity.SimpleActivity;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by jonn on 2016/1/5.
 */
public class SimplePresenter extends RxPresenter<SimpleActivity>{





    public SimplePresenter(SimpleActivity view) {
        super(view);
       // ObservableAction();
    }


    public String subscribeDone() {
        return "subscriber called.";
    }

    Observable.OnSubscribe mObservableAction = new Observable.OnSubscribe<String>(){
        @Override public void call(Subscriber<? super String> subscriber) {
            //发送事件,注意，这里的参数不是用Rx传入的，是外部传入的
            subscriber.onNext(subscribeDone());
            //完成事件
            subscriber.onCompleted();

        }

    };


    // 订阅者, 接收字符串, 修改控件
    Subscriber<String> mTextSubscriber = new Subscriber<String>() {
        @Override public void onCompleted() {

        }

        @Override public void onError(Throwable e) {

        }

        //回调
        @Override public void onNext(String s) {
            getRxView().setText(s); // 设置文字
        }
    };

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
       Observable observable= Observable.create(mObservableAction).observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(mTextSubscriber);
        observable.subscribe(mToastSubscriber);
    }


}
