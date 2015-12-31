package io.teknek.topship;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/** This is the bare bones thing that works logically but basically 
 * produces nothing useful as it will count a the etc as terms */
public class SimpleTermExtractor implements TermExtractor{

  @Override
  public Map<String, Long> extractScores(Shop shop) {
    Map<String,Long> termScore = new HashMap<String,Long>();
    for (Item item: shop.getItems()){
      StringTokenizer st = new StringTokenizer(item.getTitle(), " .!,?");
      while (st.hasMoreTokens()){
        String token = st.nextToken();
        scoreTerm(token, termScore);
      }
      st = new StringTokenizer(item.getDescription(), " .!,?");
      while (st.hasMoreTokens()){
        String token = st.nextToken();
        scoreTerm(token, termScore);
      }
    }
    return termScore;
  }

  private static void scoreTerm(String term, Map<String,Long> termScore){
    term = term.toLowerCase();
    if (term.endsWith("'s")){
      term = term.replace("'s", "");
    }
    if (term.endsWith("’s")){
      term = term.replace("’s", "");
    }
    if (termScore.containsKey(term)){
      termScore.put(term, termScore.get(term) + 1L);
    } else {
      termScore.put(term, 1L);
    }
  }
}
