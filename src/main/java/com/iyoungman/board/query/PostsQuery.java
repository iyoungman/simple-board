package com.iyoungman.board.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.iyoungman.board.domain.Posts;
import com.iyoungman.board.service.PostsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by iyoungman on 2020-07-01.
 */

@Component
public class PostsQuery implements GraphQLQueryResolver {

    @Autowired
    private PostsService postsService;

    public Posts getPosts(String id) {
        return postsService.getPosts(id);
    }

    public List<Posts> getPagingPosts(int page) {
        return postsService.getPagingPosts(page);
    }
}
