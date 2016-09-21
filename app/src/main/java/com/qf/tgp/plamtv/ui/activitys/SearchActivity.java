package com.qf.tgp.plamtv.ui.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.qf.tgp.plamtv.R;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toast.makeText(SearchActivity.this, "我是搜索页面,功能还未实现!", Toast.LENGTH_SHORT).show();
    }
}
