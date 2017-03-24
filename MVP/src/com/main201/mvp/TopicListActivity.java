package com.main201.mvp;

import java.util.List;
import com.main201.mvp.adapter.TopicAdapter;
import com.main201.mvp.bean.TopicInfo;
import com.main201.mvp.presenter.TopicpPresenter;
import com.main201.mvp.view.ITopicView;
import com.yalantis.phoenix.PullToRefreshView;
import android.os.Bundle;
import android.widget.ListView;

public class TopicListActivity extends BaseActivity<ITopicView, TopicpPresenter> implements ITopicView {
	private PullToRefreshView pullView;
	private ListView listView;
	private TopicAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_topic_list);
		
		pullView = (PullToRefreshView)findViewById(R.id.pull_to_refresh);
		listView = (ListView)findViewById(R.id.list_view);
		
		adapter = new TopicAdapter(getApplicationContext());
		listView.setAdapter(adapter);
		pullView.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
            	presenter.getTopicList();
            }
        });
		
		
		presenter.getTopicList();
	}
	
	@Override
	public TopicpPresenter setPresenter() {
		return new TopicpPresenter();
	}

	@Override
	public void showProcess(boolean show) {
		
	}

	@Override
	public void showErrorInfo(int code, String devMsg, String friendlyMsg) {
	
	}

	
	@Override
	public void onTopcList(List<TopicInfo> list) {
		adapter.setData(list);
		pullView.setRefreshing(false);
	}

}
