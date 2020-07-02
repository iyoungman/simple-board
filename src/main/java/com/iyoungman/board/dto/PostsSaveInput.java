package com.iyoungman.board.dto;

import com.iyoungman.board.domain.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by iyoungman on 2020-07-01.
 */

@Getter
@NoArgsConstructor
public class PostsSaveInput {

    private String title;

    private String content;

    private String author;

    @Builder
    public PostsSaveInput(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
