package com.reaction.funcategory.controller;

import com.reaction.funcategory.model.CombineVideoAndComment;
import com.reaction.funcategory.model.FunVideos;
import com.reaction.funcategory.service.FunService;
import jakarta.ws.rs.GET;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcategory")
@AllArgsConstructor
@CrossOrigin
public class FunController {

    private final FunService funService;

    @GetMapping("/videos/{page}")
    public ResponseEntity<List<FunVideos>> getFunVideosLinks(@PathVariable Integer page){
        return ResponseEntity.ok(this.funService.GetFunVideos(page));
    }

    @PutMapping("/videos/reaction/adding/{id}")
    public ResponseEntity addReactionToVideo(@PathVariable String id,@RequestParam String reactionName){
        this.funService.ReactionToVideo(id,reactionName,true);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/videos/reaction/removing/{id}")
    public ResponseEntity removingReactionToVideo(@PathVariable String id,@RequestParam String reactionName){
        this.funService.ReactionToVideo(id,reactionName,false);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/oneVideo")
    public ResponseEntity<FunVideos> getOneFunVideo(@RequestParam String videoId){
        return ResponseEntity.ok(this.funService.GetOneFunVideo(videoId));
    }

    @GetMapping("/getCombines")
    public ResponseEntity<List<CombineVideoAndComment>> getCombinePack(@RequestParam Integer videosPage,@RequestParam Integer size){
        return ResponseEntity.ok(this.funService.GetCombinationPack(videosPage,size));
    }
}