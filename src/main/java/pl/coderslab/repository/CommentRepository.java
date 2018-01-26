package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Comment;
import pl.coderslab.entity.Tweet;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "select c from Comment c where c.post = :post order by c.created desc")
    List<Comment> getCommentsByTweetUsingQuery(@Param("post") Tweet post);

    @Query(value = "select c from Comment c where c.post.id = :id order by c.created desc")
    List<Comment> getCommentsByTweetIdUsingQuery(@Param("id") long id);

}
