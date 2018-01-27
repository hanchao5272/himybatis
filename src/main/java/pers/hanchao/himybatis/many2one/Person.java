package pers.hanchao.himybatis.many2one;

/**
 * <p>人员信息</p>
 * @author hanchao 2018/1/27 16:06
 **/
public class Person {
    /** 人员id */
    private Integer id;
    /** 姓名 */
    private String name;
    /** 年龄 */
    private Integer age;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
