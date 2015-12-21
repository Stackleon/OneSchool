package com.example.oneschool.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.oneschool.R;
import com.example.oneschool.baseclass.BaseFragment;
import com.example.oneschool.fragment.AccountFragment;
import com.example.oneschool.fragment.HomeFragment;
import com.example.oneschool.fragment.PersonFragment;
import com.example.oneschool.fragment.SettingFragment;
import com.example.oneschool.fragment.SignInFragment;
import com.example.oneschool.residemenu.ResideMenu;
import com.example.oneschool.residemenu.ResideMenuItem;


public class MainActivity extends FragmentActivity implements View.OnClickListener {

    private ResideMenu resideMenu;
    private MainActivity mContext = this;
    private ResideMenuItem itemHome;
    private ResideMenuItem itemPerson;
    private ResideMenuItem itemAccount;
    private ResideMenuItem itemSignIn;
    private ResideMenuItem itemSetting;

    private Button menuLeft;
    private TextView menuTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpMenu();
        initView();
        initData();
        setListener();
    }
    private void setUpMenu(){
        resideMenu = new ResideMenu(this);
        resideMenu.removeRightView();
        resideMenu.setShowLeftOrRight(resideMenu.SHOW_LEFT_ONLY);
        resideMenu.setUse3D(true);
        resideMenu.setBackground(R.mipmap.menu_bg);
        resideMenu.attachToActivity(this);
        resideMenu.setScaleValue(0.6f);

        itemHome = new ResideMenuItem(this,R.drawable.selector_btn_home,"首页");
        itemPerson = new ResideMenuItem(this,R.drawable.selector_btn_person,"个人信息");
        itemSignIn = new ResideMenuItem(this,R.drawable.selector_btn_signin,"签到");
        itemAccount = new ResideMenuItem(this,R.drawable.selector_btn_account,"账单");
        itemSetting = new ResideMenuItem(this,R.drawable.selector_btn_setting,"设置");

        itemHome.setOnClickListener(this);
        itemPerson.setOnClickListener(this);
        itemAccount.setOnClickListener(this);
        itemSignIn.setOnClickListener(this);
        itemSetting.setOnClickListener(this);

        resideMenu.addMenuItem(itemHome, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemPerson, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemAccount, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemSignIn, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemSetting,ResideMenu.DIRECTION_LEFT);
    }


    protected void initView() {
        menuLeft = (Button) findViewById(R.id.title_bar_left_menu);
        menuTitle = (TextView) findViewById(R.id.main_title);
        menuTitle.setText(homeString);
    }

    private FragmentManager manager;
    private FragmentTransaction transaction;
    private HomeFragment homeFragment = new HomeFragment();
    private PersonFragment personFragment = new PersonFragment();
    private AccountFragment accountFragment = new AccountFragment();
    private SignInFragment signInFragment = new SignInFragment();
    private SettingFragment settingFragment = new SettingFragment();

    protected void initData() {
        manager = getSupportFragmentManager();
        changeFragment(homeFragment);
    }

    protected void setListener() {
        menuLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
            }
        });

    }

    private String homeString="首页";
    private String personString="个人中心";
    private String accountString="账单";
    private String signinString="签到";
    private String settingString="设置";
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return resideMenu.dispatchTouchEvent(ev);
    }
    @Override
    public void onClick(View v) {
        if(v==itemHome){
            changeFragment(homeFragment);
            menuTitle.setText(homeString);
        }else if(v==itemPerson){
            changeFragment(personFragment);
            menuTitle.setText(personString);
        }else if(v==itemAccount){
            changeFragment(accountFragment);
            menuTitle.setText(accountString);
        }else if(v==itemSignIn){
            changeFragment(signInFragment);
            menuTitle.setText(signinString);
        }else if(v==itemSetting){
            changeFragment(settingFragment);
            menuTitle.setText(settingString);
        }
        resideMenu.closeMenu();
    }

    private void changeFragment(BaseFragment targetFragment){
        transaction = manager.beginTransaction();
        transaction.replace(R.id.main_fragment,targetFragment).setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
    public ResideMenu getResideMenu(){
        return resideMenu;
    }

}
