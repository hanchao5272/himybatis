package pers.hanchao.himybatis.dynamic;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private static final Logger LOGGER = Logger.getLogger(BookService.class);
    @Autowired
    private IBookDAO bookDAO;

    public List<Book> selectBookWithIf(Book book) {
        return this.bookDAO.selectBookWitIf(book);
    }

    public List<Book> selectBookWithWhere(Book book) {
        return this.bookDAO.selectBookWithWhere(book);
    }

    public List<Book> selectBookWithTrim(Book book) {
        return this.bookDAO.selectBookWithTrim(book);
    }

    public Book selectBookById(Integer id) {
        return this.bookDAO.selectBookById(id);
    }

    public void updateBookWithTrim(Book book) {
        this.bookDAO.updateBookWithTrim(book);
    }

    public void updateBookWithSet(Book book) {
        this.bookDAO.updateBookWithSet(book);
    }

    public List<Book> updateBookWithChoose(Book book) {
        return this.bookDAO.selectBookWithChoose(book);
    }

    public List<Book> updateBookWithForEach(List nameList) {
        return this.bookDAO.selectBookWithForEach(nameList);
    }

    public List<Book> selectBookWithForBind(Book book) {
        return this.bookDAO.selectBookWithBind(book);
    }
}
