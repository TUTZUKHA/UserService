package uz.isystem.UserService;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.isystem.UserService.model.User;



public interface UserRepository extends JpaRepository<User,Integer> {
}
