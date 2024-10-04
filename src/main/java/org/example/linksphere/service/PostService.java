package org.example.linksphere.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.linksphere.dto.request.PostRequestDTO;
import org.example.linksphere.dto.response.PostResponseDTO;
import org.example.linksphere.model.PostModel;
import org.example.linksphere.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private ModelMapper modelMapper;

    public PostResponseDTO getPostById(Long id) {
        PostModel post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));

        return modelMapper.map(post, PostResponseDTO.class);
    }

    public List<PostResponseDTO> getAllPosts() {
        List<PostModel> posts = postRepository.findAll();

        if (posts.isEmpty()) {
            throw new RuntimeException("No posts found");
        }

        return modelMapper.map(posts, List.class);
    }

    @Transactional
    public PostResponseDTO createAndUpdatePost(PostRequestDTO request) {
        PostModel post;

        if(request.getId() != null && postRepository.existsById(request.getId())) {
            post = postRepository.findById(request.getId()).get();
        } else {
            post = new PostModel();
        }

        post.setId(request.getId());
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
       // post.setUserId(request.getUserId());
        postRepository.save(post);

        return modelMapper.map(post, PostResponseDTO.class);
    }

    @Transactional
    public PostResponseDTO createPost(PostRequestDTO requestDTO){
        return createAndUpdatePost(requestDTO);
    }

    @Transactional
    public PostResponseDTO updatePost(PostRequestDTO requestDTO){
        return createAndUpdatePost(requestDTO);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
