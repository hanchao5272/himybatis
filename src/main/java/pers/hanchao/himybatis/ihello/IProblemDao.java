package pers.hanchao.himybatis.ihello;

/**
 * <p>实体对应的Dao层接口，与Problem.xml通过namespace建立关联</p>
 * @author hanchao 2018/1/26 23:24
 **/
public interface IProblemDao {
    /** 简单查询 */
    Problem getProblemById(Integer id);
}
