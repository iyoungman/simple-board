package com.iyoungman.board.dto;

import com.iyoungman.board.domain.Posts;

/**
 * Created by iyoungman on 2020-07-01.
 */

public class PostsResponse {

    private String id;
    private String title;
    private String content;
    private String author;
    private String modifiedDate;

    public PostsResponse(Posts posts) {
        this.id = posts.getId();
        this.title = posts.getTitle();
        this.content = posts.getContent();
        this.author = posts.getAuthor();
        this.modifiedDate = posts.getModifiedTime().toString();
    }
}
