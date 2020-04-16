package com.ydx.movie;

import com.ydx.movie.controller.UserController;
import com.ydx.movie.entity.User;
import com.ydx.movie.service.UserService;
import com.ydx.movie.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MovieApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void testFindAll() {
        String usersList = restTemplate.getForObject("/findAll", String.class);
        System.out.println(usersList);
    }

}
