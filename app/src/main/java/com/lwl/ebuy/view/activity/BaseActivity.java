package com.lwl.ebuy.view.activity;

import android.app.Activity;

import com.lwl.ebuy.view.IView;

/**
 * Created by jonn on 2016/1/5.
 */
public abstract class BaseActivity extends Activity implements IView {


    public  <T> T findView(int id){

        return (T)findViewById(id);
    }
}
