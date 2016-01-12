package com.lwl.ebuy.presenter;

import android.widget.Toast;

import com.lwl.ebuy.view.activity.MoreActivity;
import com.lwl.ebuy.view.activity.SimpleActivity;

import java.util.Arrays;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;

/**
 * Created by jonn on 2016/1/5.
 */
public class MorePresenter extends RxPresenter<MoreActivity>{





    public MorePresenter(MoreActivity view) {
        super(view);
       // ObservableAction();
    }




    public String subscribeDone() {
        return "subscriber called.";
    }



    final String[] manyWords = {"Hello","I","am","your","friend","lwl"};
    final List<String> manyWordsList = Arrays.asList(manyWords);




    /**
     * map是对输入数据的加工，转换类型
     */
    public void ObservableAction( ){

        Observable.just(subscribeDone())
                .observeOn(AndroidSchedulers.mainThread())
                .map(upperLetterFunc)
                .subscribe(textViewAction);
        //多次call
        Observable.from(manyWords)
                .observeOn(AndroidSchedulers.mainThread())
                .map(upperLetterFunc)
                .subscribe(toastAction);

        //flatMap把输入数组映射成集合，而不是直接拆分,只call一次
        //reduce 把多个数组的值，组合成一个数据
        Observable.just(manyWordsList)
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(oneLetterFunc)
                .reduce(mergeStringFunc)
                .subscribe(toastAction);


    }
    /**
     * Action设置toast
     */
    private Action1<String> toastAction = new Action1<String>(){
        @Override public void call(String s)
        { Toast.makeText(getRxView(),s,Toast.LENGTH_SHORT).show();}

    };
    /**
     * 类似订阅者，设置TextView
     * Action1代表最终动作，接受一个参数，不需要返回值
     */
    private Action1<String> textViewAction = new Action1<String>()
    {
        @Override
        public void call(String s) {
            getRxView().setText(s);
        }
    };
    /**
     * 设置映射函数
     * Func1代表使用一个参数的函数，前面是参数，后面是返回值
     */
    private Func1<List<String>,Observable<String>> oneLetterFunc = new Func1<List<String>,Observable<String>>(){
        @Override
        public Observable<String> call(List<String> strings) {
            return Observable.from(strings);//映射字符串,拆分，以便逐个执行操作
        }
    };


    /**
     * 设置大写字母
     *
     */
    private Func1<String,String> upperLetterFunc = new Func1<String,String>()
    {   @Override
        public String call(String s) {
            return s.toUpperCase();
        }
    };


    /**
     * 连接字符串
     */
    private Func2<String ,String,String> mergeStringFunc = new Func2<String,String,String>(){
        @Override
        public String call(String s, String s2) {
            return String.format("%s %s",s,s2);
        }
    };





}
