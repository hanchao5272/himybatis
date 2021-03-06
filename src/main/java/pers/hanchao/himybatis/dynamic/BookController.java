package pers.hanchao.himybatis.dynamic;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>MyBatis动态SQL:If,Where,Set,Trim,Choose,ForEach,Bind</p>
 * @author hanchao 2018/1/31 22:46
 **/
@RestController
public class BookController {
    private static final Logger LOGGER = Logger.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    /**
     * <p>查询所有的旧书，查询条件可能有价格、是否汉化</p>
     * @author hanchao 2018/1/31 22:52
     **/
    @PostMapping("/book/if")
    public MyJsonResult<Book> selectBookWithIf(@RequestBody Book book){
        LOGGER.info(book);
        List<Book> bookList = this.bookService.selectBookWithIf(book);
        if (null == bookList || bookList.size() == 0){
            return new MyJsonResult<Book>(2,"暂无记录！");
        }else {
            return new MyJsonResult<Book>(1,"success!",bookList);
        }
    }
    /**
     * <p>查询所有书籍，查询条件可能有价格、是否汉化【where形式】</p>
     * @author hanchao 2018/1/31 22:53
     **/
    @PostMapping("/book/where")
    public MyJsonResult<Book> selectBookWithWhere(@RequestBody Book book){
        LOGGER.info(book);
        List<Book> bookList = this.bookService.selectBookWithWhere(book);
        if (null == bookList || bookList.size() == 0){
            return new MyJsonResult<Book>(2,"暂无记录！");
        }else {
            return new MyJsonResult<Book>(1,"success!",bookList);
        }
    }

    /**
     * <p>查询所有书籍，查询条件可能有价格、是否汉化【trim形式】</p>
     * @author hanchao 2018/1/31 22:54
     **/
    @PostMapping("/book/trim/where")
    public MyJsonResult<Book> selectBookWithTrim(@RequestBody Book book){
        LOGGER.info(book);
        List<Book> bookList = this.bookService.selectBookWithTrim(book);
        if (null == bookList || bookList.size() == 0){
            return new MyJsonResult<Book>(2,"暂无记录！");
        }else {
            return new MyJsonResult<Book>(1,"success!",bookList);
        }
    }

    /**
     * <p>根据id修改一本书，可能的修改条件有价格、书籍名【set形式】</p>
     * @author hanchao 2018/1/31 22:54
     **/
    @PostMapping("/book/set")
    public MyJsonResult<Book> updateBookWithSet(@RequestBody Book book){
        LOGGER.info(book);
        //先查书籍是否存在
        Book book1 = this.bookService.selectBookById(book.getId());
        if (null == book1){
            return new MyJsonResult<Book>(2,"此书不存在，无法修改！");
        }else {
            this.bookService.updateBookWithSet(book);
            return new MyJsonResult<Book>();
        }
    }

    /**
     * <p>根据id修改一本书，可能的修改条件有价格、书籍名【trim形式】</p>
     * @author hanchao 2018/1/31 22:54
     **/
    @PostMapping("/book/trim/set")
    public MyJsonResult<Book> updateBookWithTrim(@RequestBody Book book){
        LOGGER.info(book);
        //先查书籍是否存在
        Book book1 = this.bookService.selectBookById(book.getId());
        if (null == book1){
            return new MyJsonResult<Book>(2,"此书不存在，无法修改！");
        }else {
            this.bookService.updateBookWithTrim(book);
            return new MyJsonResult<Book>();
        }
    }

    /**
     * <p>查询书籍，如果查询条件有编号按编号查询，有书名就按书名查询，有价格按价格查询,都没有就查询旧书</p>
     * @author hanchao 2018/1/31 23:08
     **/
    @PostMapping("/book/choose")
    public MyJsonResult<Book> updateBookWithChoose(@RequestBody Book book){
        LOGGER.info(book);
        List<Book> bookList = this.bookService.updateBookWithChoose(book);
        if (null == bookList || bookList.size() == 0){
            return new MyJsonResult<Book>(2,"暂无记录！");
        }else {
            return new MyJsonResult<Book>(1,"success!",bookList);
        }
    }

    /**
     * <p>查询书籍，查询条件为多个书籍名称(Array形式)</p>
     * @author hanchao 2018/1/31 23:08
     **/
    @PostMapping("/book/foreach/array")
    public MyJsonResult<Book> selectBookWithForEachArray(){
        String[] names = new String []{"初中数学1","大学英语4"};
        List<Book> bookList = this.bookService.selectBookWithForEachArray(names);
        if (null == bookList || bookList.size() == 0){
            return new MyJsonResult<Book>(2,"暂无记录！");
        }else {
            return new MyJsonResult<Book>(1,"success!",bookList);
        }
    }

    /**
     * <p>查询书籍，查询条件为多个书籍名称(list形式)</p>
     * @author hanchao 2018/1/31 23:08
     **/
    @PostMapping("/book/foreach/list")
    public MyJsonResult<Book> selectBookWithForEachList(){
        List<String> nameList = new ArrayList<String>();
        nameList.add(new String("高中数学2"));
        nameList.add(new String("初中数学2"));
        List<Book> bookList = this.bookService.selectBookWithForEachList(nameList);
        if (null == bookList || bookList.size() == 0){
            return new MyJsonResult<Book>(2,"暂无记录！");
        }else {
            return new MyJsonResult<Book>(1,"success!",bookList);
        }
    }

    /**
     * <p>查询书籍，查询条件为多个书籍名称(Map形式)</p>
     * @author hanchao 2018/1/31 23:08
     **/
    @PostMapping("/book/foreach/map")
    public MyJsonResult<Book> selectBookWithForEachMap(){

        Map<String,String > nameMap = new HashMap<String, String>();
        nameMap.put("1","高中数学3");
        nameMap.put("2","大学英语1");

        Map<String ,Map<String ,String >> map = new HashMap<String, Map<String, String>>();
        map.put("nameMap",nameMap);

        List<Book> bookList = this.bookService.selectBookWithForEachMap(map);
        if (null == bookList || bookList.size() == 0){
            return new MyJsonResult<Book>(2,"暂无记录！");
        }else {
            return new MyJsonResult<Book>(1,"success!",bookList);
        }
    }

    /**
     * <p>查询书籍，要求书籍编号符合一个年级的编号，如初中、高中等等</p>
     * @author hanchao 2018/1/31 23:10
     **/
    @PostMapping("/book/bind")
    public MyJsonResult<Book> selectBookWithForBind(@RequestBody Book book){
        LOGGER.info(book);
        List<Book> bookList = this.bookService.selectBookWithForBind(book);
        if (null == bookList || bookList.size() == 0){
            return new MyJsonResult<Book>(2,"暂无记录！");
        }else {
            return new MyJsonResult<Book>(1,"success!",bookList);
        }
    }

}
