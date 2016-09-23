package com.qf.tgp.plamtv.ui.fragments.recommand;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RadioGroup;

import com.qf.tgp.plamtv.R;
import com.qf.tgp.plamtv.adapters.GiftAdapter;
import com.qf.tgp.plamtv.model.live.LiveDetailModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nfkj on 2016/9/22.
 */
public class Liwupaihang extends Fragment implements RadioGroup.OnCheckedChangeListener {
    private static final String TAG = Liwupaihang.class.getSimpleName();
    @BindView(R.id.rg)
    RadioGroup rg;
    @BindView(R.id.liwupaihang_lv)
    ListView liwupaihangLv;
    private ArrayList<LiveDetailModel.RankWeek> total;
    private ArrayList<LiveDetailModel.RankWeek> curr;
    private GiftAdapter adapter01;
    private GiftAdapter adapter2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.liwu_paihang, container, false);
        Bundle arguments = getArguments();
        total = arguments.getParcelableArrayList("total");
        curr = arguments.getParcelableArrayList("curr");
        ButterKnife.bind(this, inflate);
        adapter01 = new GiftAdapter(curr,getActivity(), R.layout.liwupaihang_item,1);
        adapter2 = new GiftAdapter(total,getActivity(), R.layout.liwupaihang_item,2);
        rg.setOnCheckedChangeListener(this);
        liwupaihangLv.setAdapter(adapter01);
        return inflate;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.test1:
                liwupaihangLv.setAdapter(adapter01);
                break;
            case R.id.test2:
                liwupaihangLv.setAdapter(adapter2);
                break;
        }
    }
}
