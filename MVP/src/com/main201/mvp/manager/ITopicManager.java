package com.main201.mvp.manager;

import java.util.List;

import com.main201.mvp.bean.TopicInfo;

/**
 * 业务管理接口
 * 
 * @author Main201
 *
 */

public interface ITopicManager {
	//获取文章列表
    public void getTopicList(IOnTopicLoadListener listener);
    
    //回调监听
    public interface IOnTopicLoadListener{
    	public void onCompleted(List<TopicInfo> list);
    }
}
