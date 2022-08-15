package uz.isystem.UserService.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.isystem.UserService.model.Application;
import uz.isystem.UserService.service.ApplacationService;

@RestController
@RequestMapping("/application")
public class ApplicationController {


    private ApplacationService applacationService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Application application){
        boolean result = applacationService.create(application);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getApplacaton(@PathVariable("id") Integer id){
        Application result = applacationService.getApplication(id);
        return ResponseEntity.ok(result);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateApplacation(@PathVariable("id") Integer id,
                                               @RequestBody Application application){
        boolean reusult = applacationService.updateApplacation(id, application);
        return ResponseEntity.ok(reusult);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?>deleteApplacation(@PathVariable("id") Integer id){
        String result = applacationService.deleteApplacation(id);
        return ResponseEntity.ok(result);
    }
}
