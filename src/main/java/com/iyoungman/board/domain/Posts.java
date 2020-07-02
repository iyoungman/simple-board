package com.iyoungman.board.domain;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by iyoungman on 2020-07-01.
 */

@Document(collection = "posts")
@Getter
@NoArgsConstructor
public class Posts {

    @Id
    private String id;

    private String title;

    private String content;

    private String author;

    @CreatedDate
	private LocalDateTime createdTime;

	@LastModifiedDate
	private LocalDateTime modifiedTime;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
