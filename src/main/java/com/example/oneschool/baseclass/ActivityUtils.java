package com.example.oneschool.baseclass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.oneschool.R;


/**
 * Activity跳转工具类
 * 
 * @author gysunc
 * 
 */
public class ActivityUtils {
	public static final int NEXT_PAGE_ANIM = 1;
	public static final int CONFIRM_ANIM = 2;

	public static void startNextActivity(Activity activity, Class<?> cls, boolean isFinish) {
		startNextActivity(activity, cls, null, isFinish);
	}

	public static void startNextActivity(Activity activity, Class<?> cls, Bundle bundle, boolean isFinish) {
		startNextActivity(activity, cls, bundle, isFinish, NEXT_PAGE_ANIM, -1);
	}

	public static void startNextActivity(Activity activity, Class<?> cls, Bundle bundle, boolean isFinish, int animTag, int requestCode) {
		Intent intent = new Intent(activity, cls);
		if (bundle != null)
			intent.putExtras(bundle);
		// 请求码不能为-1,说明有请求吗
		if (requestCode != -1) {
			activity.startActivityForResult(intent, requestCode);
		} else {
			activity.startActivity(intent);
		}
		if (isFinish)
			activity.finish();
		switch (animTag) {
		case NEXT_PAGE_ANIM:
			activity.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
			break;
		case CONFIRM_ANIM: //2
			activity.overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
			break;
		}
	}

	public static void startPreActivity(Activity activity) {
		activity.finish();
		activity.overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
	}

}
