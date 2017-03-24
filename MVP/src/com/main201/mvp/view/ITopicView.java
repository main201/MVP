package com.main201.mvp.view;

import java.util.List;

import com.main201.mvp.bean.TopicInfo;

/**
 * 视图控制器
 * @author Main201
 */
public interface ITopicView extends IBaseView{
    /**
     * 处理回调数据（具体业务具体实现）
     */
    public void onTopcList(List<TopicInfo> list);
}
