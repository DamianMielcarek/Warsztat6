package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    User findOneByUsernameAndPassword(String username, String password);
    User findOneByUsername(String username);
    User findOneById(long id);

}
