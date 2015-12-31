package io.teknek.topship;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/** This is the bare bones thing that works logically but basically 
 * produces nothing useful as it will count a the etc as terms */
public class SimpleTermExtractor implements TermExtractor {

  @Override
  public TermResults extractScores(Shop shop) {
    TermResults termResults = new TermResults(); 
    for (Item item: shop.getItems()){
      StringTokenizer st = new StringTokenizer(item.getTitle(), " .!,?");
      while (st.hasMoreTokens()){
        String token = st.nextToken();
        scoreTerm(token, termResults);
      }
      st = new StringTokenizer(item.getDescription(), " .!,?");
      while (st.hasMoreTokens()){
        String token = st.nextToken();
        scoreTerm(token, termResults);
      }
    }
    return termResults;
  }

  private static void scoreTerm(String term, TermResults termResults){
    term = term.toLowerCase();
    if (term.endsWith("'s")){
      term = term.replace("'s", "");
    }
    if (term.endsWith("’s")){
      term = term.replace("’s", "");
    }
    termResults.addTerm(term);
  }
}
