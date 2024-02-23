package lld.twitter;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    String id;
    String name;
    String username;
    String password;
    Date createdDate;
}
