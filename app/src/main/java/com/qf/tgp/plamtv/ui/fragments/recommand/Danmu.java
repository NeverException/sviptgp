package com.qf.tgp.plamtv.ui.fragments.recommand;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.qf.tgp.plamtv.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nfkj on 2016/9/21.
 */
public class Danmu extends Fragment {
    @BindView(R.id.recommand_intent_lv)
    ListView recommandIntentLv;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.recommand_danmu, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
