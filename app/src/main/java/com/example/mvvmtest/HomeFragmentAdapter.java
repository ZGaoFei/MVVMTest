package com.example.mvvmtest;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class HomeFragmentAdapter extends FragmentStateAdapter {

    private List<Fragment> listFragment;

    public HomeFragmentAdapter(@NonNull FragmentActivity fragmentActivity, List<Fragment> fragments) {
        super(fragmentActivity);
        this.listFragment = fragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return listFragment == null ? null : listFragment.get(position);
    }

    @Override
    public int getItemCount() {
        return listFragment == null ? 0 : listFragment.size();
    }
}
