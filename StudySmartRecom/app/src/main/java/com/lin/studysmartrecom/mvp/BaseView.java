package com.lin.studysmartrecom.mvp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public interface BaseView {
    Context getContext();

    Activity getActivity();

    FragmentManager getFragmentMg();

    Bundle getBundle();

    Intent getIntent();
}
