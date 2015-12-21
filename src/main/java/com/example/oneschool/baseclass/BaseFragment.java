package com.example.oneschool.baseclass;

import android.support.v4.app.Fragment;

/**
 * Created by leon on 2015/12/20.
 */
public abstract class BaseFragment extends Fragment {
    protected  abstract  void initView();
    protected  abstract  void initData();
    protected  abstract  void setListener();
}
