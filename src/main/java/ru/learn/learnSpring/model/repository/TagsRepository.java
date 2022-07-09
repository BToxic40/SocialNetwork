package ru.learn.learnSpring.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.learn.learnSpring.model.Tag;
import ru.learn.learnSpring.model.TagWithCount;

import java.util.List;
import java.util.Optional;

public interface TagsRepository extends CrudRepository<Tag, Integer> {
    List<Tag> findAllByOrderByIdDesc();

    @Query(value = "SELECT * FROM tags where name = ?1", nativeQuery = true)
    Optional<Tag> findByName(String nameTag);

    @Query(value = "SELECT id FROM tags where name = ?1 LIMIT 1", nativeQuery = true)
    Optional<Integer> findTag(String tag);

    @Query(value = "SELECT tp.post_id FROM spring.tag2post as tp WHERE tag_id = ?1", nativeQuery = true)
    List<Integer> findIdsPostsByTagId(Integer tag);

    @Query(value = "SELECT name FROM tags where id = ?1", nativeQuery = true)
    String findTagsById(Integer id);


    @Query(value = "SELECT t.name, COUNT(t.name) as postsCount FROM spring.tags as t " +
            "JOIN spring.tag2post as t2p ON  t.id = t2p.tag_id " +
            "WHERE t.name LIKE %:query% " +
            "GROUP BY t.name " +
            "ORDER BY postsCount DESC " +
            "LIMIT 20;", nativeQuery = true)
    List<TagWithCount> findTagsWithPostsCount(String query);

}
