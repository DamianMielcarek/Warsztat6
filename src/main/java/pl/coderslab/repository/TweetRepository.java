package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Tweet;

import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {

    @Query(value = "select t from Tweet t where t.user.username = :username")
    List<Tweet> getTweetsByUsernameUsingQuery(@Param("username") String username);

    @Query(value = "select t from Tweet t where t.user.id = :id")
    List<Tweet> getTweetsByUserIdUsingQuery(@Param("id") long id);

    Tweet findOneById(@Param("id") long id);

}
