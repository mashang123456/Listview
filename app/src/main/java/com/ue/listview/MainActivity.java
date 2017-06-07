package com.ue.listview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity {

    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext  =this;
        //1.找到listview
        ListView lv_simple = (ListView) findViewById(R.id.lv_simple);

        //2.创建一个adapter对象
        MyListAdapter listAdapter = new MyListAdapter();
        //3.将adapter设置给listview
        lv_simple.setAdapter(listAdapter);
    }

    class MyListAdapter extends  BaseAdapter {

        private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        //getCount方法:告诉listview要显示多少个条目
        @Override
        public int getCount() {
            return 30;
        }
        //根据postion获取listview上条目对应的Bean数据，该方法不影响数据的展示，可以先不实现
        @Override
        public Object getItem(int position) {
            return null;
        }

        //getItemId:用来获取条目postion行的id，该方法不影响数据的展示，可以先不实现
        @Override
        public long getItemId(int position) {
            return 0;
        }


        //getview:告诉listview条目上显示的内容；返回一个View对象作为条目上的内容展示，该方法返回什么样的view,Listview的条目上就显示什么样的view。必须实现
        //屏幕上每显示一个条目getview方法就会被调用一次;convertView:曾经使用过的view对象，可以被重复使用,使用前要判断。
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            TextView view = null;

            if(convertView != null){//判断converView是否为空，不为空重新使用
                view = (TextView) convertView;
            }else{
                view = new TextView(mContext);//创建一个textView对象
            }
            view.setText("postion:"+position);//设置textview的内容
            view.setTextSize(40);
            map.put(view.hashCode(), 1);

            System.out.println("创建了"+map.size()+"个TextView对象");

            return view;
        }

    }

}
