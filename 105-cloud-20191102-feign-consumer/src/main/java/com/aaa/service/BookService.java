package com.aaa.service;

import com.aaa.model.BookInfo;
import com.aaa.service.impl.BookServiceHystrixImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author:祁继港
 * @Date:2019/12/2 16:14
 */
//声明为FeignClent 并且连接 provider-server
@FeignClient(value = "provider-server",fallback = BookServiceHystrixImpl.class)
public interface BookService {

        /**
         * 查询所有书籍信息
         * @param
         * @return java.util.List<com.aaa.qy105.model.BookInfo>
         * @Author: 祁继港
         * @Date: 2019/11/21
         */
        @RequestMapping(value = "/getAllBook")
        List<BookInfo> getAllBook();
}
