package io.teknek.topship;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TermResults {
  private Map<String,Long> termScore = new HashMap<String,Long>();
  
  public void addTerm(String term){
    if (termScore.containsKey(term)){
      termScore.put(term, termScore.get(term) + 1L);
    } else {
      termScore.put(term, 1L);
    }
  }
  
  public TreeMap<Long,List<String>> scoreTerms(){
    TreeMap<Long,List<String>> toReturn = new TreeMap<Long,List<String>>();
    for(Map.Entry<String, Long> entry: termScore.entrySet()){
      if(toReturn.containsKey(entry.getValue())){
        toReturn.get(entry.getValue()).add(entry.getKey());
      } else {
        List<String> terms = new ArrayList<>();
        terms.add(entry.getKey());
        toReturn.put(entry.getValue(), terms);
      }
    }
    return toReturn;
  }

  public Map<String, Long> getTermScore() {
    return termScore;
  }
}
