package com.mftplus.jee11.model.controller.servlet;

import com.mftplus.jee11.model.entity.User;
import com.mftplus.jee11.model.service.UserService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@WebServlet(urlPatterns = "/user")
@Slf4j
public class UserServlet extends HttpServlet { //ERROR=null

    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = User.builder()
                .username("aa")
                .password("1234")
                .build();
        userService.save(user);
        User userFound1 = userService.findById(1L);
        userFound1.setPassword("4444");
        userService.update(userFound1);

        User userFound2 = userService.findById(1L);
        userService.update(userFound2);
    }
}
