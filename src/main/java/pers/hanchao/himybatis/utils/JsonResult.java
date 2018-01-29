package pers.hanchao.himybatis.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>JSON返回值的泛型定义</p>
 * @author hanchao 2018/1/28 19:17
 **/
public class JsonResult<T> {
    private Integer code = 1;
    private String message = "success!";
    private List<T> list = new ArrayList<T>();

    public JsonResult() {
    }

    public JsonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public void setCodeAndMessage(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    /**
     * <p>设置默认的失败状态</p>
     * @author hanchao 2018/1/28 19:17
     **/
    public void toFail(){
        setCodeAndMessage(-1,"failed!");
    }


    /**
     * <p>返回一个对象</p>
     * @author hanchao 2018/1/28 19:18
     **/
    public void addList(T object) {
        this.list.add(object);
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", list=" + list +
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

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
