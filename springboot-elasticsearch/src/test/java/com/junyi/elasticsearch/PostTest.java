package com.junyi.elasticsearch;

import com.junyi.elasticsearch.bean.Post;
import com.junyi.elasticsearch.bean.Tag;
import com.junyi.elasticsearch.service.PostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by goujy on 5/6/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostTest {
    @Autowired
    PostService postService;

    @Test
    public void testFindByTagsName() throws Exception {
        Tag tag = new Tag();
        tag.setId("1");
        tag.setName("tech");

        Tag tag2 = new Tag();
        tag2.setId("2");
        tag2.setName("elasticsearch");

        Post post = new Post();
        post.setId("A01");
        post.setTitle("Bigining with spring boot application and elasticsearch");
        post.setTags(Arrays.asList(tag, tag2));

        postService.save(post);

        Post post2 = new Post();
        post2.setId("B02");
        post2.setTitle("Bigining with spring boot application--update");
        post2.setTags(Arrays.asList(tag));

        postService.save(post);


        Page<Post> posts = postService.findByTagsName("tech", new PageRequest(0, 10));
        Page<Post> posts2 = postService.findByTagsName("tech", new PageRequest(0, 10));
        Page<Post> posts3 = postService.findByTagsName("maz", new PageRequest(0, 10));

        /*assertThat(posts.getTotalElements(), is(1L));
        assertThat(posts2.getTotalElements(), is(1L));
        assertThat(posts3.getTotalElements(), is(0L));*/

        System.out.println(posts.getTotalElements()+"=="+posts2.getTotalElements());
    }
}
