package com.junyi.elasticsearch.repository;

import com.junyi.elasticsearch.bean.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 *
 * @author goujy
 * @date 5/6/18
 */
public interface PostRepository extends ElasticsearchRepository<Post,String> {
    Page<Post> findByTagsName(String name, Pageable pageable);
}
