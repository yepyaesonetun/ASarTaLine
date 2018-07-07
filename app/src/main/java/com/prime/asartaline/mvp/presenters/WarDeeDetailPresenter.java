package com.prime.asartaline.mvp.presenters;

import android.arch.lifecycle.LiveData;

import com.prime.asartaline.data.models.WarDeeModel;
import com.prime.asartaline.data.vo.WarDeeVO;
import com.prime.asartaline.mvp.views.WarDeeDetailView;

/**
 * Created by yepyaesonetun on 7/5/18.
 **/

public class WarDeeDetailPresenter extends BasePresenter<WarDeeDetailView> {

    @Override
    public void initPresenter(WarDeeDetailView mView) {
        super.initPresenter(mView);
    }

    public LiveData<WarDeeVO> onUiReady(String id){
        return WarDeeModel.getInstance().getWarDeeByIdLD(id);
    }
}
