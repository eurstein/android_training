package org.eurstein.andygzyu.myfirstapp;

import android.content.Intent;
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
import android.widget.EditText;

public class MyActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "org.eurstein.andygzyu.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("andygzyu-log", "onCreate was called, savedInstanceState = " + savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
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

    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        // Do something in response to button
        Log.d("andygzyu-log", "sendMessage called");
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    /**
     * Intent.createChooser强制弹应用选择框
     *
     * 1. 仅有一个应用能响应Intent时：直接跳对应应用
     * 2. 有多个应用能响应Intent时：弹应用选择框，且不带默认设置项
     * 3. 有多个应用能响应Intent时，且之前针对此类应用有选择过默认值：依然弹应用选择框
     */
    /** Intents and Intent Filters: Forcing an app chooser */
    private void forcingAnAppChooser() {
        Uri uri = Uri.parse("http://www.baidu.com");
        Intent sendIntent = new Intent(Intent.ACTION_VIEW, uri);
// Always use string resources for UI text.
// This says something like "Share this photo with"
        String title = getResources().getString(R.string.button_send);
// Create intent to show the chooser dialog
        Intent chooser = Intent.createChooser(sendIntent, title);

// Verify the original intent will resolve to at least one activity
        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }
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
//        super.onRestoreInstanceState(savedInstanceState);
        Log.d("andygzyu-log", "onRestoreInstanceState was called, savedInstanceState = " + savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
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
