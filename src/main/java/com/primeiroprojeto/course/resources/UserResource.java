package com.primeiroprojeto.course.resources;

import com.primeiroprojeto.course.entities.User;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users")
public class UserResource {
    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L,"erick","erickgeovane2002@gmail.com","83999999999","password");
        return ResponseEntity.ok().body(u);
    }
}
