package com.ranisaurus.mobileapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ranisaurus.baselayer.fragment.BaseFragment;
import com.ranisaurus.mobileapplication.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends BaseFragment {

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}
