package pers.hanchao.himybatis.utils;

import org.apache.log4j.Logger;
import java.util.List;

/**
 * <p>工具类，打印对象列表（要求对象重写了toString）</p>
 * @author hanchao 2018/1/28 19:18
 **/
public class ShowList {
    private static final Logger LOGGER = Logger.getLogger(ShowList.class);

    /**
     * <p>打印对象列表（要求对象重写了toString）</p>
     * @author hanchao 2018/1/28 19:19
     **/
    public static void showList(List list){
        if (null == list || list.size() == 0){
            LOGGER.info("无记录！");
        }else {
            for (Object obj : list){
                LOGGER.info(obj.toString());
            }
        }
    }
}
