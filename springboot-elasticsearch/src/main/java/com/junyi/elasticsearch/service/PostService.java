package com.junyi.elasticsearch.service;

import com.junyi.elasticsearch.bean.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 *
 * @author goujy
 * @date 5/6/18
 */
public interface PostService {
    Post save(Post post);

    Post findOne(String id);

    Iterable<Post> findAll();

    Page<Post> findByTagsName(String tagName, PageRequest pageRequest);
}
