package com.ranisaurus.baselayer.view;

import android.content.Context;
import android.view.WindowManager;

/**
 * Created by muzammilpeer on 8/30/15.
 */
public class CircularLoader  {

    static CircularLoaderDialog globalProgressDialog;

    public static void showProgressLoader(Context context) {
        try {
            globalProgressDialog = new CircularLoaderDialog(context);
            if (globalProgressDialog.progressDialogCounter.get() < 1) {
                globalProgressDialog = globalProgressDialog.show(context,
                        null, "Please wait...", true);
            }

            //increment counter
            globalProgressDialog.progressDialogCounter.getAndIncrement();
        } catch (WindowManager.BadTokenException e) {

        } catch (Exception e) {

        }
    }

    public static void hideProgressLoader() {
        if (globalProgressDialog.progressDialogCounter.get() > 1) {
            globalProgressDialog.progressDialogCounter.decrementAndGet();
        } else {
            if (globalProgressDialog != null) {
                globalProgressDialog.cancel();
                globalProgressDialog.dismiss();
            }
            globalProgressDialog.progressDialogCounter.set(0);
        }
    }
}
