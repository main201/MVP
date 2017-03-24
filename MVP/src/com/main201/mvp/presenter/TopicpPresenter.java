package com.main201.mvp.presenter;

import java.util.List;

import com.main201.mvp.bean.TopicInfo;
import com.main201.mvp.manager.ITopicManager;
import com.main201.mvp.manager.ITopicManager.IOnTopicLoadListener;
import com.main201.mvp.manager.TopicManagerImp;
import com.main201.mvp.view.ITopicView;

public class TopicpPresenter extends BasePresenter<ITopicView> {
	//业务管理
	private ITopicManager manager = new TopicManagerImp();
	
	//加载数据
	public void getTopicList(){
		manager.getTopicList(new IOnTopicLoadListener() {
			
			@Override
			public void onCompleted(List<TopicInfo> list) {
				if(mViewRef!=null && mViewRef.get()!=null){
					//通过视图控制器回调给视图（Activity）
					mViewRef.get().onTopcList(list);
				}
			}
		});
	}
}
