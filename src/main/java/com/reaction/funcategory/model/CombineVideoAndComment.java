package com.reaction.funcategory.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Dictionary;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CombineVideoAndComment {
    private String videoId;
    private Integer vomitcount;
    private Integer angrycount;
    private Integer badwordcount;
    private Integer coolcount;
    private Integer devilcount;
    private Integer funcount;
    private Integer hardcount;
    private Integer heartcount;
    private Integer kingcount;
    private Integer partycount;
    private Integer powercount;
    private Integer shockcount;
    private String videolink;
    private String videoname;
    private List<VideoComments> commentList;
}
