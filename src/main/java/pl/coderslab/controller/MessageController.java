package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Message;
import pl.coderslab.entity.User;
import pl.coderslab.repository.MessageRepository;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping(path = "message")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping(path = "showMessages")
    public String showMessages(@SessionAttribute(name = "user", required = false) User user, Model model) {
        if(user != null) {
            List<Message> receivedMessages = messageRepository.findByReceiverId(user.getId());
            for (Message m: receivedMessages) {
                if (m.getContent().length()>30) {
                    m.setContent(m.getContent().substring(0, 30));
                }
            }
            List<Message> sentMessages = messageRepository.findBySenderId(user.getId());
            for (Message m: sentMessages) {
                if (m.getContent().length()>30) {
                    m.setContent(m.getContent().substring(0, 30));
                }
            }
            model.addAttribute("receivedMessages", receivedMessages);
            model.addAttribute("sentMessages", sentMessages);
            model.addAttribute("username", user.getUsername());
            return "message/showMessages";
        } else {
            return "user/login";
        }
    }

    @GetMapping(path = "add")
    public String addMessage(Model model) {
        model.addAttribute("message", new Message());
        return "message/add";
    }

    @PostMapping(path = "add")
    public String addMessage(@SessionAttribute(name = "receiver", required = false) User receiver,
                             @SessionAttribute(name = "user", required = false) User user,
                             @Valid Message message, BindingResult bindingResult) {
        message.setSent(LocalDateTime.now());
        message.setSender(user);
        message.setSeen(false);

        if(bindingResult.hasErrors()) {
            return "redirect:/user/show?id=" + receiver.getId();
        } else {
            messageRepository.save(message);
            return "redirect:/message/showMessages";
        }
    }

    @GetMapping(path = "show")
    public String show(@SessionAttribute(name = "user", required = false) User user,
                       @RequestParam("id") long id, Model model) {
        if (user != null) {
            Message message = messageRepository.findOne(id);
            if(user.getId() == message.getReceiver().getId()) {
                message.setSeen(true);
            }
            messageRepository.save(message);
            model.addAttribute("message", message);

            return "message/show";
        } else {
            return "user/login";
        }
    }

}
