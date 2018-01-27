package pers.hanchao.himybatis.many2many;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Many2manyApp {
    /** SqlSessionFactory用于创建SqlSession */
    private static SqlSessionFactory sqlSessionFactory;
    /** Reader用于读取配置文件 */
    private static Reader reader;
    private static final Logger LOGGER = Logger.getLogger(Many2manyApp.class);

    static {
        try {
            //读取配置文件
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            //创建session工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("加载MyBatis配置文件出错");
        }
    }

    /**
     * <p>多对多实例</p>
     * @author hanchao 2018/1/27 22:19
     **/
    public static void main(String[] args) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //查询学生id=1的所有选修课
            LOGGER.info("=========查询学生id=1的所有选修课");
            IStudentDAO studentDAO = sqlSession.getMapper(IStudentDAO.class);
            Student student = studentDAO.queryStudentById(1);
            LOGGER.info(student.toString());
            showList(student.getCourseList());

            //查询选修课id=1的所有学生
            System.out.println();
            LOGGER.info("=========查询选修课id=1的所有学生");
            ICourseDAO courseDAO = sqlSession.getMapper(ICourseDAO.class);
            Course course = courseDAO.queryCourseById(1);
            LOGGER.info(course.toString());
            showList(course.getStudentList());

            //新增一个学生：陈六
            System.out.println();
            LOGGER.info("=========新增一个学生：陈六");
            student = new Student(4,"陈六","006");
            studentDAO.insertStudent(student);
            LOGGER.info(student.toString());

            //新增一门课程：玄学
            System.out.println();
            LOGGER.info("=========新增一门课程：玄学");
            course = new Course(6,"玄学",3);
            courseDAO.insertCourse(course);
            LOGGER.info(course.toString());

            //新学生 陈六 选修了新选修课 玄学
            System.out.println();
            LOGGER.info("=========新学生 陈六 选修了新选修课 玄学");
            IStudentCourseDAO studentCourseDAO = sqlSession.getMapper(IStudentCourseDAO.class);
            StudentCourse studentCourse = new StudentCourse(4,6);
            studentCourseDAO.insertStudentCourse(studentCourse);
            LOGGER.info(studentCourse.toString());

            //查询陈六选修的课程
            System.out.println();
            LOGGER.info("=========查询陈六选修的课程");
            student = studentDAO.queryStudentById(4);
            LOGGER.info(student.toString());
            showList(student.getCourseList());

            //查询选修玄学的所有学生
            System.out.println();
            LOGGER.info("=========查询选修玄学的所有学生");
            course = courseDAO.queryCourseById(6);
            LOGGER.info(course.toString());
            showList(course.getStudentList());

        }finally {
            //提交
            sqlSession.commit();
            //关闭连接
            sqlSession.close();
        }
    }

    /**
     * <p>打印List</p>
     * @author hanchao 2018/1/27 23:21
     **/
    private static void showList(List list) {
        if (null == list || list.size() == 0){
            LOGGER.info("暂无记录！");
        }else {
            for (int i = 0; i < list.size(); i++) {
                LOGGER.info(list.get(i));
            }
        }

    }
}
