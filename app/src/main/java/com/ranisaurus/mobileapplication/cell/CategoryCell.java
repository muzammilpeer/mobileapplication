package com.ranisaurus.mobileapplication.cell;

import android.view.View;
import android.widget.TextView;

import com.ranisaurus.baselayer.cell.BaseCell;
import com.ranisaurus.mobileapplication.R;
import com.ranisaurus.mobileapplication.fragment.TagLineFragment;

import butterknife.Bind;

/**
 * Created by muzammilpeer on 8/30/15.
 */
public class CategoryCell extends BaseCell implements View.OnClickListener{
    public @Bind(R.id.tv_category_row) TextView tvTitle;

    public CategoryCell(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
    }

    @Override
    public void updateCell(Object model) {
        mDataSource = model;
        tvTitle.setText((String) model);
    }

    @Override
    public void onClick(View v) {
        long position = this.getLayoutPosition();
        getBaseActivity().replaceFragment(TagLineFragment.createInstance((String) mDataSource), R.id.container_main);

    }

}

