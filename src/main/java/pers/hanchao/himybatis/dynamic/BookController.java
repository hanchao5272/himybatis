package pers.hanchao.himybatis.dynamic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>MyBatis动态SQL</p>
 * @author hanchao 2018/1/31 22:46
 **/
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * <p>查询所有的旧书，查询条件可能有价格、是否汉化</p>
     * @author hanchao 2018/1/31 22:52
     **/
    @PostMapping("/book/if/")
    public MyJsonResult<Book> selectBookWithIf(@RequestBody Book book){
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
    @GetMapping("/book/where/")
    public MyJsonResult<Book> selectBookWithWhere(@RequestBody Book book){
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
    @GetMapping("/book/trim/")
    public MyJsonResult<Book> selectBookWithTrim(@RequestBody Book book){
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
    @PostMapping("/book/set/")
    public MyJsonResult<Book> updateBookWithSet(@RequestBody Book book){
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
    @PostMapping("/book/trim/")
    public MyJsonResult<Book> updateBookWithTrim(@RequestBody Book book){
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
    @GetMapping("/book/choose/")
    public MyJsonResult<Book> updateBookWithChoose(@RequestBody Book book){
        List<Book> bookList = this.bookService.updateBookWithChoose(book);
        if (null == bookList || bookList.size() == 0){
            return new MyJsonResult<Book>(2,"暂无记录！");
        }else {
            return new MyJsonResult<Book>(1,"success!",bookList);
        }
    }

    /**
     * <p>查询书籍，查询条件为多个书籍名称</p>
     * @author hanchao 2018/1/31 23:08
     **/
    @GetMapping("/book/foreach/")
    public MyJsonResult<Book> updateBookWithForEach(@RequestBody Book book){
        List<Book> bookList = this.bookService.updateBookWithForEach(book);
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
    @GetMapping("/book/bind/")
    public MyJsonResult<Book> selectBookWithForBind(@RequestBody Book book){
        List<Book> bookList = this.bookService.selectBookWithForBind(book);
        if (null == bookList || bookList.size() == 0){
            return new MyJsonResult<Book>(2,"暂无记录！");
        }else {
            return new MyJsonResult<Book>(1,"success!",bookList);
        }
    }

}
