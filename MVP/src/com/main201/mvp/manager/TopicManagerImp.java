package com.main201.mvp.manager;

import java.util.List;

import javax.security.auth.PrivateCredentialPermission;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import android.util.Log;

import com.main201.mvp.bean.TopicInfo;
import com.main201.mvp.net.Apis.Topics;
import com.main201.mvp.util.Const;


/**
 * 业务管理实现类
 * 
 * @author Main201
 *
 */
public class TopicManagerImp implements ITopicManager {

	@Override
	public void getTopicList(final IOnTopicLoadListener listener) {
		/*
		 热门(ID:1)搞笑(ID:13)明星名人(ID:16)男神(ID:31)女神(ID:19)音乐(ID:62)
		舞蹈(ID:63)美食(ID:59)美妆(ID:27)宝宝(ID:18)萌宠(ID:6)手工(ID:450)
		穿秀(ID:460)吃秀(ID:423)
		*/
		int[] typeIdList = new int[]{1,13,16,31,19,27};
		
		Retrofit retrofit = new Retrofit.Builder().baseUrl(Const.API_URL)
				.addConverterFactory(GsonConverterFactory.create()).build();

		// 创建Api接口实例
		Topics github = retrofit.create(Topics.class);
		int id = typeIdList[(int)Math.round(Math.random()*(typeIdList.length-1))];

		// 创建请求
		Call<List<TopicInfo>> call = github.topics(id, "", 20, 1, "new", 1);

		// 加入请求队列
		call.enqueue(new Callback<List<TopicInfo>>() {

			@Override
			public void onResponse(Call<List<TopicInfo>> arg0,
					Response<List<TopicInfo>> arg1) {
				if(arg1!=null){
					listener.onCompleted(arg1.body());
					
					System.out.println(arg0.request().headers()+":"+arg1.body());
					
				}
			}

			@Override
			public void onFailure(Call<List<TopicInfo>> arg0, Throwable arg1) {
				System.out.println(":"+arg1.getMessage());
			}
		});
		
	}
    
}
