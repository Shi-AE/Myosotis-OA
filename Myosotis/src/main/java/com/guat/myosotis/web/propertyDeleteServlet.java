package com.guat.myosotis.web;

import com.alibaba.fastjson2.JSON;
import com.guat.myosotis.service.PropertyService;
import com.guat.myosotis.service.impl.PropertyServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/property/delete/servlet")
public class propertyDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //定义
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //获取编号
        String id = req.getParameter("id");
        PropertyService propertyService = new PropertyServiceImpl();
        boolean success = propertyService.deleteProperty(id);
        //返回
        out.write(JSON.toJSONString(success));
    }
}
