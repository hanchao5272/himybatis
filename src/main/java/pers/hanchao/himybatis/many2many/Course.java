package pers.hanchao.himybatis.many2many;

import java.util.List;

/**
 * <p>选课表</p>
 * @author hanchao 2018/1/27 16:55
 **/
public class Course {
    /** 选课id */
    private Integer id;
    /** 课程名称 */
    private String name;
    /** 学分 */
    private Integer score;
    /** 选择本课程的学生 */
    private List<Student> studentList;

    public Course() {
    }

    public Course(Integer id, String name, Integer score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
