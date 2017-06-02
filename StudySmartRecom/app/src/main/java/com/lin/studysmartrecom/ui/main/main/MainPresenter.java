package com.lin.studysmartrecom.ui.main.main;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lin.studysmartrecom.R;
import com.lin.studysmartrecom.mvp.BasePresenterImpl;
import com.lin.studysmartrecom.utils.GlideCircleTransform;
import com.lin.studysmartrecom.utils.StatusBarSetting;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class MainPresenter extends BasePresenterImpl<MainContract.View> implements MainContract.Presenter, NavigationView.OnNavigationItemSelectedListener {

    @Override
    public void initData() {
    }

    @Override
    public void initView() {
        StatusBarSetting.setColorForDrawerLayout(mView.getActivity(), mView.getDrawer(),
                mView.getContext().getResources().getColor(R.color.colorPrimary),
                StatusBarSetting.DEFAULT_STATUS_BAR_ALPHA);

        NavigationView navigation = mView.getNavigation();
        navigation.setNavigationItemSelectedListener(this);
        //注意需要使用getHeaderView
        View headerView = navigation.getHeaderView(0);
        ImageView ivHeadIcon = (ImageView) headerView.findViewById(R.id.iv_head_icon);
        TextView tvHint = (TextView) headerView.findViewById(R.id.tv_hint);
        Glide.with(mView.getContext())
                .load(R.drawable.nav_photo)
                .transform(new GlideCircleTransform(mView.getContext()))
                .into(ivHeadIcon);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        if (id == R.id.nav_home) {

        } else if (id == R.id.nav_guess_like) {

        } else if (id == R.id.nav_message) {

        } else if (id == R.id.nav_music) {

        } else if (id == R.id.nav_movie) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        mView.getDrawer().closeDrawer(GravityCompat.START);
        return true;
    }

}
