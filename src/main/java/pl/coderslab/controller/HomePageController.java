package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import pl.coderslab.entity.Tweet;
import pl.coderslab.entity.User;
import pl.coderslab.repository.TweetRepository;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class HomePageController {

    @Autowired
    private TweetRepository tweetRepository;

    @GetMapping(path = "/")
    public String index(@SessionAttribute(name = "user", required = false) User user, Model model) {
        if(user != null) {
            List<Tweet> tweets = tweetRepository.getTweetsByUserIdUsingQuery(user.getId());
            model.addAttribute("tweets", tweets);

            Tweet tweet = new Tweet();
            model.addAttribute("tweet", tweet);
            return "user/home";
        } else {
            return "index";
        }
    }

    @PostMapping(path = "/")
    public String index(@Valid Tweet tweet, BindingResult bindingResult) {
        tweet.setCreated(LocalDateTime.now());
        if (bindingResult.hasErrors()) {
            return "user/home";
        } else {
            tweetRepository.save(tweet);
            return "redirect:/";
        }
    }

}
