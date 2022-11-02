package com.guat.myosotis.web;

import com.alibaba.fastjson2.JSON;
import com.guat.myosotis.service.MyMeetingService;
import com.guat.myosotis.service.impl.MyMeetingServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/meeting/delete/servlet")
public class MyMeetingDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //定义
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //获取
        String id = req.getParameter("id");
        //删除
        MyMeetingService myMeetingService = new MyMeetingServiceImpl();
        boolean success = myMeetingService.deleteMeeting(id);
        //返回
        out.write(JSON.toJSONString(success));
    }
}
