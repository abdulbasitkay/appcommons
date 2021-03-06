package com.bentech.android.appcommons.utils;

import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bentech.android.appcommons.AppCommons;
import com.bentech.android.appcommons.config.AppCommonsConfiguration;

/**
 * Created by Daniel on 8/12/2015.
 */
public final class SpinnerUtils {

    public static boolean isEmpty(Spinner spinner) {

        boolean isEmpty = spinner == null || spinner.getSelectedItemPosition() == 0 ||
                spinner.getSelectedItemPosition() == AdapterView.INVALID_POSITION || spinner.getVisibility() != View.VISIBLE;
        AppCommonsConfiguration appCommonsConfiguration = AppCommons.getAppCommonsConfiguration();
        if (isEmpty) {

            if (spinner.getVisibility() != View.VISIBLE) {
                return false;
            }
            ((TextView) spinner.getChildAt(0)).setTextColor(appCommonsConfiguration.getSpinnerLabelErrorColor());

        } else {
            ((TextView) spinner.getChildAt(0)).setTextColor(appCommonsConfiguration.getSpinnerLabelValidColor());
        }

        return isEmpty;
    }

    public static boolean isEmpty(Spinner... spinners) {
        boolean isEmpty = false;
        for (Spinner spinner : spinners) {
            if (isEmpty(spinner)) {
                isEmpty = true;
            }
        }

        return isEmpty;
    }

    public static String getSelectedString(Spinner spinner) {
        return String.valueOf(getSelectedObject(spinner));
    }

    public static Object getSelectedObject(Spinner spinner) {
        return spinner.getSelectedItem();
    }


}
