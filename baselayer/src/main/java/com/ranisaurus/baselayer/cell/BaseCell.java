package com.ranisaurus.baselayer.cell;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by muzammilpeer on 8/30/15.
 */
abstract public  class BaseCell extends RecyclerView.ViewHolder {

    public BaseCell(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    abstract public void updateCell(Object model);
}