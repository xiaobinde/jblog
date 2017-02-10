package com.blog.admin.controller;

import com.blog.admin.render.AjaxResult;

/**
 * Created by liuhb on 2017/1/12.
 */
public class AdminBaseController {

    /**
     * 成功返回消息
     * @param message
     */
    public AjaxResult renderAjaxResultForSuccess(String message) {
        return renderAjaxResult(message, 0, null);
    }

    /**
     * 成功返回消息和内容
     * @param message
     * @param data
     */
    public AjaxResult renderAjaxResultForSuccess(String message, Object data) {
        return renderAjaxResult(message, 0, data);
    }

    /**
     * 错误返回消息
     * @param message
     */
    public AjaxResult renderAjaxResultForError(String message) {
        return renderAjaxResult(message, 1, null);
    }

    private AjaxResult renderAjaxResult(String message, int errorCode, Object data) {
        AjaxResult ar = new AjaxResult();
        ar.setMessage(message);
        ar.setErrorCode(errorCode);
        ar.setData(data);
        return ar;
    }
}
