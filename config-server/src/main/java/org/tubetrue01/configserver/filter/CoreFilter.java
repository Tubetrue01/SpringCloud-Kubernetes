package org.tubetrue01.configserver.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User : Pengfei Zhang
 * Mail : Tubetrue01@gmail.com
 * Date : 2019/12/4
 * Time : 1:35 下午
 * Description :
 */
public class CoreFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        var httpRequest = (HttpServletRequest) request;
        var url = httpRequest.getRequestURL().toString();
        System.out.println("=====================");
        System.out.println(url);
        System.out.println("=====================");

        if (!url.contains("/bus-refresh")) {
            chain.doFilter(request, response);
        }else {
            chain.doFilter(new RequestWrapper(httpRequest), response);
        }

    }
}
