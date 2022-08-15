package uz.isystem.UserService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import uz.isystem.UserService.exception.BadRequest;
import uz.isystem.UserService.model.Application;
import uz.isystem.UserService.ApplicationRepository;
import uz.isystem.UserService.model.Job;
import uz.isystem.UserService.model.User;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Optional;

@Service
@Component

public class ApplacationService {

    @Autowired
    private ApplicationRepository applicationRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private JobService jobService;


    public boolean create(Application application){
        userService.getUser(application.getUserId());
        jobService.getJob(application.getJobId());
        application.setSalary(application.getSalary());
        application.setCreatedAt(LocalDateTime.now());
        applicationRepository.save(application);
        return true;
    }
    public Application getApplication(Integer id){return getEntity(id);}

    public boolean delete(Integer id){
        Application application = getEntity(id);
        application.setDeletedAt(LocalDateTime.now());
        applicationRepository.save(application);
        return true;
    }
    public Application getEntity(Integer id){
        Optional<Application> optional = applicationRepository.findById(id);
        if (optional.isEmpty()){
            throw new BadRequest("Applacation not found");
        }
        return optional.get();
    }
    public boolean updateApplacation(Integer id, Application application){
        Application application1 = getEntity(id);
        application1.setUserId(application.getUserId());
        application1.setJobId(application.getJobId());
        application1.setStartDate(application.getStartDate());
        application1.setSalary(application.getSalary());
        application1.setEndDate(application.getEndDate());
        application1.setUpdatedAt(LocalDateTime.now());
        applicationRepository.save(application1);
        return true;
    }
    public String deleteApplacation(Integer id){
        getEntity(id);
        applicationRepository.deleteById(id);
        return "Applacation deleted";
    }

}
