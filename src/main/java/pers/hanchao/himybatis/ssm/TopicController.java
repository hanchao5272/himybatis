package pers.hanchao.himybatis.ssm;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.hanchao.himybatis.curd.entity.Topic;
import pers.hanchao.himybatis.utils.JsonResult;
import pers.hanchao.himybatis.utils.ShowList;

import java.util.List;

/**
 * <p>Spring + Spring MVC + MyBatis初步整合实例（RESTFul风格）</p>
 * @author hanchao 2018/1/28 19:19
 **/
@RestController
@RequestMapping("/ssm")
public class TopicController {
    @Autowired
    private TopicService topicService;

    private static final Logger LOGGER = Logger.getLogger(TopicController.class);
    /**
     * <p>查询一个话题</p>
     * @author hanchao 2018/1/28 16:58
     **/
    @GetMapping("/topic/{id}")
    public JsonResult<Topic> queryTopicById(@PathVariable Integer id){
        Topic topic = this.topicService.queryTopicById(id);

        JsonResult<Topic> jsonResult = new JsonResult<Topic>();
        //非空判断
        if (null != topic){
            jsonResult.addList(topic);
            LOGGER.info(topic.toString());
        }else {
            jsonResult.setMessage("无查询结果");
            LOGGER.info("无查询结果");
        }

        return jsonResult;
    }

    /**
     * <p>查询所有的话题</p>
     * @author hanchao 2018/1/28 18:02
     **/
    @GetMapping("/topic/")
    public JsonResult<Topic> queryTopicList(){
        List<Topic> topicList = this.topicService.queryTopicList();

        JsonResult<Topic> jsonResult = new JsonResult<Topic>();
        //非空判断
        if (null != topicList && topicList.size() > 0){
            jsonResult.setList(topicList);
            ShowList.showList(topicList);
        }else {
            jsonResult.setMessage("无查询结果");
            LOGGER.info("无查询结果");
        }

        return jsonResult;
    }

    /**
     * <p>新增一个话题</p>
     * @author hanchao 2018/1/28 17:35
     **/
    @PostMapping("/topic/")
    public JsonResult<Topic> insertTopic(@RequestBody Topic topic){
        Topic topic1 = this.topicService.queryTopicById(topic.getId());

        //如果已经存在此话题，则不能再新增
        if (null != topic1){
            return new JsonResult<Topic>(-1,"话题已经存在！");
        }else{
            this.topicService.insertTopic(topic);
            return new JsonResult<Topic>();
        }
    }

    /**
     * <p>修改一个话题</p>
     * @author hanchao 2018/1/28 17:50
     **/
    @PutMapping("/topic/")
    public JsonResult<Topic> putTopic(@RequestBody Topic topic){
        Topic topic1 = this.topicService.queryTopicById(topic.getId());

        if (null != topic1){
            this.topicService.updateTopic(topic);
            return new JsonResult<Topic>();
        }else{//如果不存在此话题，则不能进行替换
            return new JsonResult<Topic>(-1,"话题不存在！");
        }
    }

    /**
     * <p>删除一个话题</p>
     * @author hanchao 2018/1/28 17:59
     **/
    @DeleteMapping("/topic/{id}")
    public JsonResult<Topic> deleteTopic(@PathVariable Integer id){
        Topic topic1 = this.topicService.queryTopicById(id);

        if (null != topic1){
            this.topicService.deleteTopic(id);
            return new JsonResult<Topic>();
        }else{//如果不存在此话题，则不能进行删除
            return new JsonResult<Topic>(-1,"话题不存在！");
        }
    }
}
