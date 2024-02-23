package lld.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FollowerService {


    Map<String, List<User>> followers;

    public void addFollower(User user,User follower){
        List<User> list =  followers.getOrDefault(user.getId(),new ArrayList<User>());
        list.add(follower);
        followers.put(user.getId(),list);

    }
    public  List<User> getFollower(User user){

     return followers.get(user.getId());
    }
}
