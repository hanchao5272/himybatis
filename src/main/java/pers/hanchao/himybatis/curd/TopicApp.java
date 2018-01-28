package pers.hanchao.himybatis.curd;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>通过XML+IDAO配置MyBatis，实现单表的增删改查</p>
 * @author hanchao 2018/1/27 0:35
 **/
public class TopicApp {
    /** SqlSessionFactory用于创建SqlS */
    private static SqlSessionFactory sqlSessionFactory;
    /** Reader用于读取配置文件 */
    private static Reader reader;
    private static final Logger LOGGER = Logger.getLogger(TopicApp.class);

    static{
        try{
            //读取MyBatis总配置文件
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            //根据配置文件创建SqlSessionFactory
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("加载MyBatis配置文件出错！");
        }
    }

    /**
     * <p>简单的增删改查</p>
     * @author hanchao 2018/1/27 0:37
     **/
    public static void main(String[] args) {
        //创建数据库会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            //调用IDAO
            ITopicDAO topicDAO = sqlSession.getMapper(ITopicDAO.class);
            //查询所有的话题
            showTopicList(topicDAO.queryTopicList());

             //新增一个话题
            Topic topic = new Topic(1,"題目1",100,"答案1");
            topicDAO.insertTopic(topic);
            LOGGER.info("新增一个话题：" + topic.toString());
            //查询所有的话题
            showTopicList(topicDAO.queryTopicList());

            //修改一個话题
            topic = new Topic(1,"题目1",88,"答案1111");
            topicDAO.updateTopic(topic);
            LOGGER.info("修改一个话题：" + topic.toString());
            //查询所有的话题
            showTopicList(topicDAO.queryTopicList());

            //删除一个话题
            topicDAO.deleteTopic(1);
            LOGGER.info("删除一个话题：id = 1");
            //查询所有的话题
            showTopicList(topicDAO.queryTopicList());

            //新增5个话题
            for (int i = 0; i < 5; i++) {
                int index = 5 + i;
                topic = new Topic(index,"题目" + index,60 + index,"答案" + index);
                topicDAO.insertTopic(topic);
                LOGGER.info("新增一个话题：" + topic.toString());
            }
            //查询所有的话题
            showTopicList(topicDAO.queryTopicList());

            //查询一个题目
            Topic topic1 = topicDAO.queryTopicById(9);
            LOGGER.info("查询一个话题，id = 9，result:" + topic1.toString());
            //事务提交
//            sqlSession.commit();
        }catch (Exception e){
            //事务回滚
            sqlSession.rollback();
        }finally {
            //关闭连接
            sqlSession.close();
        }
    }

    /**
     * <p>打印所有话题</p>
     * @author hanchao 2018/1/27 0:21
     **/
    private static void showTopicList(List<Topic> topicList) {
        LOGGER.info("===================================显示当前所有话题===================================");
        //如果List无值，则打印无信息
        if (null == topicList || topicList.size() == 0){
            LOGGER.info("暂无话题.");
        }else {
            for (Topic topic : topicList){
                LOGGER.info(topic.toString());
            }
        }
        LOGGER.info("====================================================================================\n");
    }
}
