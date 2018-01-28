package pers.hanchao.himybatis.hello;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.Reader;

/**
 * <p>简单的MyBaits实例：不依赖Spring和Spring MVC</p>
 * @author hanchao 2018/1/26 19:02
 **/
public class Hello {

    /** MyBatis通过SqlSessionFactory创建SqlSession进而进行数据库操作 */
    private static SqlSessionFactory sqlSessionFactory;
    /** 读取并加载MyBatis的配置文件 */
    private static Reader reader;
    private static final Logger LOGGER = Logger.getLogger(Hello.class);

    static {
        try{
            //读取MyBatis的配置文件，总配置文件通过mappers属性依次读取分配置文件
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            //创建SqlSessionFactory
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch (Exception e){
            e.printStackTrace();
            LOGGER.error("找不到MyBatis的配置文件！");
        }
    }

    /**
     * <p>读取id=99999的试题信息</p>
     * @author hanchao 2018/1/26 19:09
     **/
    public static void main(String[] args) {
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            //执行查询方法：通过Question.xml找到SQL语句
            Question question = sqlSession.selectOne("pers.hanchao.himybatis.hello.QuestionMapper.GetQuestionById",99999);
            if (null != question){
                //输出结果
                LOGGER.info(question.toString());
            }
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
