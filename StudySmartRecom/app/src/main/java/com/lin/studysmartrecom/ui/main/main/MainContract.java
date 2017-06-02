package com.lin.studysmartrecom.ui.main.main;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import com.lin.studysmartrecom.mvp.BasePresenter;
import com.lin.studysmartrecom.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class MainContract {
    interface View extends BaseView {
        NavigationView getNavigation();

        DrawerLayout getDrawer();
    }


    interface Presenter extends BasePresenter<View> {
        void initView();
    }
}
