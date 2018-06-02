package com.upgrad.ImageHoster.service;

import com.upgrad.ImageHoster.model.Image;

import java.util.List;

public interface ImageService{
    List<Image> getAll();
    List<Image> getByTag(String tagName);
    Image getByTitle(String title);
    Image getById(int id); //New service to getById to fix: https://github.com/upgrad-edu/Course4_Assignment/issues/2
    Image getByTitleWithJoin(String title);
    void deleteByTitle(Image image);
    void save(Image image);
    void update(Image image);
}