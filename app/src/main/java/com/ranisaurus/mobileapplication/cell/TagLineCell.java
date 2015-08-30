package com.ranisaurus.mobileapplication.cell;

import android.view.View;
import android.widget.TextView;

import com.ranisaurus.baselayer.cell.BaseCell;
import com.ranisaurus.mobileapplication.R;
import com.ranisaurus.mobileapplication.fragment.TagLineDetailFragment;
import com.ranisaurus.newtorklayer.models.Taglines;

import butterknife.Bind;

/**
 * Created by muzammilpeer on 8/30/15.
 */
public class TagLineCell extends BaseCell implements View.OnClickListener {
    public @Bind(R.id.tv_tagline_row)
    TextView tvTitle;

    public TagLineCell(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
    }

    @Override
    public void updateCell(Object model) {
        mDataSource = model;
        tvTitle.setText(((Taglines) mDataSource).getTagline());
    }


    @Override
    public void onClick(View v) {
        long position = this.getLayoutPosition();
        getBaseActivity().replaceFragment(TagLineDetailFragment.createInstance(((Taglines) mDataSource)), R.id.container_main);
    }

}

