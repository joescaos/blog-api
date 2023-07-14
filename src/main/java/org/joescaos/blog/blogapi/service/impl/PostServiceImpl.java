package org.joescaos.blog.blogapi.service.impl;

import org.joescaos.blog.blogapi.dto.PostDTO;
import org.joescaos.blog.blogapi.exception.ResourceNotFoundException;
import org.joescaos.blog.blogapi.model.Post;
import org.joescaos.blog.blogapi.repository.PostRepository;
import org.joescaos.blog.blogapi.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private ModelMapper mapper;
    @Autowired
    private PostRepository postRepository;

    @Override
    public PostDTO createPost(PostDTO postDTO) {

        Post post = mapper.map(postDTO, Post.class);
        Post newPost = postRepository.save(post);
        return mapper.map(newPost, PostDTO.class);
    }

    @Override
    public List<PostDTO> getAllPost() {
        List<Post> result = postRepository.findAll();
        return result.stream()
                .map(post -> mapper.map(post, PostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO getPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", id));

        return mapper.map(post, PostDTO.class);
    }
}
