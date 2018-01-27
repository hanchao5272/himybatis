package pers.hanchao.himybatis.many2many;

import java.util.List;

/**
 * <p>学生信息表</p>
 * @author hanchao 2018/1/27 16:54
 **/
public class Student {
    /** 学生id */
    private Integer id;
    /** 姓名 */
    private String name;
    /** 学号 */
    private String number;
    /** 所有选修课 */
    private List<Course> courseList;

    public Student() {
    }

    public Student(Integer id, String name, String number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
