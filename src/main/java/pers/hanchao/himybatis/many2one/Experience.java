package pers.hanchao.himybatis.many2one;
/**
 * <p>工作经验</p>
 * @author hanchao 2018/1/27 16:07
 **/
public class Experience {
    /** 工作经验id */
    private Integer id;
    /** 公司名称 */
    private String company;
    /** 职位 */
    private String position;
    /** 所属人员 */
    private Person person;

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
