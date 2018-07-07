package com.prime.asartaline.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.prime.asartaline.R;
import com.prime.asartaline.data.vo.WarDeeVO;
import com.prime.asartaline.mvp.presenters.WarDeeDetailPresenter;
import com.prime.asartaline.mvp.views.WarDeeDetailView;
import com.prime.asartaline.utils.GlideApp;

import org.mmtextview.components.MMTextView;

import butterknife.BindView;

/**
 * Created by yepyaesonetun on 7/3/18.
 **/

public class WarDeeDetailActivity extends BaseActivity implements WarDeeDetailView{

    private static final String IE_WAR_DEE_ID ="IE_WAR_DEE_ID";

    @BindView(R.id.iv_backdrop)
    ImageView ivBackDrop;

    @BindView(R.id.tv_detail_warDee_name)
    MMTextView tvDetailWarDeeName;

    @BindView(R.id.tv_detail_price_range_value)
    TextView tvPriceRange;

    @BindView(R.id.tv_detail_warDee_taste)
    MMTextView tvTaste;

    @BindView(R.id.tv_detail_warDee_suitedFor)
    MMTextView tvSuitedFor;

    @BindView(R.id.tv_detail_warDee_taste_description)
    MMTextView tvTasteDescription;  // adding now as brief

    private WarDeeDetailPresenter mPresenter;


    public static Intent getNewIntent(Context context, String id){
        Intent intent = new Intent(context, WarDeeDetailActivity.class);
        intent.putExtra(IE_WAR_DEE_ID, id);
        return intent;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_detail;
    }

    @Override
    protected void setUpContents(Bundle savedInstanceState) {
        setupToolbar(true);
        setupToolbarText("Detail");

        mPresenter = ViewModelProviders.of(this).get(WarDeeDetailPresenter.class);
        mPresenter.initPresenter(this);

        String idExtra = getIntent().getStringExtra(IE_WAR_DEE_ID);
        Log.d("IE_WAR_DEE_ID", "IE_WAR_DEE_ID " + idExtra );

        mPresenter.onUiReady(idExtra).observe(this, warDeeVO -> displayWarDeeData(warDeeVO));
    }

    @Override
    public void displayWarDeeData(WarDeeVO warDeeVO) {

        GlideApp.with(ivBackDrop.getContext())
                .load(warDeeVO.getImages().get(0))
                .into(ivBackDrop);

        tvDetailWarDeeName.setText(warDeeVO.getName());
        tvPriceRange.setText(warDeeVO.getPriceRangeMin() + " - " + warDeeVO.getPriceRangeMax());
        if (warDeeVO.getGeneralTaste() != null
                && warDeeVO.getGeneralTaste().size() >0) {
            tvTaste.setText(warDeeVO.getGeneralTaste().get(0).getTaste());
        }
    }
}
