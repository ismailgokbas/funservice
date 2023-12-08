package com.reaction.funcategory.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
public class VideoComments {
    @Id
    public Long commentid;
    public String comment;
    public Date commentdate;
    public String username;
    public Long userid;
}
