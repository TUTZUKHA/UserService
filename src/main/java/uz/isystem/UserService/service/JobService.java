package uz.isystem.UserService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import uz.isystem.UserService.JobRepository;
import uz.isystem.UserService.exception.BadRequest;
import uz.isystem.UserService.model.Job;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@Component

public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public boolean create(Job job) {
        job.setCreatedAt(LocalDateTime.now());
        job.setStatus(true);
        Job job1;
        job1 = jobRepository.save(job);
        return true;
    }

    public Job getJob(Integer id) {
        return getEntity(id);
    }

    public boolean delete(Integer id) {
        Job job = getEntity(id);
        job.setDeletedAt(LocalDateTime.now());
        jobRepository.save(job);
        return true;
    }

    private Job getEntity(Integer id) {
        Optional<Job> optional = jobRepository.findById(id);
        if (optional.isEmpty()) {
            throw new BadRequest("Job not foud");
        }
        return optional.get();
    }
    public boolean updateJob(Integer id, Job job){
        Job job1 = getEntity(id);
        job1.setDescription(job.getDescription());
        job1.setCreatedAt(job.getCreatedAt());
        job1.setDeletedAt(job.getDeletedAt());
        jobRepository.save(job1);
        return true;
    }
    public String deleteJob(Integer id){
        getEntity(id);
        jobRepository.deleteById(id);
        return "Job deleted";
    }
    public List<Job> getAll(){
        List<Job> jobList = null;
        if (jobList.isEmpty()){
            throw new BadRequest("JOB not foud");
        }
        return jobList;
    }
}

