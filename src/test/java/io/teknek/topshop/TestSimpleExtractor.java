package io.teknek.topshop;

import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import io.teknek.topship.Item;
import io.teknek.topship.Shop;
import io.teknek.topship.SimpleTermExtractor;
import io.teknek.topship.TermResults;

import org.junit.Assert;
import org.junit.Test;

public class TestSimpleExtractor {

  @Test
  public void test(){
    SimpleTermExtractor te = new SimpleTermExtractor();
    TermResults tr = te.extractScores(edsBookAndPetShop());
    Assert.assertEquals(Arrays.asList("hive", "hadoop"), tr.scoreTerms().get(3L));
    Assert.assertEquals(new Long(3L), tr.getTermScore().get("hive"));
    TreeMap<Long, List<String>> termScores = tr.scoreTerms();
    {
      Entry<Long, List<String>> i = termScores.pollLastEntry();
      Assert.assertEquals(Long.valueOf(4), i.getKey());
      Assert.assertEquals(Arrays.asList("to"), i.getValue());
    }
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
    Item i = new Item();
    i.setTitle("Programming Hive");
    i.setDescription("Need to move a relational database application to Hadoop? This comprehensive guide introduces you to Apache Hive, Hadoop’s data warehouse infrastructure. You’ll quickly learn how to use Hive’s SQL dialect—HiveQL—to summarize, query, and analyze large datasets stored in Hadoop’s distributed filesystem.");
    s.getItems().add(i);
    return s;
  }
}
