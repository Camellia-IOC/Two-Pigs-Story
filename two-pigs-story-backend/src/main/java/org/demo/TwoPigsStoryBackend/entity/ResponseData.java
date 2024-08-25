package org.demo.TwoPigsStoryBackend.entity;

import lombok.Data;
import lombok.Setter;

import java.io.Serializable;

@Data
@Setter
public class ResponseData<T> implements Serializable
{
    /**
     * 响应状态码
     */
    private Integer code;
    
    /**
     * 响应信息
     */
    private String message;
    
    /**
     * 响应数据
     */
    private T data;
    
    public static <T> ResponseData<T> success ()
    {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.code = ResponseStatus.SUCCESS.getCode();
        responseData.message = ResponseStatus.SUCCESS.getMsg();
        responseData.data = null;
        return responseData;
    }
    
    public static <T> ResponseData<T> success (T object)
    {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.code = ResponseStatus.SUCCESS.getCode();
        responseData.message = ResponseStatus.SUCCESS.getMsg();
        responseData.data = object;
        return responseData;
    }
    
    public static <T> ResponseData<T> error (ResponseStatus responseStatus)
    {
        ResponseData<T> responseData = new ResponseData<>();
        responseData.code = responseStatus.getCode();
        responseData.message = responseStatus.getMsg();
        responseData.data = null;
        return responseData;
    }
}
