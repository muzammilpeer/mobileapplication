package com.ranisaurus.mobileapplication.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ranisaurus.baselayer.adapter.GeneralBaseAdapter;
import com.ranisaurus.baselayer.fragment.BaseFragment;
import com.ranisaurus.mobileapplication.R;
import com.ranisaurus.mobileapplication.cell.CategoryCell;

import butterknife.Bind;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends BaseFragment {

    @Bind(R.id.srl_categories)
    SwipeRefreshLayout categoriesSwipeRefreshLayout;

    @Bind(R.id.rv_categories)
    RecyclerView categoriesRecyclerView;

    GeneralBaseAdapter<CategoryCell> categoryAdapter;

    public MainFragment() {
    }

    public static BaseFragment createInstance()
    {
        TagLineFragment fragment = new TagLineFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, R.layout.fragment_main);

        return mView;
    }

    @Override
    public void initObjects() {
        super.initObjects();

        this.getLocalDataSource().add("test1");
        this.getLocalDataSource().add("test2");
        this.getLocalDataSource().add("test3");
        this.getLocalDataSource().add("test4");
        this.getLocalDataSource().add("test5");
        this.getLocalDataSource().add("test6");
    }

    @Override
    public void initListenerOrAdapter() {
        super.initListenerOrAdapter();


        final LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        categoriesRecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new GeneralBaseAdapter<CategoryCell>(mContext,R.layout.row_category,CategoryCell.class,this.getLocalDataSource());
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

    // listener



}
