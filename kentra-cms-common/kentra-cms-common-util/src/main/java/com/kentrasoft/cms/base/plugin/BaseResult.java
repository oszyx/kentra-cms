package com.kentrasoft.cms.base.plugin;

/**
 * 描述：结果集
 *
 * @author zhangmengkang
 * @Date 2018-5-31 21:04:50
 */
public class BaseResult<E> {
    //返回数据
    private E result = null;
    //操作结果状态
    private String statusCode = "200";
    //操作结果描述
    private String message;

    public BaseResult() {
    }

    public BaseResult(String code, String message) {
        this.statusCode = code;
        this.message = message;
    }

    public BaseResult(String code, String message, E result) {
        this.statusCode = code;
        this.message = message;
        this.result = result;
    }

    /**
     * 描述：执行成功
     *
     * @param message
     * @return
     */
    public static BaseResult success(String message) {
        return new BaseResult("200", message);
    }

    /**
     * 描述：执行成功并返回结果集
     *
     * @param message
     * @param result
     * @return
     */
    public static BaseResult success(String message, Object result) {
        return new BaseResult("200", message, result);
    }

    /**
     * 描述：执行失败
     *
     * @param message
     * @return
     */
    public static BaseResult faild(String message) {
        return new BaseResult("300", message);
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public E getResult() {
        return result;
    }

    public void setResult(E result) {
        this.result = result;
    }
}
