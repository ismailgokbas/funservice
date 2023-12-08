package com.reaction.funcategory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FunVideos {
    @Id
    public String id;
    public Integer vomitcount;
    public Integer angrycount;
    public Integer badwordcount;
    public Integer coolcount;
    public Integer devilcount;
    public Integer funcount;
    public Integer hardcount;
    public Integer heartcount;
    public Integer kingcount;
    public Integer partycount;
    public Integer powercount;
    public Integer shockcount;
    public String videolink;
    public String videoname;
}
