package com.aaa.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author:祁继港
 * @Date:2019/12/3 16:55
 */
@Component
public class CustomZuulFilter extends ZuulFilter {
    @Override
    public String filterType() {
        //此处设置的式过滤器的类型，而我设置的为前置过滤器
        return "pre";
    }

    @Override
    public int filterOrder() {
        // 优先级为0，数字越大，优先级越低
        return 0;
    }

    /**
     * 是否执行过滤
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 此处表示的是真正的过滤逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext=RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String token = request.getParameter("token");
        System.out.println("token===========" + token);
        if (null!=token) {
            //对该请求路由
            currentContext.setSendZuulResponse(true);
            currentContext.setResponseStatusCode(200);
            //设值，让下一个filter看到上一个filter的状态
            currentContext.set("成功",true);
        }else {
            //过滤该请求，不进行路由
            currentContext.setSendZuulResponse(false);
            // 返回错误码
            currentContext.setResponseStatusCode(401);
            try {
                currentContext.getResponse().getWriter().write("自己有多少力量没点逼数");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //这里return的值没有意义，zuul框架没有使用该返回值
        return null;
    }
}
