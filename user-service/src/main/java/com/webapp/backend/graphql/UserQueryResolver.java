package com.webapp.backend.graphql;

import com.webapp.backend.model.User;
import com.webapp.backend.responce.UserResponce;
import com.webapp.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserQueryResolver  {
    @Autowired
    UserService userService;

    @QueryMapping
    public UserResponce getUser(@Argument Integer userId) throws Exception {

        UserResponce userOptional = userService.getById(Long.valueOf(userId));
            return userOptional;
    }

    @QueryMapping
    public List<User> getAllUser() {
        List<User> userOptional = userService.getAllUsers();
        return userOptional;
    }

}