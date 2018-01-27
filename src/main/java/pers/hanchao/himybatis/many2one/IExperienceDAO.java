package pers.hanchao.himybatis.many2one;

/**
 * <p>工作经历-人员DAO层接口</p>
 * @author hanchao 2018/1/27 16:02
 **/
public interface IExperienceDAO {
    /** 根据id查询工作经验及所属人员信息 */
    Experience queryExperienceById(Integer id);
}
