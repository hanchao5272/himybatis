package pers.hanchao.himybatis.dynamic;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>书籍类的Dao层接口</p>
 * @author hanchao 2018/1/30 22:47
 **/
@Repository
public interface IBookDAO {
    /** 根据id查询一本书 */
    Book selectBookById(Integer id);

    /** 查询所有的旧书，查询条件可能有价格、是否汉化 */
    List<Book> selectBookWitIf(Book book);

    /** 查询所有书籍，查询条件可能有价格、是否汉化【where形式】 */
    List<Book> selectBookWithWhere(Book book);

    /** 查询所有书籍，查询条件可能有价格、是否汉化【trim形式】 */
    List<Book> selectBookWithTrim(Book book);

    /** 根据id修改一本书，可能的修改条件有价格、书籍名【set形式】 */
    void updateBookWithSet(Book book);

    /** 根据id修改一本书，可能的修改条件有价格、书籍名【trim形式】 */
    void updateBookWithTrim(Book book);

    /** 查询书籍，如果查询条件有编号按编号查询，有书名就按书名查询，有价格按价格查询,都没有就查询旧书 */
    List<Book> selectBookWithChoose(Book book);

    /** 查询书籍，查询条件为多个书籍名称,数组形式 */
    List<Book> selectBookWithForEachArray(String[] names);

    /** 查询书籍，查询条件为多个书籍名称，列表形式*/
    List<Book> selectBookWithForEachList(List nameList);

    /** 查询书籍，查询条件为多个书籍名称，键值对形式 */
    List<Book> selectBookWithForEachMap(Map nameMap);

    /** 查询书籍，要求书籍编号符合一个年级的编号，如初中、高中等等 */
    List<Book> selectBookWithBind(Book book);

}
