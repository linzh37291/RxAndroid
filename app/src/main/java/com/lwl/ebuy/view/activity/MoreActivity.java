package com.lwl.ebuy.view.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.lwl.ebuy.R;
import com.lwl.ebuy.presenter.MorePresenter;

public class MoreActivity extends BaseActivity  {

    private  TextView txtMore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        initView();
        new MorePresenter(MoreActivity.this).ObservableAction();
    }


    @Override
    public void initView() {

        txtMore =  findView(R.id.txtMore);
        
    }

    public   void setText(String s)
    {
        txtMore.setText(s);

    }
}
