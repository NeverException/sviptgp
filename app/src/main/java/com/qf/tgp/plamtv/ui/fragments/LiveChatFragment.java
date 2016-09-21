package com.qf.tgp.plamtv.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.qf.tgp.plamtv.BaseFragment;
import com.qf.tgp.plamtv.R;
import com.qf.tgp.plamtv.adapters.LivePopAdapter;
import com.qf.tgp.plamtv.utils.DipAndPxUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/9/20.
 */
public class LiveChatFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener, LivePopAdapter.OnItemClickListener {

    private static final String TAG = LiveChatFragment.class.getName();

    @BindView(R.id.live_chat_recyclerview)
    RecyclerView mLiveChatRecyclerview;
    @BindView(R.id.live_chat_hot)
    CheckBox mLiveChatHot;
    @BindView(R.id.live_chat_chat)
    EditText mLiveChatChat;
    @BindView(R.id.live_chat_gift)
    Button mLiveChatGift;
    private PopupWindow popupWindow;
    private LivePopAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.live_chat_fragment, container, false);
        ButterKnife.bind(this, layout);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        //热 信息
        mLiveChatHot.setOnCheckedChangeListener(this);
    }

    @OnClick({R.id.live_chat_gift})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.live_chat_gift:
                Log.e(TAG, "onClick: 选择礼物");
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            Log.e(TAG, "onCheckedChanged: 弹出窗口,选择信息");
            showPopupWindow(buttonView);
        } else {
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
        }
    }

    private void showPopupWindow(CompoundButton buttonView) {
        View contentView =LayoutInflater.from(getActivity()).inflate(R.layout.custom_popupwindow, null);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int heightPixels = displayMetrics.heightPixels;
        int widthPixels = displayMetrics.widthPixels;
        popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        int popHeight = heightPixels / 6;
        popupWindow.setHeight(popHeight);
        int popWidth = widthPixels / 2;
        popupWindow.setWidth(popWidth);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //返回true，点击其他区域不返回
                return false;
            }
        });
        //设置背景可以是 popupWindow正常关闭，点击任何地方
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.mipmap.live_default));
        popupWindow.setAnimationStyle(R.style.popAnimation);
        RecyclerView recyclerView = (RecyclerView) contentView.findViewById(R.id.popupwindow_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new LivePopAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        adapter.setListener(this);
        //显示 窗口
        popupWindow.showAtLocation(buttonView, Gravity.TOP | Gravity.LEFT, DipAndPxUtil.dp2dip(getActivity(),10), heightPixels-DipAndPxUtil.dp2dip(getActivity(),40)-popHeight);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                mLiveChatHot.setChecked(false);
            }
        });
    }

    @Override
    public void OnItemClick(int position) {
        Toast.makeText(getActivity(), adapter.getItem(position), Toast.LENGTH_SHORT).show();
        popupWindow.dismiss();
    }
}
