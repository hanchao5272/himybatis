package pers.hanchao.himybatis.generator.dao;

import java.util.List;
import pers.hanchao.himybatis.generator.entity.TopicEntity;

public interface TopicDao {
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
    int insert(TopicEntity record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    TopicEntity selectByPrimaryKey(Integer id);

    /**
     * 获取全部数据库记录
     *
     */
    List<TopicEntity> selectAll();

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(TopicEntity record);
}