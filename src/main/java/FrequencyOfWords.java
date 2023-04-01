import java.util.HashMap;
import java.util.Map;

public class FrequencyOfWords {

    public static void main(String[] args){
        FrequencyOfWords frequencyOfWords=new FrequencyOfWords();
        frequencyOfWords.frequescyOfWords("arun is software arun is adf");
    }


    public void frequescyOfWords(String sent){

        sent= sent.trim();
        String[] words= sent.split(" ");
        Map<String,Integer> frequency= new HashMap<>();
        if(words.length >0){

            for(String word: words){
               // frequency.put(word, frequency.get(word)+1)
                if( frequency.get(word) == null){
                    frequency.put(word,1);
                }else{
                    frequency.put(word,frequency.get(word)+1);
                }
            }
        }
        for(Map.Entry<String,Integer> entry: frequency.entrySet()){
            System.out.println(entry.getKey() +":"+ entry.getValue());
        }

    }
}
