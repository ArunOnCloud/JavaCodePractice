package lld.twitter;


/*
Design entities:
1) user can post
2) user can follow
3) user can see timeline
4) celebrity problem
5)
 */
public class TwitterApp {

    PostService postService ;


     public String registerUser(User user){

         return "success";
     }
     public String createPost(Post post){
         return "";
     }

     public void followUser(User user, User followee){


     }
}
