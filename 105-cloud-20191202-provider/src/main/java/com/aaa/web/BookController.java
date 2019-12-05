package com.aaa.web;

import com.aaa.model.BookInfo;
import com.aaa.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author:祁继港
 * @Date:2019/12/2 15:22
 */
@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    //private int i=1;
    @GetMapping("getAllBook")
    public List<BookInfo> getAllBook(){
        List<BookInfo> allBook=bookService.getAllBook();
        if (allBook == null) {
            return null;
        }
        for (BookInfo bookInfo : allBook) {
            System.out.println(bookInfo);
        }
        /*if (++i % 2 == 0) {
            throw new IllegalArgumentException("服务出错了");
            *//*try {
                Thread.sleep(15000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*//*
        }*/

        return allBook;
    }
}
