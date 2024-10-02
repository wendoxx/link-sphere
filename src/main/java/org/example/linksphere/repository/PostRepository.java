package org.example.linksphere.repository;

import org.example.linksphere.model.PostModel;
import org.example.linksphere.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface PostRepository extends JpaRepository<PostModel, Long>{
    Optional<PostModel> findByTitle(String title);
    Optional<PostModel> findByContent(String content);
    Optional<PostModel> findByUserUsername(String username);
}
