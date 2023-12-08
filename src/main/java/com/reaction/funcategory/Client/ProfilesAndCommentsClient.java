package com.reaction.funcategory.Client;


import com.reaction.funcategory.model.VideoComments;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@CrossOrigin
@FeignClient(name = "profile-service",path = "/comments")
public interface ProfilesAndCommentsClient {
    @GetMapping("/forVideo/{videoId}")
    ResponseEntity<List<VideoComments>> getCommentsForVideo(@PathVariable String videoId,@RequestParam Integer size,@RequestParam Integer page);
}
