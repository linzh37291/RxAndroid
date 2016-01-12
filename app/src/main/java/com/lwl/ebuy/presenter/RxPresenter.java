package com.lwl.ebuy.presenter;


import java.lang.ref.WeakReference;

/**
 * Created by jonn on 2016/1/5.
 */
public abstract class RxPresenter<T> implements IPresenter<T>{
    protected WeakReference<T> rView;

    public T getRxView()
    {

        return rView.get();
    }

    public void setRxView(T view)
    {
        this.rView = new WeakReference<T>(view);
    }




    protected RxPresenter() {
    }

    protected RxPresenter(T view) {

     setRxView(view);
    }






    /**
     * 线程任务调用这个方法
     */
    public  abstract  void ObservableAction();
}
