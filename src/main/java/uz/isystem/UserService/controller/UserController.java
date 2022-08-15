package uz.isystem.UserService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.isystem.UserService.model.Job;
import uz.isystem.UserService.model.User;
import uz.isystem.UserService.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")

public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<? > create(@RequestBody User user){
        Boolean result= userService.create(user);
        return ResponseEntity.ok(result);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser (@PathVariable("id") Integer id){
        User result = userService.getUser(id);
        return ResponseEntity.ok(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id")Integer id,
                                        @RequestBody User user){
        boolean result = userService.updateUser(id,user);
        return ResponseEntity.ok(result);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id){
        String result = userService.deleteUser(id);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/jobs/{id}")
    public ResponseEntity<?> getJob(@PathVariable("id") Integer id){
        List<Job> result = userService.getJob(id);
        return ResponseEntity.ok(result);
    }




}
