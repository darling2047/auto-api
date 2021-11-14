package com.darling.auto.constant;


import java.util.List;

/**
 * @Author dll
 * @create 2020/5/31 11:16
 * @describe
 */
public class ResponResult {

    /**
     * 状态(0成功1错误2未登陆3刷新4重复提交)
     */
    private Integer status;

    /**
     * 错误信息
     */
    private String msg;

    /**
     * 数据对象
     */
    private Object obj;

    /**
     * 表格数据对象
     */
    private List data;

    /**
     * 表格响应状态码 0:成功
     */
    private Integer code;

    /**
     * 表格记录数
     */
    private Integer count;

    public ResponResult() {
    }

    public static boolean isSuccess(ResponResult ResponResult) {
        return AJAX_STATUS.success.equals(ResponResult.getStatus());
    }

    public static ResponResult markSuccess() {
        ResponResult mrv = new ResponResult();
        mrv.setStatus(AJAX_STATUS.success);
        return mrv;
    }

    public static ResponResult markSuccess(Object obj) {
        ResponResult mrv = new ResponResult();
        mrv.setStatus(AJAX_STATUS.success);
        mrv.setObj(obj);
        return mrv;
    }

    public static ResponResult markTableSuccess(List obj) {
        ResponResult mrv = new ResponResult();
        mrv.setData(obj);
        mrv.setCode(AJAX_STATUS.success);
        mrv.setCount(obj.size());
        return mrv;
    }

    public static ResponResult markSuccess(Object obj, String msg) {
        ResponResult mrv = new ResponResult();
        mrv.setStatus(AJAX_STATUS.success);
        mrv.setObj(obj);
        mrv.setMsg(msg);
        return mrv;
    }

    public static ResponResult markError(String msg) {
        ResponResult mrv = new ResponResult();
        mrv.setStatus(AJAX_STATUS.error);
        mrv.setMsg(msg);
        return mrv;
    }

    public static ResponResult markNoLogin() {
        ResponResult mrv = new ResponResult();
        mrv.setStatus(AJAX_STATUS.nologin);
        return mrv;
    }

    public static ResponResult markRefresh() {
        ResponResult mrv = new ResponResult();
        mrv.setStatus(AJAX_STATUS.refresh);
        return mrv;
    }

    public static ResponResult markRepeat(String msg) {
        ResponResult mrv = new ResponResult();
        mrv.setStatus(AJAX_STATUS.repeat);
        mrv.setMsg(msg);
        return mrv;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return this.obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public interface AJAX_STATUS {
        Integer success = 0;
        Integer error = 1;
        Integer nologin = 2;
        Integer refresh = 3;
        Integer repeat = 4;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
