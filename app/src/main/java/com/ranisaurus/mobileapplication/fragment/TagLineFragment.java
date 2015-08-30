package com.ranisaurus.mobileapplication.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ranisaurus.baselayer.adapter.GeneralBaseAdapter;
import com.ranisaurus.baselayer.fragment.BaseFragment;
import com.ranisaurus.mobileapplication.R;
import com.ranisaurus.mobileapplication.cell.TagLineCell;
import com.ranisaurus.mobileapplication.config.Constants;

import butterknife.Bind;

/**
 * Created by muzammilpeer on 8/30/15.
 */
public class TagLineFragment extends BaseFragment {

    @Bind(R.id.srl_taglines)
    SwipeRefreshLayout categoriesSwipeRefreshLayout;

    @Bind(R.id.rv_taglines)
    RecyclerView categoriesRecyclerView;

    GeneralBaseAdapter<TagLineCell> categoryAdapter;

    public TagLineFragment() {
    }

    public static BaseFragment createInstance(String taglineID)
    {
        TagLineFragment fragment = new TagLineFragment();
        Bundle args = new Bundle();
        args.putString(Constants.TAG_LINE_CATEGORY_ID,taglineID);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater,R.layout.fragment_tagline);

        if (getArguments() != null)
        {
            Toast.makeText(mContext, "Tag line " + getArguments().getString(Constants.TAG_LINE_CATEGORY_ID), Toast.LENGTH_SHORT).show();
        }

        return mView;
    }

    @Override
    public void initObjects() {
        super.initObjects();

        this.getLocalDataSource().add("test");
    }

    @Override
    public void initListenerOrAdapter() {
        super.initListenerOrAdapter();


        final LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        categoriesRecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new GeneralBaseAdapter<TagLineCell>(mContext,R.layout.row_tagline,TagLineCell.class,this.getLocalDataSource());
        categoriesRecyclerView.setAdapter(categoryAdapter);


//        categoriesSwipeRefreshLayout.setColorSchemeResources(R.color.orange, R.color.green, R.color.blue);
        categoriesSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
//                        setupAdapter();
                        categoriesSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 2500);
            }
        });

    }

    @Override
    public void initNetworkCalls() {
        super.initNetworkCalls();
    }
}
