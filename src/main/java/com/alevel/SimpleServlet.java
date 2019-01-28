package com.alevel;

import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import sun.misc.IOUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class SimpleServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        if (StringUtils.isEmpty(name)){
            name = "new world";
        }
        PrintWriter writer = response.getWriter();
        writer.write("Hello " + name);
        writer.flush();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
/*        BufferedReader reader = request.getReader();
        String json = "";
        String line;
        while ((line = reader.readLine()) != null){
            json += line;
        }*/
        UserDTO user = new Gson().fromJson(request.getReader(), UserDTO.class);
        PrintWriter writer = response.getWriter();
        writer.write(user.firstName + " " + user.email);
        writer.flush();
    }
}
