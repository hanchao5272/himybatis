package pers.hanchao.himybatis.page;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import pers.hanchao.himybatis.page.dao.AppleDao;
import pers.hanchao.himybatis.page.entity.AppleEntity;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * <p>分页组件PageHelper实例</p>
 * @author hanchao 2018/2/4 18:23
 **/
public class AppleApp {
    /** 日志 */
    private static final Logger LOGGER = Logger.getLogger(AppleApp.class);
    /** 配置文件读取器 */
    private static Reader reader;
    /** 会话工厂 */
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            reader = Resources.getResourceAsReader("mybatis-config-page.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("读取MyBatis配置文件失败！");
        }
    }
    /**
     * <p>分页组件PageHelper实例</p>
     * @author hanchao 2018/2/4 18:22
     **/
    public static void main(String[] args) {
        SqlSession sqlSession =  sqlSessionFactory.openSession();
        try {
            AppleDao appleDao = sqlSession.getMapper(AppleDao.class);
            LOGGER.info("不加分页的查询：");
            LOGGER.info(appleDao.selectAll());

            System.out.println();
            LOGGER.info("添加分页的查询：");
            LOGGER.info("第1页，共5条");
            PageHelper.startPage(1,5);
            //打印Page<E>本身的信息
            LOGGER.info(appleDao.selectAll());
            //打印Page<E>的元素信息
            LOGGER.info((List<AppleEntity>)appleDao.selectAll());


            System.out.println();
            LOGGER.info("第2页，共5条");
            PageHelper.startPage(2,5);
            //打印Page<E>本身的信息
            LOGGER.info(appleDao.selectAll());
            //打印Page<E>的元素信息
            LOGGER.info((List<AppleEntity>)appleDao.selectAll());


            System.out.println();
            LOGGER.info("第1页，共2条");
            PageHelper.startPage(1,2);
            //打印Page<E>本身的信息
            LOGGER.info(appleDao.selectAll());
            //打印Page<E>的元素信息
            LOGGER.info((List<AppleEntity>)appleDao.selectAll());

            //sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
            e.printStackTrace();
            LOGGER.error("数据库操作失败！");
        }finally {
            sqlSession.close();
        }

    }
}
