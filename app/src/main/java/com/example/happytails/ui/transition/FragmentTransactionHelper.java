package com.example.happytails.ui.transition;

import android.content.Context;

import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import lombok.Getter;

public class FragmentTransactionHelper {

    private final Integer resId;
    private final FragmentManager fragmentManager;
    @Getter private Fragment currentFragment;

    public FragmentTransactionHelper(@IdRes int id, Context context) {
        fragmentManager = ((AppCompatActivity)context)
                .getSupportFragmentManager();
        resId = id;
    }

    public void open(Fragment fragment) {
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();

        if (currentFragment != null) {
            fragmentTransaction.hide(currentFragment);
        }

        currentFragment = fragment;
        if (fragment.isAdded()) {
            fragmentTransaction.show(fragment);
        } else {
            fragmentTransaction.add(resId, fragment);
        }
        fragmentTransaction.commit();
    }

    public void setCustomAnimation(@AnimatorRes @AnimRes int enter,
                                   @AnimatorRes @AnimRes int exit) {
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(enter, exit);
        fragmentTransaction.commit();
    }

    public void popup() {
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.remove(currentFragment);
        fragmentTransaction.commit();
    }

    public void runOnCommit(Runnable runnable) {
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.runOnCommit(runnable);
        fragmentTransaction.commit();
    }
}
