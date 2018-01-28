package pers.hanchao.himybatis.many2one;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.Reader;

/**
 * <p>MyBatis的多对一实例</p>
 * @author hanchao 2018/1/27 16:02
 **/
public class ExperienceApp {
    /** SqlSessionFactory，用来创建数据库连接sesson */
    private static SqlSessionFactory sqlSessionFactory;
    /** Reader 读取配置文件 */
    private static Reader reader;
    private static final Logger LOGGER = Logger.getLogger(ExperienceApp.class);

    static {
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("加载MyBatis配置文件出错！");
        }
    }
    public static void main(String[] args) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            IExperienceDAO experienceDAO = sqlSession.getMapper(IExperienceDAO.class);
            //查询
            Experience experience = experienceDAO.queryExperienceById(2);
            LOGGER.info(experience.toString());
            LOGGER.info(experience.getPerson().toString());
            //事务提交
            sqlSession.commit();
        }catch (Exception e){
            //事务回滚
            sqlSession.rollback();
        }finally {
            //关闭连接
            sqlSession.close();
        }
    }


}
