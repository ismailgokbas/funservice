package com.reaction.funcategory.service;

import com.reaction.funcategory.Client.ProfilesAndCommentsClient;
import com.reaction.funcategory.model.CombineVideoAndComment;
import com.reaction.funcategory.model.FunVideos;
import com.reaction.funcategory.model.VideoComments;
import com.reaction.funcategory.repository.FunRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FunService {

    private final FunRepo funRepo;
    private final ProfilesAndCommentsClient profilesandcommentsclient;

    public List<FunVideos> GetFunVideos(Integer page){
        Page<FunVideos> videos = funRepo.findAll(PageRequest.of(page,10));
        return videos.stream().toList();
    }

    public FunVideos GetOneFunVideo(String videoId){
        return funRepo.findById(videoId)
                .orElse(new FunVideos());
    }


    public void ReactionToVideo(String videoId, String reactionName,Boolean add) {
        FunVideos tempVideo = funRepo.findById(videoId)
                .orElseThrow(() -> new RuntimeException("problem"));

        int count = add ? 1 :-1;
        switch (reactionName){
            case "vomit":

                tempVideo.setVomitcount(tempVideo.getVomitcount()+count);
                break;
            case "angry":
                tempVideo.setAngrycount(tempVideo.getAngrycount()+count);
                break;
            case "badword":
                tempVideo.setBadwordcount(tempVideo.getBadwordcount()+count);
                break;
            case "cool":
                tempVideo.setCoolcount(tempVideo.getCoolcount()+count);
                break;
            case "devil":
                tempVideo.setDevilcount(tempVideo.getDevilcount()+count);
                break;
            case "fun":
                tempVideo.setFuncount(tempVideo.getFuncount()+count);
                break;
            case "hard":
                tempVideo.setHardcount(tempVideo.getHardcount()+count);
                break;
            case "heart":
                tempVideo.setHeartcount(tempVideo.getHeartcount()+count);
                break;
            case "king":
                tempVideo.setKingcount(tempVideo.getKingcount()+count);
                break;
            case "party":
                tempVideo.setPartycount(tempVideo.getPartycount()+count);
                break;
            case "power":
                tempVideo.setPowercount(tempVideo.getPowercount()+count);
                break;
            case "shock":
                tempVideo.setShockcount(tempVideo.getShockcount()+count);
                break;
        }

        funRepo.save(tempVideo);
    }

    public List<CombineVideoAndComment> GetCombinationPack(Integer VideoPage,Integer size) {
        List<FunVideos> videos = funRepo.findAll(PageRequest.of(VideoPage,10)).stream().toList();
        List<CombineVideoAndComment> combinePack = new ArrayList<>();
        videos.forEach((video)->{
            List<VideoComments> commentList = profilesandcommentsclient.getCommentsForVideo(video.id,size,0)
                            .getBody().stream().toList();
            combinePack.add(
                    new CombineVideoAndComment(video.id,video.vomitcount,
                            video.angrycount,video.badwordcount,video.coolcount,video.devilcount,
                            video.funcount,video.hardcount,video.heartcount,video.kingcount,video.partycount,
                            video.powercount,video.shockcount,video.videolink,video.videoname,
                            commentList)
            );
        });
        return combinePack;
    }
}

