package com.prime.asartaline.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.prime.asartaline.R;

/**
 * Created by yepyaesonetun on 7/3/18.
 **/

public class WarDeeDetailActivity extends BaseActivity {

    private static final String IE_WAR_DEE_ID ="IE_WAR_DEE_ID";

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

        String idExtra = getIntent().getStringExtra(IE_WAR_DEE_ID);
        Log.d("IE_WAR_DEE_ID", "IE_WAR_DEE_ID " + idExtra );
    }
}
