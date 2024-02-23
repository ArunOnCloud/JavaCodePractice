package lld.twitter;

import lombok.Data;

import java.util.Date;

@Data
public class Post {

    String postId;
    Date createdDate;
    User createdBy;
    String post;

}
