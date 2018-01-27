package pers.hanchao.himybatis.one2many;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * <p>MyBatis的简单一对多实例</p>
 * @author hanchao 2018/1/27 15:26
 **/
public class PersonApp {
    /** SqlSessionFactory用于创建SqlSession */
    private static SqlSessionFactory sqlSessionFactory;
    /** Reader用于读取配置文件 */
    private static Reader reader;
    private static final Logger LOGGER = Logger.getLogger(PersonApp.class);

    static {
        try {
            //通过Reader加载MyBatis总配置文件
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            //通过配置文件创建SqlSessionFactory
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("MyBatis配置文件加载失败！");
        }
    }

    /**
     * <p>MyBatis一对多实例</p>
     * @author hanchao 2018/1/27 15:49
     **/
    public static void main(String[] args) {
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //获取DAO层对象
            IPersonDAO personDAO = (IPersonDAO) sqlSession.getMapper(IPersonDAO.class);
            //查询存在一对多关系的数据
            Person person = personDAO.queryPersonById(1);
            LOGGER.info(person.toString());
            showExperience(person.getExperienceList());

            //查询不存在一对多关系的数据
            System.out.println();
            Person person1 = personDAO.queryPersonById(2);
            LOGGER.info(person1.toString());
            showExperience(person1.getExperienceList());
        }finally {
            sqlSession.close();
        }
    }

    /**
     * <p>打印List</p>
     * @author hanchao 2018/1/27 15:50
     **/
    private static void showExperience(List<Experience> experienceList) {
        if (null == experienceList || experienceList.size() == 0){
            LOGGER.info("此人无工作经验");
        }else {
            for (Experience experience : experienceList){
                LOGGER.info(experience.toString());
            }
        }

    }
}
