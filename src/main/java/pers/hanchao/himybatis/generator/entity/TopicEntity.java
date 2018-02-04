package pers.hanchao.himybatis.generator.entity;

public class TopicEntity {
    /**
     * <pre>
     * 话题
     * 表字段 : topic.id
     * </pre>
     */
    private Integer id;

    /**
     * <pre>
     * 题目
     * 表字段 : topic.title
     * </pre>
     */
    private String title;

    /**
     * <pre>
     * 分数
     * 表字段 : topic.score
     * </pre>
     */
    private Integer score;

    /**
     * <pre>
     * 答案
     * 表字段 : topic.answer
     * </pre>
     */
    private String answer;

    /**
     * <pre>
     * 获取：话题
     * 表字段：topic.id
     * </pre>
     *
     * @return topic.id：话题
     */
    public Integer getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：话题
     * 表字段：topic.id
     * </pre>
     *
     * @param id
     *            topic.id：话题
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * <pre>
     * 获取：题目
     * 表字段：topic.title
     * </pre>
     *
     * @return topic.title：题目
     */
    public String getTitle() {
        return title;
    }

    /**
     * <pre>
     * 设置：题目
     * 表字段：topic.title
     * </pre>
     *
     * @param title
     *            topic.title：题目
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * <pre>
     * 获取：分数
     * 表字段：topic.score
     * </pre>
     *
     * @return topic.score：分数
     */
    public Integer getScore() {
        return score;
    }

    /**
     * <pre>
     * 设置：分数
     * 表字段：topic.score
     * </pre>
     *
     * @param score
     *            topic.score：分数
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * <pre>
     * 获取：答案
     * 表字段：topic.answer
     * </pre>
     *
     * @return topic.answer：答案
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * <pre>
     * 设置：答案
     * 表字段：topic.answer
     * </pre>
     *
     * @param answer
     *            topic.answer：答案
     */
    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
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
        sb.append(", title=").append(title);
        sb.append(", score=").append(score);
        sb.append(", answer=").append(answer);
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
        TopicEntity other = (TopicEntity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getAnswer() == null ? other.getAnswer() == null : this.getAnswer().equals(other.getAnswer()));
    }

    /**
     *
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getAnswer() == null) ? 0 : getAnswer().hashCode());
        return result;
    }
}