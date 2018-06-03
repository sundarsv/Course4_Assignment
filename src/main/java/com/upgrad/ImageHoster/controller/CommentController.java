package com.upgrad.ImageHoster.controller;

import com.upgrad.ImageHoster.common.ImageManager;
import com.upgrad.ImageHoster.model.Comment;
import com.upgrad.ImageHoster.model.Image;
import com.upgrad.ImageHoster.model.User;
import com.upgrad.ImageHoster.service.CommentService;
import com.upgrad.ImageHoster.service.ImageService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommentController {

    @Autowired
    private CommentService commentService;


    @Autowired
    private ImageService imageService;

    /*
     * This controller is to recieve the form input and to create a new comment
     */
    @RequestMapping (value = "/image/{id}/comments/create", method = RequestMethod.POST)
    public String newComment (@RequestParam("comment") String description, @PathVariable int id,
                              HttpSession session) throws IOException {
        User currUser = (User) session.getAttribute("currUser");

        imageService.getById(id);

        // if the user is not logged in, redirect to the home page
        if(currUser == null ){
            return "redirect:/";
        } else {
            Comment comments = new Comment(description);
            commentService.save(comments);
        }
        return "redirect:/";
    }

}
