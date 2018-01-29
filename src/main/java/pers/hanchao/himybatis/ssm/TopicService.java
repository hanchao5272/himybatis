package pers.hanchao.himybatis.ssm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.hanchao.himybatis.curd.ITopicDAO;
import pers.hanchao.himybatis.curd.Topic;

import java.util.List;

/**
 * <p>Service层</p>
 * @author hanchao 2018/1/28 19:20
 **/
@Service
public class TopicService {
    @Autowired
    private ITopicDAO topicDAO;

    public Topic queryTopicById(Integer id) {
        return this.topicDAO.queryTopicById(id);
    }

    @Transactional
    public void insertTopic(Topic topic) {
        this.topicDAO.insertTopic(topic);
    }

    @Transactional
    public void updateTopic(Topic topic) {
        this.topicDAO.updateTopic(topic);
    }

    @Transactional
    public void deleteTopic(Integer id) {
        this.topicDAO.deleteTopic(id);
    }

    @Transactional
    public List<Topic> queryTopicList(){
        return this.topicDAO.queryTopicList();
    }
}
