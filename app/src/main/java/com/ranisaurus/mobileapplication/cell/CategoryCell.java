package com.ranisaurus.mobileapplication.cell;

import android.view.View;
import android.widget.TextView;

import com.ranisaurus.baselayer.cell.BaseCell;
import com.ranisaurus.mobileapplication.R;

import butterknife.Bind;

/**
 * Created by muzammilpeer on 8/30/15.
 */
public class CategoryCell extends BaseCell {
    public @Bind(R.id.cat_name_textview) TextView mCatNameTextView;

    public CategoryCell(View itemView) {
        super(itemView);
    }

    @Override
    public void updateCell(Object model) {
        mCatNameTextView.setText((String)model);
    }
}

