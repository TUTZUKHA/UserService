package uz.isystem.UserService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import uz.isystem.UserService.exception.BadRequest;
import uz.isystem.UserService.model.Job;
import uz.isystem.UserService.model.User;
import uz.isystem.UserService.UserRepository;
import uz.isystem.UserService.UserType;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public boolean create(User user){
        user.setCreatedAt(LocalDateTime.now());
        user.setStatus(true);
        user.setUserType(UserType.VISITOR);
        userRepository.save(user);
        return true;
    }

    public User getUser(Integer id) {
        return getEntity(id);
    }


    private User getEntity(Integer id) {
        Optional<User> optional = userRepository.findById(id);//select * from user where id = ?
        if (optional.isEmpty()){
            throw new BadRequest("User not found");
        }
        return optional.get();
    }

    public boolean updateUser(Integer id, User user) {
        User user1 = getEntity(id);
        user1.setUsername(user.getUsername());
        user1.setFirstname(user.getFirstname());
        user1.setLastname(user.getLastname());
        user1.setPassword(user.getPassword());
        user1.setEmail(user.getEmail());
        user1.setAvatar(user.getAvatar());
        user1.setBirth(user.getBirth());
        user1.setAddress(user.getAddress());
        user1.setAddress2(user.getAddress2());
        user1.setCityId(user.getCityId());
        user1.setPostcode(user.getPostcode());
        user1.setEmailVerifiedAt(user.getEmailVerifiedAt());
        user1.setPhoneVerifiedAt(user.getPhoneVerifiedAt());
        user1.setCreatedAt(user.getCreatedAt());
        user1.setUpdatedAt(user.getUpdatedAt());
        user1.setDeletedAt(user.getDeletedAt());
        user1.setQrCode(user.getQrCode());
        user1.setStatus(user.getStatus());
        user1.setUpdatedAt(LocalDateTime.now());
        userRepository.save(user1);
        return true;
    }

    public String deleteUser(Integer id) {
        getEntity(id);
        userRepository.deleteById(id);
        return "User deleted";
    }

    public List<Job> getJob(Integer id) {
        return null;
    }
}