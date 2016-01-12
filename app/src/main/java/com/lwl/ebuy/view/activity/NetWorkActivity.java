package com.lwl.ebuy.view.activity;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.lwl.ebuy.R;
import com.lwl.ebuy.presenter.NewWorkPresenter;
public class NetWorkActivity extends BaseActivity  {


    ListView list;
    String[] interfaceName = {"rGetUser1","rGetUser2","rGetUser3","rGetUser4","rGetUser5","rGetUser6","rGetUser7",
            "rPostUser1","rPostUser2","rPostUser3", "rPutUser1"};
    ArrayAdapter<String> adapter;

    public ListView getList() {
        return list;
    }

    public void setList(ListView list) {
        this.list = list;
    }

    public String[] getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String[] interfaceName) {
        this.interfaceName = interfaceName;
    }

    public ArrayAdapter<String> getAdapter() {
        return adapter;
    }

    public void setAdapter(ArrayAdapter<String> adapter) {
        this.adapter = adapter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_work);

        list = (ListView)findViewById(R.id.list);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,interfaceName);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new NewWorkPresenter(NetWorkActivity.this));
    }




    @Override
    public void initView() {

    }
}
