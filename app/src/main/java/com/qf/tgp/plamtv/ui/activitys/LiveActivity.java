package com.qf.tgp.plamtv.ui.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.qf.tgp.plamtv.BaseActivity;
import com.qf.tgp.plamtv.R;
import com.qf.tgp.plamtv.model.LiveModel;

public class LiveActivity extends BaseActivity {

    private static final String TAG = LiveActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live);
        Intent intent = getIntent();
        LiveModel.DataBean item = (LiveModel.DataBean) intent.getParcelableExtra("itemData");
        Log.e(TAG, "onCreate: "+item.getNick() );
    }
}
