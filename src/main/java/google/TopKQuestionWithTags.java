package google;


import java.util.*;

/*

Given questions and tags
select top k questions for the tags







 */
public class TopKQuestionWithTags {

    /*


    q1: [t1,t2,t3]
    q2: [t3,t5]
    q3: [t1]
    q4: [t2,t1]
    how do you make use of this data

    q1: [t1,t2,t3]

    q1      q2   q3 q4
    |\\__   |
    | \  \ /\
    t1 t2 t3 t4 t5


    q1

    q2

    q3

    q4
     */
    List<String> topKquestions(Map<String,List<String>> questionsWithTags){
        return new LinkedList<>();
    }
}
