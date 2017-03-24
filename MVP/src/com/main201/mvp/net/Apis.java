package com.main201.mvp.net;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

import com.main201.mvp.bean.TopicInfo;

public class Apis {
	//接口 GET方式
	public interface Topics {
	    @GET("/output/channels_topics_timeline.json")
	    Call<List<TopicInfo>> topics(
	    		@Query("id") int id, 
	    		@Query("topic_name") String topic_name,
	    		@Query("count") int count, 
	    		@Query("page") int page, 
	    		@Query("feature") String feature, 
	    		@Query("max_id") int max_id);
	  
	//接口 POST方式
	/*@FormUrlEncoded
	@POST("/output/channels_topics_timeline.json")
	Call<List<TopicInfo>> topics(
			@Field("id") int id, 
			@Field("topic_name") String topic_name,
			@Field("count") int count, 
			@Field("page") int page, 
			@Field("feature") String feature, 
			@Field("max_id") int max_id);
			
			*/
	}
}




