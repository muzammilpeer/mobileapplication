package com.ranisaurus.mobileapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.ranisaurus.baselayer.fragment.BaseFragment;
import com.ranisaurus.mobileapplication.R;
import com.ranisaurus.mobileapplication.config.Constants;

import butterknife.Bind;

/**
 * Created by muzammilpeer on 8/30/15.
 */
public class TagLineDetailFragment extends BaseFragment {

    @Bind(R.id.etTagLine)
    EditText tagLineEditText;

    @Bind(R.id.etHowTo)
    EditText howToEditText;


    public TagLineDetailFragment() {
    }

    public static BaseFragment createInstance(String taglineID)
    {
        TagLineDetailFragment fragment = new TagLineDetailFragment();
        Bundle args = new Bundle();
        args.putString(Constants.TAG_LINE_ID,taglineID);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater,R.layout.fragment_tagline_detail);

        if (getArguments() != null)
        {
            Toast.makeText(mContext, "Some Data " + getArguments().getString(Constants.TAG_LINE_ID), Toast.LENGTH_SHORT).show();
        }

        return mView;
    }

    @Override
    public void initObjects() {
        super.initObjects();


    }

    @Override
    public void initListenerOrAdapter() {
        super.initListenerOrAdapter();





    }

    @Override
    public void initNetworkCalls() {
        super.initNetworkCalls();
    }

    // listener



}
