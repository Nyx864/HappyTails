package com.example.happytails.ui.transition;

import android.content.Context;

import androidx.annotation.IdRes;

import java.util.HashMap;
import java.util.Map;

public class FragmentTransactionManager {
    private static final Map<Integer, FragmentTransactionHelper> transactionHelperMap = new HashMap<>();

    public static void add(@IdRes int key, FragmentTransactionHelper value) {
        transactionHelperMap.put(key, value);
    }

    public static boolean contains(FragmentTransactionHelper transactionHelper) {
        return transactionHelperMap.containsValue(transactionHelper);
    }

    public static boolean contains(@IdRes int resId) {
        return transactionHelperMap.containsKey(resId);
    }

    public static FragmentTransactionHelper getTransactionHelper(@IdRes int resId, Context context) {
        FragmentTransactionHelper transactionHelper =
                transactionHelperMap.get(resId);

        if (transactionHelper == null) {
            FragmentTransactionHelper newInstance =
                    new FragmentTransactionHelper(resId, context);
            add(resId, newInstance);
            return newInstance;
        } else {
            return transactionHelper;
        }
    }
}
