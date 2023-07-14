package org.joescaos.blog.blogapi.service;

import org.joescaos.blog.blogapi.dto.PostDTO;

import java.util.List;

public interface PostService {

    PostDTO createPost(PostDTO postDTO);

    List<PostDTO> getAllPost();

    PostDTO getPostById(Long id);

}
