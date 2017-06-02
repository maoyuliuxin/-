package com.lin.studysmartrecom.ui.main.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.lin.studysmartrecom.R;
import com.lin.studysmartrecom.mvp.MVPBaseActivity;

import butterknife.BindView;

public class MainActivity extends MVPBaseActivity<MainContract.View, MainPresenter> implements MainContract.View {

    private static final String TAG = "MainActivity";
    @BindView(R.id.nav_view)
    NavigationView mNavView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        mPresenter.initData();
    }

    private void initView() {
        //设置toolbar
        setSupportActionBar(mToolbar);
        Log.e(TAG, "toolbar=" + mToolbar);
        //设置DrawerLayout
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        mPresenter.initView();
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public NavigationView getNavigation() {
        return mNavView;
    }

    @Override
    public DrawerLayout getDrawer() {
        return mDrawerLayout;
    }
}
