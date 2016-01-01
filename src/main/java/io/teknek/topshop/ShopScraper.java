package io.teknek.topshop;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import net.sf.corn.httpclient.HttpForm;
import net.sf.corn.httpclient.HttpResponse;

public class ShopScraper implements Scraper {
  private static final ObjectMapper MAPPER = new ObjectMapper();
  static {
    MAPPER.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }
  private String apiKey;

  public ShopScraper(String key){
    apiKey = key; 
  }
  
  public Shop scrape(String shopName){
    Shop s = new Shop();
    s.setName(shopName);
    HttpForm form;
    try {
      form = new HttpForm(new URI("https://openapi.etsy.com/v2/shops/" + shopName + "/listings/active"));
      form.putFieldValue("api_key", apiKey);
      HttpResponse response = form.doGet();
      EtsyListingResult result  = (EtsyListingResult) MAPPER.readValue(response.getData(), EtsyListingResult.class);
      s.setItems(new HashSet<>(result.getResults()));
    } catch (URISyntaxException | IOException e) {
      throw new RuntimeException(e);
    }
    return s;
  }
}
