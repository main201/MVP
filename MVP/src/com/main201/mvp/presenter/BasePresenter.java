package com.main201.mvp.presenter;

import java.lang.ref.WeakReference;

public class BasePresenter<T> {
	//弱引用存储View控制器对象，解决内存泄漏
	WeakReference<T> mViewRef;
	
	//设置View控制器
	public void attachView(T view){
		mViewRef = new WeakReference<T>(view);
	}
	
	//清除View控制器
	public void detachView(){
		if(mViewRef!=null){
			mViewRef.clear();
		}
	}
}
