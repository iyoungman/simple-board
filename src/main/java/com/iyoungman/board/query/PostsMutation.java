package com.iyoungman.board.query;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.iyoungman.board.domain.Posts;
import com.iyoungman.board.dto.PostsSaveInput;
import com.iyoungman.board.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by iyoungman on 2020-07-01.
 */

@Component
public class PostsMutation implements GraphQLMutationResolver {

    @Autowired
    private PostsService postsService;

    public Posts savePosts(PostsSaveInput request) {
        return postsService.savePosts(request);
    }

}