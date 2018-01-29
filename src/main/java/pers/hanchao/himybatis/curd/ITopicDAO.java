package pers.hanchao.himybatis.curd;

import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * <p>Topic的DAO层接口</p>
 * @author hanchao 2018/1/27 0:01
 **/
@Repository
public interface ITopicDAO {
    /** 新增一个题目 */
    void insertTopic(Topic topic);
    /** 修改一个题目 */
    void updateTopic(Topic topic);
    /** 删除一个题目 */
    void deleteTopic(Integer id);
    /** 查询一个题目 */
    Topic queryTopicById(Integer id);
    /** 查询所有题目 */
    List<Topic> queryTopicList();
}
