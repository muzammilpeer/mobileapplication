package com.ranisaurus.baselayer.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.koushikdutta.ion.Ion;
import com.ranisaurus.utilitylayer.logger.Log4a;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public void replaceFragment(Fragment frag, int containerID) {
        getSupportFragmentManager().beginTransaction()
                .replace(containerID, frag).addToBackStack(null)
                .commit();
    }

    public void replaceFragmentWithoutStack(Fragment frag, int containerID) {
        getSupportFragmentManager().beginTransaction()
                .replace(containerID, frag)
                .commit();
    }

    public void addFragment(Fragment frag, int containerID) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(containerID,
                        frag).commit();
    }


    public void popAllFragment() {
        FragmentManager fm = getSupportFragmentManager();
        for (int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();
        }
    }

    public Fragment getLastFragment() {
        FragmentManager fm = getSupportFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            return fm.getFragments().get(fm.getBackStackEntryCount());
        }
        return null;
    }


    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            Ion.getDefault(this).cancelAll(getApplicationContext());
        } catch (Exception e) {
            Log4a.printException(e);
        }
    }

}
