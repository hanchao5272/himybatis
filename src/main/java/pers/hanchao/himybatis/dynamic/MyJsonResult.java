package pers.hanchao.himybatis.dynamic;

import java.util.List;

/**
 * <p>Json返回值</p>
 * @author hanchao 2018/1/31 22:44
 **/
public class MyJsonResult<E> {
    /** 状态码 */
    private Integer code = 1;
    /** 消息 */
    private String message = "success!";
    /** 数据 */
    private List<E> data;

    public void setCodeAndMessage(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public MyJsonResult(Integer code, String message, List<E> data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public MyJsonResult() {
    }

    public MyJsonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "MyJsonResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }
}
