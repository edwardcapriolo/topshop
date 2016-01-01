package io.teknek.topshop;

import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import io.teknek.topshop.Listing;
import io.teknek.topshop.Shop;
import io.teknek.topshop.SimpleTermExtractor;
import io.teknek.topshop.TermResults;

import org.junit.Assert;
import org.junit.Test;

public class TestSimpleExtractor {

  @Test
  public void test(){
    SimpleTermExtractor te = new SimpleTermExtractor();
    TermResults tr = te.extractScores(edsBookAndPetShop());
    Assert.assertEquals(Arrays.asList("hive", "hadoop"), tr.getScoreTerms().get(3L));
    Assert.assertEquals(new Long(3L), tr.getTermScore().get("hive"));
    TreeMap<Long, List<String>> termScores = tr.getScoreTerms();
    {
      Entry<Long, List<String>> i = termScores.pollLastEntry();
      Assert.assertEquals(Long.valueOf(3), i.getKey());
      Assert.assertEquals(Arrays.asList("hive", "hadoop"), i.getValue());
    }
  }
  
  public Shop edsBookAndPetShop(){
    Shop s = new Shop();
    s.setName("Ed's Book and Pet Shop");
    s.setUrl("http://www.edsbooksandpets.co.uk");
    Listing i = new Listing();
    i.setTitle("Programming Hive");
    i.setDescription("Need to move a relational database application to Hadoop? This comprehensive guide introduces you to Apache Hive, Hadoop’s data warehouse infrastructure. You’ll quickly learn how to use Hive’s SQL dialect—HiveQL—to summarize, query, and analyze large datasets stored in Hadoop’s distributed filesystem.");
    s.getItems().add(i);
    return s;
  }
}
