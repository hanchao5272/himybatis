package pers.hanchao.himybatis.page.entity;

public class AppleEntity {
    /**
     * <pre>
     * 苹果种类id
     * 表字段 : apple.id
     * </pre>
     */
    private Integer id;

    /**
     * <pre>
     * 苹果种类名称
     * 表字段 : apple.name
     * </pre>
     */
    private String name;

    /**
     * <pre>
     * 价格
     * 表字段 : apple.price
     * </pre>
     */
    private Integer price;

    /**
     * <pre>
     * 获取：苹果种类id
     * 表字段：apple.id
     * </pre>
     *
     * @return apple.id：苹果种类id
     */
    public Integer getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：苹果种类id
     * 表字段：apple.id
     * </pre>
     *
     * @param id
     *            apple.id：苹果种类id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：苹果种类名称
     * 表字段：apple.name
     * </pre>
     *
     * @return apple.name：苹果种类名称
     */
    public String getName() {
        return name;
    }

    /**
     * <pre>
     * 设置：苹果种类名称
     * 表字段：apple.name
     * </pre>
     *
     * @param name
     *            apple.name：苹果种类名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * <pre>
     * 获取：价格
     * 表字段：apple.price
     * </pre>
     *
     * @return apple.price：价格
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * <pre>
     * 设置：价格
     * 表字段：apple.price
     * </pre>
     *
     * @param price
     *            apple.price：价格
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     *
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", price=").append(price);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @param that
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AppleEntity other = (AppleEntity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()));
    }

    /**
     *
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        return result;
    }
}