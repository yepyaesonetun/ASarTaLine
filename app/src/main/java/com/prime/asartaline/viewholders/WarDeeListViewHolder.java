package com.prime.asartaline.viewholders;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.prime.asartaline.R;
import com.prime.asartaline.activities.WarDeeDetailActivity;
import com.prime.asartaline.data.vo.WarDeeVO;
import com.prime.asartaline.delegates.WarDeeItemDelegate;
import com.prime.asartaline.utils.GlideApp;

import org.mmtextview.components.MMTextView;

import butterknife.BindView;

/**
 * Created by yepyaesonetun on 7/2/18.
 **/

public class WarDeeListViewHolder extends BaseViewHolder<WarDeeVO> {

    @BindView(R.id.iv_warDee)
    ImageView ivWarDee;

    @BindView(R.id.tv_warDee_name)
    MMTextView tvName;

    @BindView(R.id.tv_warDee_taste)
    MMTextView tvTaste;

    @BindView(R.id.tv_warDee_price)
    TextView tvPrice;

    private WarDeeItemDelegate mDelegate;
    private WarDeeVO mWarDeeVO;

    public WarDeeListViewHolder(View itemView, WarDeeItemDelegate delegate) {
        super(itemView);
        mDelegate = delegate;
    }

    @Override
    public void setData(WarDeeVO data) {
        mWarDeeVO = data;

        GlideApp.with(ivWarDee.getContext())
                .load(data.getImages().get(0))
                .into(ivWarDee);

        tvName.setText(data.getName());
        tvTaste.setText(data.getGeneralTaste().get(0).getTaste());
        tvPrice.setText(data.getPriceRangeMin() + " - " + data.getPriceRangeMax());

    }

    @Override
    public void onClick(View v) {
        mDelegate.onTapWarDeeItem(mWarDeeVO.getWarDeeId());
    }
}
