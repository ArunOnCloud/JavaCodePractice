package lld.stackoverflow;

import lombok.Data;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/*


user should post the question
user can view the question
user can answer the question
user should get feed of the question
questions can have tag of experties like java,php,javascript


 */
public class StackOverFlow {

    List<User> users;
    List<Question> questions;
    List<Answer> answers;

}
@Data
class User{
    String id;
    String name;
    String email;
    String password;
    StackOverFlow stackOverFlow;

    public Question createQuestion(String description,List<String> tag,String heading){
      //TODD
        return new Question();
    }
    public void answerQuestion(Question question,String answer){
       // TO DO
    }
    public void commentQuestion(Question question,String answer){
     //TO DO
    }
    public List<Question> getQuestions(){
        // TO DO
        return  new LinkedList<>();
    }

}
@Data
class Question{
    String id;
    User createdBy;
    String heading;
    String description;
    Date createdDate;
    List<String> tags;
    List<Comment> comments;
    List<Answer> answers;

    public void addComment(Comment comment){

    }
    public void addAnswer(Answer answer){

    }



}
@Data
class Comment{
    String id;
    User commentedBy;
    String comment;
    Question question;
}
@Data
class Answer{
    String id;
    User answeredBy;
    String answer;
    Question question;
}
