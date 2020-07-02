package com.iyoungman.board.service;

import com.iyoungman.board.domain.Posts;
import com.iyoungman.board.domain.PostsRepository;
import com.iyoungman.board.dto.PostsSaveInput;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by iyoungman on 2020-07-01.
 */

@Transactional
@Service
public class PostsService {

    private static final int PAGE_SIZE = 10;

    private static final String SORT_COLUMN = "modifiedDate";

    @Autowired
    private PostsRepository postsRepository;

    public Posts savePosts(PostsSaveInput request) {
        return postsRepository.save(request.toEntity());
    }

    public Posts getPosts(String id) {
        return postsRepository.findById(id).orElseThrow(() -> new RuntimeException("단일 조회 예외"));
    }

    public List<Posts> getPagingPosts(int page) {
        Pageable pageable = PageRequest.of(page, PAGE_SIZE, byModifiedDateDesc());
        Page<Posts> posts = postsRepository.findAll(pageable);

        return posts.getContent();
    }

    private Sort byModifiedDateDesc() {
        return Sort.by(Direction.DESC, SORT_COLUMN);
    }
}
