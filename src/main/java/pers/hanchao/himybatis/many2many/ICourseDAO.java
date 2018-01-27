package pers.hanchao.himybatis.many2many;

/**
 * <p>选修课DAO</p>
 * @author hanchao 2018/1/27 17:03
 **/
public interface ICourseDAO {
    /** 新增一门课程 */
    void insertCourse(Course course);
    /** 根据id查询一门课程 */
    Course queryCourseById(Integer id);
}
