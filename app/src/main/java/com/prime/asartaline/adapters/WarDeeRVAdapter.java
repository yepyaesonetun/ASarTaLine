package com.prime.asartaline.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.prime.asartaline.R;
import com.prime.asartaline.data.vo.WarDeeVO;
import com.prime.asartaline.delegates.WarDeeItemDelegate;
import com.prime.asartaline.viewholders.BaseViewHolder;
import com.prime.asartaline.viewholders.CategoriesViewHolder;
import com.prime.asartaline.viewholders.WarDeeListViewHolder;

/**
 * Created by yepyaesonetun on 7/2/18.
 **/

public class WarDeeRVAdapter extends BaseRecyclerAdapter<BaseViewHolder, WarDeeVO> {
    private static final int VT_CATEGORY = 1;
    private static final int VT_LIST = 2;

    private WarDeeItemDelegate mItemDelegate;

    public WarDeeRVAdapter(Context context, WarDeeItemDelegate delegate) {
        super(context);
        mItemDelegate = delegate;
    }


    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case VT_CATEGORY:
                return new CategoriesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false));

            case VT_LIST:
                return new WarDeeListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false), mItemDelegate);
        }
        return null;
    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VT_CATEGORY;
        } else if (position == 1) {
            return VT_LIST;
        } else {
            return VT_LIST;
        }
    }
}
