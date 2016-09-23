package com.qf.tgp.plamtv.ui.fragments.recommand;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.qf.tgp.plamtv.R;
import com.qf.tgp.plamtv.adapters.danmuAdapter;
import com.qf.tgp.plamtv.model.recommandmode.DanmuMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by nfkj on 2016/9/21.
 */
public class Danmu extends Fragment {
    @BindView(R.id.recommand_intent_lv)
    ListView recommandIntentLv;
    @BindView(R.id.re)
    ImageView re;
    @BindView(R.id.input)
    EditText input;

    @BindView(R.id.gift)
    ImageView gift;
    @BindView(R.id.send)
    ImageView send;
    private View view;
    private danmuAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.recommand_danmu, container, false);
        ButterKnife.bind(this, view);
        adapter = new danmuAdapter( null, getActivity(), R.layout.danmuitem);
        recommandIntentLv.setAdapter(adapter);
        return view;
    }

    @OnClick(R.id.send)
    public void onClick() {
        DanmuMode danmuMode = new DanmuMode();
        String text = input.getText().toString();
        if (!TextUtils.isEmpty(text)) {
            danmuMode.setText(text);
            adapter.addOne(danmuMode);
        }else {
            Toast.makeText(getActivity(), "输入为空", Toast.LENGTH_SHORT).show();
        }
        InputMethodManager imm = (InputMethodManager) getActivity()
                .getSystemService(Context.INPUT_METHOD_SERVICE);
// 得到InputMethodManager的实例
        if (imm.isActive()) {
            imm.hideSoftInputFromWindow(getActivity().getCurrentFocus()
                    .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
        input.setText("");
        recommandIntentLv.smoothScrollToPosition(adapter.getCount());
    }
}
