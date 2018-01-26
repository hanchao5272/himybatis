package pers.hanchao.himybatis.hello;

/**
 * <p>试题</p>
 * @author hanchao 2018/1/26 18:28
 **/
public class Question {
    /** 试题id */
    private Integer id;
    /** 题目 */
    private String title;
    /** 分数 */
    private Integer score;
    /** 答案 */
    private String answer;

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", score=" + score +
                ", answer='" + answer + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
