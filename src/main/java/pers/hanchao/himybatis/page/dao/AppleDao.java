package pers.hanchao.himybatis.page.dao;

import java.util.List;
import pers.hanchao.himybatis.page.entity.AppleEntity;

public interface AppleDao {
    /**
     * 根据主键删除数据库的记录
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insert(AppleEntity record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    AppleEntity selectByPrimaryKey(Integer id);

    /**
     * 获取全部数据库记录
     *
     */
    List<AppleEntity> selectAll();

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(AppleEntity record);
}