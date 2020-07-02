package com.iyoungman.board;

import static org.junit.Assert.assertEquals;

import com.iyoungman.board.domain.Posts;
import com.iyoungman.board.dto.PostsSaveInput;
import com.iyoungman.board.service.PostsService;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Created by iyoungman on 2020-07-02.
 */

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class PostsServiceTest {

    private static final int ELEMENT_SIZE = 20;
    private static final int PAGE_PER_SIZE = 10;

    @Autowired
    private PostsService postsService;

    @BeforeEach
    void init() {
        for (int i = 1; i <= ELEMENT_SIZE; i++) {
            PostsSaveInput input = PostsSaveInput.builder()
                    .title("title" + i)
                    .content("content" + i)
                    .author("author" + i)
                    .build();

            postsService.savePosts(input);
        }
    }

    @DisplayName("게시글 저장")
    @Test
    public void savePosts() {
        //given
        final String name = "test";
        PostsSaveInput input = PostsSaveInput.builder()
                .title("title" + name)
                .content("content" + name)
                .author("author" + name)
                .build();

        //when
        Posts posts = postsService.savePosts(input);

        //then
        assertEquals(input.getTitle(), posts.getTitle());
        assertEquals(input.getContent(), posts.getContent());
        assertEquals(input.getAuthor(), posts.getAuthor());
    }

    @DisplayName("페이징 처리 확인")
    @Test
    public void getPagingPosts() {
        //given
        final int page = 0;

        //when
        List<Posts> posts = postsService.getPagingPosts(page);

        //then
        assertEquals(posts.size(), PAGE_PER_SIZE);
    }
}
