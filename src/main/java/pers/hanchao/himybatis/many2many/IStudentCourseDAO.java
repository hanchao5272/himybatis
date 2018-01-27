package pers.hanchao.himybatis.many2many;

/**
 * <p>学生选课DAO</p>
 * @author hanchao 2018/1/27 17:08
 **/
public interface IStudentCourseDAO {
    /** 插入一条学生选课信息 */
    void insertStudentCourse(StudentCourse studentCourse);
    /**  */
    Student queryStudentByCourseId(Integer id);
    /**  */
    Course queryCourseByStudentId(Integer id);
}
