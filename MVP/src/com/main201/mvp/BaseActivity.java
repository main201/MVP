package com.main201.mvp;

import com.main201.mvp.presenter.BasePresenter;

import android.app.Activity;
import android.os.Bundle;
/**
 * 基类，主要以泛型的方式实现Presenter的实例化及View的绑定
 * 
 * @author Main201
 *
 * @param <V> View控制器
 * @param <T> Presenter
 */
public abstract class BaseActivity<V,T extends BasePresenter<V>> extends Activity {
	//Presenter
	public T presenter;

	//让具体的子类Activity去设置对应的Presenter
	public abstract T setPresenter();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		presenter = setPresenter();
		presenter.attachView((V)this);
		
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		presenter.detachView();
	}
	
	
	
	
}
