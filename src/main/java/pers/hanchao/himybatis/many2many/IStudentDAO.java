package pers.hanchao.himybatis.many2many;

/**
 * <p>学生DAO</p>
 * @author hanchao 2018/1/27 17:06
 **/
public interface IStudentDAO {
    /** 新增一个学生 */
    void insertStudent(Student student);
    /** 根据id查询一个学生的信息 */
    Student queryStudentById(Integer id);
}
