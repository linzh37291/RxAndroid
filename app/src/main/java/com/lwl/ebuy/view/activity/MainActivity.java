package com.lwl.ebuy.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.lwl.ebuy.R;
import com.lwl.ebuy.view.IView;

public class MainActivity extends BaseActivity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    @Override
    public void initView() {


    }

    public  void gotoSimpleModule(View view)
    {
        startActivity(new Intent(MainActivity.this,SimpleActivity.class));

    }
    public  void gotoMoreModule(View view)
    {
        startActivity(new Intent(MainActivity.this,MoreActivity.class));

    }

    public  void gotoNetModule(View view)
    {
        startActivity(new Intent(MainActivity.this,NetWorkActivity.class));

    }



}
