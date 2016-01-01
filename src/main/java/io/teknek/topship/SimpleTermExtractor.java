package io.teknek.topship;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/** This is the bare bones thing that works logically but basically 
 * produces nothing useful as it will count all words including what should be stop words */
public class SimpleTermExtractor implements TermExtractor {

  private Set<String> stopWords;
  
  public SimpleTermExtractor(){
    stopWords = new HashSet<>();
    InputStream in = this.getClass().getClassLoader().getResourceAsStream("stop_words.txt");
    String word = null;
    try (BufferedReader br = new BufferedReader( new InputStreamReader(in)) ){
      while ((word = br.readLine()) != null){
        stopWords.add(word);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    } 
  }
  
  @Override
  public TermResults extractScores(Shop shop) {
    TermResults termResults = new TermResults(); 
    for (Listing item: shop.getItems()){
      StringTokenizer st = new StringTokenizer(item.getTitle(), " .!,?|");
      while (st.hasMoreTokens()){
        String token = st.nextToken();
        scoreTerm(token, termResults);
      }
      st = new StringTokenizer(item.getDescription(), " .!,?|");
      while (st.hasMoreTokens()){
        String token = st.nextToken();
        scoreTerm(token, termResults);
      }
    }
    return termResults;
  }

  private void scoreTerm(String term, TermResults termResults){
    term = term.toLowerCase();
    if (term.endsWith("'s")){
      term = term.replace("'s", "");
    }
    if (term.endsWith("’s")){
      term = term.replace("’s", "");
    }
    if (term.contains("\n")){
      term = term.replace("\n", "");
    }
    
    if (stopWords.contains(term)){
      return;
    }
    termResults.addTerm(term);
  }
  
  
  
}
