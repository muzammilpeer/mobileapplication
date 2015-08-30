package com.ranisaurus.mobileapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.ranisaurus.baselayer.fragment.BaseFragment;
import com.ranisaurus.mobileapplication.R;
import com.ranisaurus.mobileapplication.config.Constants;
import com.ranisaurus.newtorklayer.models.Taglines;

import butterknife.Bind;

/**
 * Created by muzammilpeer on 8/30/15.
 */
public class TagLineDetailFragment extends BaseFragment {

    @Bind(R.id.etTagLine)
    EditText tagLineEditText;

    @Bind(R.id.etHowTo)
    EditText howToEditText;

    String tagLineID,tagLineTitle,tagLineHowTo;

    public TagLineDetailFragment() {
    }

    public static BaseFragment createInstance(Taglines taglines)
    {
        TagLineDetailFragment fragment = new TagLineDetailFragment();
        Bundle args = new Bundle();
        args.putString(Constants.TAG_LINE_ID,taglines.getId());
        args.putString(Constants.TAG_LINE_TITLE,taglines.getTagline());
        args.putString(Constants.TAG_LINE_HOW,taglines.getHowTo());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (getArguments() != null)
        {
            tagLineID = getArguments().getString(Constants.TAG_LINE_ID);
            tagLineTitle = getArguments().getString(Constants.TAG_LINE_TITLE);
            tagLineHowTo = getArguments().getString(Constants.TAG_LINE_HOW);
        }

        super.onCreateView(inflater,R.layout.fragment_tagline_detail);


        return mView;
    }

    @Override
    public void initObjects() {
        super.initObjects();

        if (tagLineID != null)
        {
            tagLineEditText.setText(tagLineTitle);
            howToEditText.setText(tagLineHowTo);
            tagLineEditText.setEnabled(false);
            howToEditText.setEnabled(false);
        }

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
