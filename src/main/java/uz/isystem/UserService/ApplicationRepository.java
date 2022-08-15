package uz.isystem.UserService;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.isystem.UserService.model.Application;

public interface ApplicationRepository extends JpaRepository<Application,Integer> {
}
