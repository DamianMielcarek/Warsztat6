package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Comment;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.repository.CommentRepository;
import pl.coderslab.repository.TweetRepository;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping(path = "tweet")
public class TweetController {

    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(path = "details/{id}")
    public String tweetDetails(@PathVariable(name = "id") long id, Model model,
                               @ModelAttribute("comment") Comment comment) {
        Tweet post = tweetRepository.findOneById(id);
        model.addAttribute("post", post);

        List<Comment> comments = commentRepository.getCommentsByTweetIdUsingQuery(id);
        model.addAttribute("comments", comments);
        model.addAttribute("comment", new Comment());

        return "tweet/details";
    }

    @PostMapping(path = "details/{id}")
    public String addComment(@SessionAttribute(name = "user", required = false) User user,
                             @Valid Comment comment, BindingResult bindingResult,
                             @ModelAttribute("post") Tweet post) {
        Comment typedComment = new Comment();
        typedComment.setCreated(LocalDateTime.now());
        typedComment.setText(comment.getText());
        typedComment.setUser(user);
        typedComment.setPost(post);

        if (bindingResult.hasErrors()) {
            return "tweet/details";
        } else {
            commentRepository.save(typedComment);
            return "redirect:/tweet/details/" + post.getId();
        }
    }

}
