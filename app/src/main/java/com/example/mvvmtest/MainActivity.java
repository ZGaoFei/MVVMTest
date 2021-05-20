package com.example.mvvmtest;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.baselibrary.base.BaseActivity;
import com.example.mvvmtest.chapters.ChaptersFragment;
import com.example.mvvmtest.home.HomeFragment;
import com.example.mvvmtest.my.MyFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private ViewPager2 viewPager;
    private BottomNavigationView navigationView;

    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();

        initViewPager();
        initNavigation();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    private void initView() {
        viewPager = findViewById(R.id.view_pager);
        navigationView = findViewById(R.id.bottom_navigation);
    }

    private void initViewPager() {
        List<Fragment> list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new ChaptersFragment());
        list.add(new MyFragment());
        HomeFragmentAdapter adapter = new HomeFragmentAdapter(this, list);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        viewPager.setAdapter(adapter);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                navigationView.getMenu().getItem(currentIndex).setChecked(false);
                currentIndex = position;
                navigationView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    private void initNavigation() {
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.menu_chapters:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.menu_my:
                        viewPager.setCurrentItem(2);
                        break;
                }
                return false;
            }
        });
    }
}