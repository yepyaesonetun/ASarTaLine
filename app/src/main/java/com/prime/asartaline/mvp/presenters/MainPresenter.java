package com.prime.asartaline.mvp.presenters;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.prime.asartaline.data.models.WarDeeModel;
import com.prime.asartaline.data.vo.MealShopVO;
import com.prime.asartaline.data.vo.WarDeeVO;
import com.prime.asartaline.delegates.WarDeeItemDelegate;
import com.prime.asartaline.mvp.views.MainView;

import java.util.List;

/**
 * Created by yepyaesonetun on 7/5/18.
 **/

public class MainPresenter extends BasePresenter<MainView> implements WarDeeItemDelegate {

    private MutableLiveData<List<WarDeeVO>> mWarDeeVOListLD;
    private MutableLiveData<List<MealShopVO>> mMealShopVOListLD;
    private static final int INITIAL_PAGE_INDEX = 1;

    @Override
    public void onTapWarDeeItem(String id) {
        mView.navigateToDetail(id);
    }

    @Override
    public void initPresenter(MainView mView) {
        super.initPresenter(mView);
        mWarDeeVOListLD = new MutableLiveData<>();
        mMealShopVOListLD = new MutableLiveData<>();
        loadData(INITIAL_PAGE_INDEX);
    }

    public void loadData(int pageNo) {
        WarDeeModel.getInstance().startLoadingASTLData(pageNo, mWarDeeVOListLD, mMealShopVOListLD, mErrorLD);
    }

    public LiveData<List<WarDeeVO>> getWarDeeVOListLD() {
        return mWarDeeVOListLD;
    }

    public LiveData<List<MealShopVO>> getMealShopListLD() {
        return mMealShopVOListLD;
    }


}
