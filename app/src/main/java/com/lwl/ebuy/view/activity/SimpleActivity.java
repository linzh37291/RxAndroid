package com.lwl.ebuy.view.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.lwl.ebuy.R;
import com.lwl.ebuy.presenter.SimplePresenter;
import com.lwl.ebuy.view.IView;


public class SimpleActivity extends BaseActivity  {


    private TextView txtSimple;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        initView();
        new SimplePresenter(SimpleActivity.this).ObservableAction();


    }






    public void setText(String s)
    {
       txtSimple.setText(s);

    }


    @Override
    public void initView() {
        txtSimple = findView(R.id.txtSimple);
    }
}
