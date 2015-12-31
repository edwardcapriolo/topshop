package io.teknek.topship;

import java.util.Map;

public interface TermExtractor {
  Map<String,Long> extractScores(Shop shop);
}
