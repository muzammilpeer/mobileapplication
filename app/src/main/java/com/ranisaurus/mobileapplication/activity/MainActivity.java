package com.ranisaurus.mobileapplication.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ranisaurus.baselayer.activity.BaseActivity;
import com.ranisaurus.mobileapplication.R;
import com.ranisaurus.mobileapplication.fragment.MainFragment;

import butterknife.Bind;

public class MainActivity extends BaseActivity {

    @Bind(R.id.tb_main_toolbar)
    Toolbar mainToolbar;

    @Bind(R.id.ib_save)
    ImageButton saveImageButton;

    @Bind(R.id.ib_back)
    ImageButton backImageButton;

    @Bind(R.id.tv_title)
    TextView titleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupActivity();
        //setup first screen
        MainFragment fragment = new MainFragment();
        addFragment(fragment, R.id.container_main);
    }

    @Override
    public void initViews() {
        super.initViews();

//        setSupportActionBar(mainToolbar);
    }

    @Override
    public void initListenerOrAdapter() {
        super.initListenerOrAdapter();



        saveImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Saving", Snackbar.LENGTH_SHORT).show();
            }
        });

        backImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    @Override
    public void initObjects() {
        super.initObjects();
    }

    @Override
    public void setScreenTitle(int title) {
        super.setScreenTitle(title);
        titleTextView.setText(getString(title));
    }

    @Override
    public void showBackButton() {
        super.showBackButton();
        backImageButton.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideBackButton() {
        super.hideBackButton();
        backImageButton.setVisibility(View.GONE);

    }

    @Override
    public void hideToolbarItems() {
        super.hideToolbarItems();
        saveImageButton.setVisibility(View.GONE);
    }

    @Override
    public void showToolbarItems() {
        super.showToolbarItems();
        saveImageButton.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id)
        {
            case R.id.action_save :
            {
//                Snackbar.make(v, "Saving", Snackbar.LENGTH_SHORT).show();
            }break;
        }

        return super.onOptionsItemSelected(item);
    }
}
