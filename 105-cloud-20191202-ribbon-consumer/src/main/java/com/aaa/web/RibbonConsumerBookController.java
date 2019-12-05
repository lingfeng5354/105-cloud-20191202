package com.aaa.web;

import com.aaa.model.BookInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author:祁继港
 * @Date:2019/12/2 15:58
 */
@RestController
public class RibbonConsumerBookController {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 加入 @HystrixCommand注解表示增加当调用getAllBook的方法失败时熔断器的处理办法。
     * “fallbackMethod = "error"”表示处理的方法为error方法
     * @return
     */
    @HystrixCommand(fallbackMethod = "error",commandProperties = {@HystrixProperty(name =
            "execution.isolation.thread.timeoutInMilliseconds",value = "15000")})
    @GetMapping("getAllBook")
    public List<BookInfo> getAllBook(){

        LinkedList<BookInfo> forObject = restTemplate.getForObject("http://provider-server/getAllBook",
                LinkedList.class);
        return forObject;
    }
    public List<BookInfo> error(){
        System.out.println("服务器开始熔断");

        return null;
    }
}
