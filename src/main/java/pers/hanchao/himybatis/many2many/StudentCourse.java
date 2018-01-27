package pers.hanchao.himybatis.many2many;

/**
 * <p>学生选修课中间表</p>
 * @author hanchao 2018/1/27 16:59
 **/
public class StudentCourse {
    private Integer studentId;
    private Integer courseId;

    public StudentCourse() {
    }

    public StudentCourse(Integer studentId, Integer courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "StudentCourse{" +
                "studentId=" + studentId +
                ", courseId=" + courseId +
                '}';
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
}
