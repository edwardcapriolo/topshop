package io.teknek.topship;

import java.util.List;

public class EtsyListingResult {
  private Long count;
  private List<Listing> results;
  
  public EtsyListingResult(){
    
  }

  public Long getCount() {
    return count;
  }

  public void setCount(Long count) {
    this.count = count;
  }

  public List<Listing> getResults() {
    return results;
  }

  public void setResults(List<Listing> results) {
    this.results = results;
  }
  
}