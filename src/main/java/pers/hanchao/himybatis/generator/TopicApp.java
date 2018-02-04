package pers.hanchao.himybatis.generator;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import pers.hanchao.himybatis.generator.dao.TopicDao;
import pers.hanchao.himybatis.generator.entity.TopicEntity;

import java.io.IOException;
import java.io.Reader;

/**
 * <p>测试MyBatis Generator生成的代码是否可用</p>
 * @author hanchao 2018/2/4 10:45
 **/
public class TopicApp {
    /** 日志 */
    private static final Logger LOGGER = Logger.getLogger(TopicApp.class);

    /** 配置文件读取类 */
    private static Reader reader;

    /** 会话工厂 */
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            //读取配置文件
            reader = Resources.getResourceAsReader("mybatis-config-generator.xml");
            //构建会话工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * <p>对MyBatis Generator生成的数据库方法进行测试</p>
     * @author hanchao 2018/2/4 10:46
     **/
    public static void main(String[] args) {
        //创建会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //获取Dao层实例
            TopicDao topicDao = sqlSession.getMapper(TopicDao.class);
            //查询所有
            LOGGER.info("查询所有");
            LOGGER.info(topicDao.selectAll());
            //插入一个，查询所有
            System.out.println();
            LOGGER.info("插入一个");
            TopicEntity newTopic = new TopicEntity();
            newTopic.setId(100);
            newTopic.setTitle("新增的标题");
            newTopic.setScore(200);
            newTopic.setAnswer("新增的答案");
            topicDao.insert(newTopic);
            LOGGER.info(topicDao.selectAll());
            //查询一个
            System.out.println();
            LOGGER.info("查询一个");
            LOGGER.info(topicDao.selectByPrimaryKey(1));
            //修改一个，然后查询
            System.out.println();
            LOGGER.info("修改一个");
            newTopic = new TopicEntity();
            newTopic.setId(1);
            newTopic.setTitle("修改的标题");
            newTopic.setScore(1000);
            newTopic.setAnswer("修改的答案");
            topicDao.updateByPrimaryKey(newTopic);
            LOGGER.info(topicDao.selectByPrimaryKey(1));
            //删除一个，然后查询
            System.out.println();
            LOGGER.info("删除一个，然后查询");
            topicDao.deleteByPrimaryKey(1);
            LOGGER.info(topicDao.selectByPrimaryKey(1));

            //提交
//            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            LOGGER.info("error!");
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
    }
}
