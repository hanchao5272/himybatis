package pers.hanchao.himybatis.ihello;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.Reader;

/**
 * <p>简单的MyBatis实例：引入了Dao接口概念</p>
 * @author hanchao 2018/1/26 23:38
 **/
public class IHello {
    /** SqlSessionFactory用于创建SqlSession */
    private static SqlSessionFactory sqlSessionFactory;
    /** Reader用于读取配置文件 */
    private static Reader reader;

    private static final Logger LOGGER = Logger.getLogger(IHello.class);

    static{
        try{
            //读取MyBatis总配置文件
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("找不到MyBatis配置文件！");
        }
    }

    /**
     * <p>读取id=99999的试题信息</p>
     * @author hanchao 2018/1/26 23:42
     **/
    public static void main(String[] args) {
        //创建SqlSession用于数据库会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            //通过SqlSession.getMapper直接调用IProblemDao接口
            IProblemDao iProblemDao = sqlSession.getMapper(IProblemDao.class);
            //通过IProblemDao的定义与IProblem.xml配置的对应关系，找到SQL语句进行执行
            Problem problem = iProblemDao.getProblemById(99999);
            if (null != problem){
                LOGGER.info(problem.toString());
            }
        }finally {
            sqlSession.close();
        }

    }
}
