package com.kentrasoft.cms.basic.resolver;

/**
 * 描述：自定义异常
 * @author zhangmengakang
 * @date 2018-6-14 15:08:27
 */
public class ParamException extends RuntimeException {
    /**
     * @Fields serialVersionUID : TODO(Describe what this variable represents in a single sentence)
     */
    private static final long serialVersionUID = 1L;

    public ParamException(String msg)
    {
        super(msg);
    }
}