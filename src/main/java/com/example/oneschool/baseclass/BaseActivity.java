package com.example.oneschool.baseclass;

import android.app.Activity;

/**
 * Created by leon on 2015/12/18.
 */
public abstract  class BaseActivity extends Activity {

    protected abstract void initView();

    protected abstract  void initData();

    protected abstract  void setListener();

}
