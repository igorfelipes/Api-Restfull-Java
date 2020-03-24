package com.igorsales.demo.resources;

import com.igorsales.demo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User jose = new User("1", "Jose Carlos","josecarlos@gmail.com");
        User igor = new User("2", "Igor Sales","igorsales.fs@gmail.com");
        User carlos = new User("3", "Carlos Alberto","carlos@gmail.com");

        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(jose, igor, carlos));
        return ResponseEntity.ok().body(list);
    }
}
