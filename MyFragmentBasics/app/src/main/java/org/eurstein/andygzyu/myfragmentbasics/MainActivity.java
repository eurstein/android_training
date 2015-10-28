package org.eurstein.andygzyu.myfragmentbasics;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements HeadlinesFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("andygzyu-log", "onCreate was called, savedInstanceState = " + savedInstanceState);

        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


        setContentView(R.layout.news_articles);

        // 确认 Activity 使用的布局版本包含
        // fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null) {

            // 不过，如果我们要从先前的状态还原，
            // 则无需执行任何操作而应返回
            // 否则就会得到重叠的 Fragment。
            if (savedInstanceState != null) {
                // andy note: 因为savedInstanceState保存了之前的fragment状态，会自动创建fragment
                // 验证1：debug观察savedInstanceState对象，其中有保存fragment
                // 验证2：重写onRestoreInstanceState和onSaveInstanceState，不调用super的默认实现观察验证
                return;
            }

            // 创建一个要放入 Activity 布局中的新 Fragment
            HeadlinesFragment firstFragment = new HeadlinesFragment();

            // 如果此 Activity 是通过 Intent 发出的特殊指令来启动的，
            // 请将该 Intent 的 extras 以参数形式传递给该 Fragment
            firstFragment.setArguments(getIntent().getExtras());

            // 将该 Fragment 添加到“fragment_container"FragmentLayout 中
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, firstFragment).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Log.d("andygzyu-log", "onFragmentInteraction was called");
    }

    /**
     * 不调用onRestoreInstanceState和onSaveInstanceState的默认实现，将不会保存UI的状态
     *
     *   测试：
     *   1. 在EditText中输入文本，
     *   2. 旋转屏幕
     *   3. 观察步骤1中输入的文本是否有保留
     *
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("andygzyu-log", "onRestoreInstanceState was called, savedInstanceState = " + savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("andygzyu-log", "onSaveInstanceState was called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("andygzyu-log", "onResume was called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("andygzyu-log", "onPause was called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("andygzyu-log", "onRestart was called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("andygzyu-log", "onStart was called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("andygzyu-log", "onDestroy was called");
    }
}
