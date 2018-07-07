package com.prime.asartaline.mvp.presenters;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.prime.asartaline.mvp.views.BaseView;

/**
 * Created by yepyaesonetun on 7/5/18.
 **/

public abstract class BasePresenter<T extends BaseView> extends ViewModel {

    protected T mView;
    protected MutableLiveData<String> mErrorLD;

    public void initPresenter(final T mView){
        this.mView = mView;
        mErrorLD = new MutableLiveData<>();
    }

    public MutableLiveData<String> getErrorLD() {
        return mErrorLD;
    }
}
