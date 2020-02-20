package com.moonsoo.web;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
@WebFilter(filterName = "simpleFilter", urlPatterns = "/simple")
public class SimpleFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        log.info("before filter");
        chain.doFilter(request, response);
        PrintWriter writer = response.getWriter();
        writer.println("after filter");
    }

}
