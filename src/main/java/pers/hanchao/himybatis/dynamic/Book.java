package pers.hanchao.himybatis.dynamic;

/**
 * <p>书籍</p>
 * @author hanchao 2018/1/30 22:46
 **/
public class Book {
    /** 书籍id */
    private Integer id;
    /** 书籍名称 */
    private String name;
    /** 书籍编号 */
    private String number;
    /** 价钱 */
    private Float price;
    /** 是否二手书 */
    private Boolean old;
    /** 是否汉化书 */
    private Boolean chinese;

    public Book() {
    }

    public Book(Integer id, String name, String number, Float price, Boolean old, Boolean chinese) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.price = price;
        this.old = old;
        this.chinese = chinese;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", price=" + price +
                ", old=" + old +
                ", chinese=" + chinese +
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Boolean getOld() {
        return old;
    }

    public void setOld(Boolean old) {
        this.old = old;
    }

    public Boolean getChinese() {
        return chinese;
    }

    public void setChinese(Boolean chinese) {
        this.chinese = chinese;
    }
}
