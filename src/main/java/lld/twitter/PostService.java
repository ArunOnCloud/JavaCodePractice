package lld.twitter;

import java.util.List;
import java.util.stream.Collectors;

public class PostService {

    List<Post> posts;

    public void addPost(Post post){

    }
    public Post getPost(String postId){
        List<Post> post= posts.stream().filter((a)-> a.equals(postId)).collect(Collectors.toList());
        return post.get(0);
    }

    public List<Post> getTimeline(User user){

        //TO DO

        return List.of();
    }

}
