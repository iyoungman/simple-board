package com.iyoungman.board.domain;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by iyoungman on 2020-07-01.
 */

@Repository
public interface PostsRepository extends MongoRepository<Posts, String> {

}
