package io.teknek.topshop;

public class Listing {
  private long listing_id;
  private String title;
  private String description;
  
  public Listing(){
    
  }

  public long getListing_id() {
    return listing_id;
  }

  public void setListing_id(long listing_id) {
    this.listing_id = listing_id;
  }



  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (listing_id ^ (listing_id >>> 32));
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Listing other = (Listing) obj;
    if (listing_id != other.listing_id)
      return false;
    return true;
  }

}
