package com.tuananhdo.service;

import com.tuananhdo.entity.Posts;

import java.util.List;

public interface PostService {

    List<Posts> listAll();

    void savePost(Posts posts);

    Posts findPostById(int id);

    void deletePost(int id);
}
