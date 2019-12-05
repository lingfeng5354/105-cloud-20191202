package com.aaa.service;

import com.aaa.mapper.BookMapper;
import com.aaa.model.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:祁继港
 * @Date:2019/12/2 15:26
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;
    @Override
    public List<BookInfo> getAllBook() {
        List<BookInfo> bookInfos = bookMapper.getAllBook();
        if(null==bookInfos){
            return null;
        }
        return bookInfos;
    }

    @Override
    public void addBook(BookInfo bookInfo) {

    }

    @Override
    public void updateBook(BookInfo bookInfo) {

    }

    @Override
    public void deleteBook(Integer bookId) {

    }
}
