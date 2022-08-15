package uz.isystem.UserService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.isystem.UserService.model.Job;
import uz.isystem.UserService.service.JobService;

@RestController
@RequestMapping("/api/job")

public class JobController {
    @Autowired
    private JobService jobService;
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Job job){
        Boolean result = jobService.create(job);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getJob (@PathVariable("id") Integer id){
        Job result=jobService.getJob(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateJob(@PathVariable("id") Integer id,
                                       @RequestBody Job job){
        boolean result = jobService.updateJob(id,job);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJob(@PathVariable("id") Integer id){
        String result = jobService.deleteJob(id);
        return ResponseEntity.ok(result);
    }
}
