package pers.hanchao.himybatis.one2many;

/**
 * <p>人员-工作经历操作DAO层接口</p>
 * @author hanchao 2018/1/27 15:50
 **/
public interface IPersonDAO {
    /** 根据id查询人员信息及工作经验信息 */
    Person queryPersonById(Integer id);
}
