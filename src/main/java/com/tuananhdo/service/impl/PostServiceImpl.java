package com.tuananhdo.service.impl;

import com.tuananhdo.entity.Posts;
import com.tuananhdo.repository.PostRepository;
import com.tuananhdo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Override
    public List<Posts> listAll() {
        return postRepository.findAll() ;
    }

    @Override
    public void savePost(Posts posts) {
        this.postRepository.save(posts);
    }


    @Override
    public Posts findPostById(int id) {
        return postRepository.findById(id).get();
    }

    @Override
    public void deletePost(int id) {
        this.postRepository.deleteById(id);
    }
}
