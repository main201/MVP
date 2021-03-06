package com.main201.mvp.view;

public interface IBaseView {
	/**
     * 显示loading框
     */
    public void showProcess(final boolean show);

    /**
     * 显示错误信息
     * @param code        错误码
     * @param devMsg      技术性提示信息
     * @param friendlyMsg 用户提示信息
     */
    public void showErrorInfo(int code ,String devMsg,String friendlyMsg);
}
