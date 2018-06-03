package com.upgrad.ImageHoster.common;

import com.upgrad.ImageHoster.model.Comment;
import com.upgrad.ImageHoster.model.Image;
import org.hibernate.Session;

public class CommentManager extends SessionManager {

    /**
     * This method saves an image's data to the database
     *
     * @param comment the Image who's data that we want to save to the database
     */
    public void saveComment (final Comment comment) {
        Session session = openSession();
        session.save(comment);
        commitSession(session);
    }
}
