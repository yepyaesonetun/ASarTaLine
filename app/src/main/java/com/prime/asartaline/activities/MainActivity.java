package com.prime.asartaline.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.prime.asartaline.R;
import com.prime.asartaline.adapters.WarDeeRVAdapter;
import com.prime.asartaline.components.EmptyViewPod;
import com.prime.asartaline.components.SmartRecyclerView;
import com.prime.asartaline.data.vo.ShopVO;
import com.prime.asartaline.data.vo.WarDeeVO;
import com.prime.asartaline.mvp.presenters.MainPresenter;
import com.prime.asartaline.mvp.views.MainView;

import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements MainView{

    @BindView(R.id.rv_main_warDee)
    SmartRecyclerView rvMain;

    @BindView(R.id.cv_main_search_meal_shop)
    CardView cvMainSearch;

    @BindView(R.id.vp_empty)
    EmptyViewPod emptyViewPod;

    private WarDeeRVAdapter warDeeRVAdapter;
    private MainPresenter mPresenter;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected void setUpContents(Bundle savedInstanceState) {

        setupToolbar(false);
        setupToolbarText("");

        cvMainSearch.setVisibility(View.VISIBLE);
        emptyViewPod.setVisibility(View.GONE);

        mPresenter =  ViewModelProviders.of(this).get(MainPresenter.class);
        mPresenter.initPresenter(this);

        warDeeRVAdapter = new WarDeeRVAdapter(this, mPresenter);
        rvMain.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvMain.setAdapter(warDeeRVAdapter);

        cvMainSearch.setOnClickListener(v -> Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show());



        mPresenter.getWarDeeVOListLD().observe(this, warDeeVOS -> displayWarDeeListData(warDeeVOS));

        mPresenter.getMealShopListLD().observe(this, mealShopVOS -> displayMealShopListData(mealShopVOS));

        mPresenter.getErrorLD().observe(this, s -> {
//            cvMainSearch.setVisibility(View.GONE);
//            emptyViewPod.setVisibility(View.VISIBLE);
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
        });
    }

    private void displayMealShopListData(List<ShopVO> mealShopVOS) {
        Toast.makeText(this, mealShopVOS.get(0).getName(), Toast.LENGTH_SHORT).show();
    }

    private void displayWarDeeListData(List<WarDeeVO> warDeeVOS) {
        cvMainSearch.setVisibility(View.VISIBLE);
        emptyViewPod.setVisibility(View.GONE);
        warDeeRVAdapter.appendNewData(warDeeVOS);
    }

    @Override
    public void navigateToDetail(String id) {
        Intent intent = WarDeeDetailActivity.getNewIntent(this, id);
        startActivity(intent);
    }
}
