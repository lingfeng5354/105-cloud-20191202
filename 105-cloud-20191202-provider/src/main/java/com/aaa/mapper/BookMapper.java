package com.aaa.mapper;

import com.aaa.model.BookInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author:祁继港
 * @Date:2019/12/2 15:29
 */
@Mapper
public interface BookMapper {
    /**
     * 查询所有书籍信息
     * @param
     * @return java.util.List<com.aaa.model.BookInfo>
     * @Author: cat
     * @Date: 2019/11/21
     */
    @Select("select * from book_info")
    List<BookInfo> getAllBook();

    /**
     * 添加图书
     * @param bookInfo
     * @return void
     * @Author: cat
     * @Date: 2019/11/21
     */
    void addBook(BookInfo bookInfo);

    /**
     * 修改图书
     * @param bookInfo
     * @return void
     * @Author: cat
     * @Date: 2019/11/21
     */
    void updateBook(BookInfo bookInfo);
    /**
     * 删除图书
     * @param bookId
     * @return void
     * @Author: cat
     * @Date: 2019/11/21
     */
    void deleteBook(Integer bookId);
}
