package com.qf.tgp.plamtv.ui.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

import com.qf.tgp.plamtv.MainActivity;
import com.qf.tgp.plamtv.R;
import com.qf.tgp.plamtv.utils.TVConstants;

public class SplashActivity extends AppCompatActivity implements Handler.Callback{


    private Handler mHandler = new Handler(this);
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mHandler.sendEmptyMessageDelayed(TVConstants.GO_MAIN,TVConstants.DELAY_TIME);
    }

    @Override
    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case TVConstants.GO_MAIN:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                this.finish();
                break;
        }

        return false;
    }
}
