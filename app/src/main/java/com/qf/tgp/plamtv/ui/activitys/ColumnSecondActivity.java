package com.qf.tgp.plamtv.ui.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.qf.tgp.plamtv.R;
import com.qf.tgp.plamtv.adapters.ColumnSecondAdapter;
import com.qf.tgp.plamtv.constants.HttpConstants;
import com.qf.tgp.plamtv.model.columnmodel.ColumnSecondModel;
import com.qf.tgp.plamtv.ui.fragments.ColumnFragment;
import com.qf.tgp.plamtv.utils.TVConstants;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ColumnSecondActivity extends AppCompatActivity implements ColumnSecondAdapter.OnRecyclerClickListener, View.OnClickListener {

    private static final String TAG = ColumnSecondActivity.class.getSimpleName();
    @BindView(R.id.column_second_back)
    ImageView mSecondBack;
    @BindView(R.id.column_second_name)
    TextView mSecondName;
    @BindView(R.id.column_second_recycler_view)
    RecyclerView mSecondRecyclerView;
    private ColumnSecondAdapter adapter;
    private String name;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_column_second);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        position = intent.getIntExtra("position",0);
        Log.e(TAG, "onCreate: count = "+ position);
        mSecondName.setText(name);

        initView();
        setupView();
    }

    private void initView() {
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        mSecondRecyclerView.setLayoutManager(layoutManager);
        adapter = new ColumnSecondAdapter(this,null);
        mSecondRecyclerView.setAdapter(adapter);
        adapter.setListener(this);
        mSecondBack.setOnClickListener(this);
    }

    private void setupView() {
        RequestParams params = new RequestParams(HttpConstants.COLUMN_SECOND_URL_HEAD + TVConstants.NAME[position] + HttpConstants.COLUMN_SECOND_URL_MID + TVConstants.COUNT[position] + HttpConstants.COLUMN_SECOND_URL_FOOT);
        x.http().get(params, new Callback.CommonCallback<ColumnSecondModel>() {
            @Override
            public void onSuccess(ColumnSecondModel result) {
                Log.e(TAG, "onSuccess: "+ result);
                List<ColumnSecondModel.DataBean> data = result.getData();
                adapter.addRes(data);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e(TAG, "onError: ");
            }

            @Override
            public void onCancelled(CancelledException cex) {
                Log.e(TAG, "onCancelled: ");
            }

            @Override
            public void onFinished() {
                Log.e(TAG, "onFinished: ");
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        //Toast.makeText(ColumnSecondActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ColumnThirdActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.column_second_back:
//                Intent intent = new Intent(this, ColumnFragment.class);
//                startActivity(intent);
                this.finish();
                break;
        }
    }
}
