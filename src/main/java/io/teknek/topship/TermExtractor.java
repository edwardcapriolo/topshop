package io.teknek.topship;

/** Extracting terms properly requires ma-sheen-learning. You have things like multiple word terms and proper nouns. 
 * this interface provides the ability to build different backends so that you can do more ma-sheen-learning without
 * many cascading changes */
public interface TermExtractor {
  /**
   * Extract terms from a shop
   * @param shop a show to extract terms from
   * @return populated structure of the terms in the shop.
   */
  TermResults extractScores(Shop shop);
}
