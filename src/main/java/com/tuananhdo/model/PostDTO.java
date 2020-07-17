package com.tuananhdo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
@Setter
@Getter
public class PostDTO implements Serializable {

    private int id;
    private String imageUrl;
    private String title;
    private String description;
    private MultipartFile file;
}
