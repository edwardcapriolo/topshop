package io.teknek.topshop;

import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Driver {
  
  private Scraper scraper; 
  private TermExtractor termExtractor;
  
  public Driver(String key){
    scraper = new ShopScraper(key);
    termExtractor = new SimpleTermExtractor();
  }
  
  public static void main (String [] args){
    Driver driver = new Driver(args[0]);
    driver.drive(args[1]);
  }
  
  public void drive(String shopId){
    Shop shop = scraper.scrape(shopId);
    TermResults tr = termExtractor.extractScores(shop);
    display(tr, shop);
  }
  
  private void display(TermResults tr, Shop shop){
    TreeMap<Long, List<String>> results = tr.getScoreTerms();
    for (int i = 0 ; i < 5; i++){
      Entry<Long, List<String>> j = results.pollLastEntry();
      if (j == null){
        return;
      }
      System.out.println("Shop : " + shop.getName() + " Occurances: " + j.getKey() + " terms: "
              + j.getValue());
    }
  }
}
