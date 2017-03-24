package com.main201.mvp.adapter;

import java.util.List;

import retrofit2.http.POST;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.main201.mvp.R;
import com.main201.mvp.bean.TopicInfo;
import com.main201.mvp.util.ImageLoadUtil;

public class TopicAdapter extends BaseAdapter {
	private Context context;
    private LayoutInflater mInflater;
    private List<TopicInfo> mData;

    public TopicAdapter(Context context) {
    	this.context = context.getApplicationContext();
        mInflater = LayoutInflater.from(context);
    }
    
    public void setData(List<TopicInfo> data){
    	if(data!=null){
    		if(mData!=null && mData.size()>0){
        		mData.clear();
        		mData = null;
        	}
        	mData = data;
        	notifyDataSetChanged();
    	}
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.list_item, parent, false);
            viewHolder.imageViewIcon = (ImageView) convertView.findViewById(R.id.image_view_icon);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        
        ImageLoadUtil.show(context, getItem(position).cover_pic, viewHolder.imageViewIcon);
        //viewHolder.imageViewIcon.setImageResource(mData.get(position).get(KEY_ICON));
        //convertView.setBackgroundResource(mData.get(position).get(KEY_COLOR));

        return convertView;
    }

    class ViewHolder {
        ImageView imageViewIcon;
    }

	@Override
	public int getCount() {
		if(mData!=null){
			return mData.size();
		}else{
			return 0;
		}
		
	}

	@Override
	public TopicInfo getItem(int arg0) {
		// TODO Auto-generated method stub
		return mData.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}


