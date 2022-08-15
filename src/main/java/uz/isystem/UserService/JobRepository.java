package uz.isystem.UserService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.isystem.UserService.model.Job;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {

}
