package userservice.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import userservice.userservice.entity.User;
@Repository
public interface UserServiceRepo extends JpaRepository<User, Long> {
}
