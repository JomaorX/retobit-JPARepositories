package dev.marshall_bits.repositories.repositories;

import dev.marshall_bits.repositories.models.Post;
import dev.marshall_bits.repositories.models.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Enumeration;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    //@Transactional - Cuando vas a modificar/borrar cualquier cosa en la base de datos

    //@Query - Si hacemos consultas especificas en lenguaje SQLm

    Post findByTitle (String title);


    List<Post> findByCategory (Enumeration<PostCategory> category);

    @Query("SELECT a FROM Post WHERE a.viewCount > 100")
    List<Post> findPostsWithMoreThan100Views();

    @Query(value = "SELECT * FROM Post ORDER BY created_At", nativeQuery = true)
    List<Post> findAllByCreatedAt();

    @Query(value = "SELECT * FROM Post WHERE title LIKE %:something%", nativeQuery = true)
    List<Post> findByTitleContaining(String keyword);

}
