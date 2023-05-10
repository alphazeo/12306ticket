package cn.edu.guet;

import com.alibaba.fastjson.JSON;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class TicketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String startStation = request.getParameter("startStation");
        System.out.println("出发" + startStation);
        String endStation = request.getParameter("endStation");
        System.out.println("到达" + endStation);
        String departureDate = request.getParameter("departureDate");
        System.out.println("时间 " + departureDate);

        String allTickets = TicketSearch.search(startStation, endStation, departureDate);
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(allTickets);
        out.flush();
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
