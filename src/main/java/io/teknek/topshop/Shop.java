package io.teknek.topshop;

import java.util.HashSet;
import java.util.Set;

public class Shop {
  private String name;
  private String url;
  private Set<Listing> items;
  
  public Shop(){
    items = new HashSet<>();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Set<Listing> getItems() {
    return items;
  }

  public void setItems(Set<Listing> items) {
    this.items = items;
  }
  
}
