package com.reaction.funcategory.repository;

import com.reaction.funcategory.model.FunVideos;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface FunRepo extends MongoRepository<FunVideos,String> {
}
