package com.shorten.shortener;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Base62Generator {

  private static final int length = 8;
  private static final Random random = new Random();
  private static final Map<String, String> shortenedMap = new HashMap<>();

  // This array is used for character to number
  private static final char[] chars = {
      'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
      'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
      'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
      'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
      'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
      'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7',
      '8', '9'
  };

  // generateKey
  public static String generateKey(String url) {

    if (shortenedMap.containsKey(url)) {
      return shortenedMap.get(url);
    }

    final StringBuilder key = new StringBuilder();
    do {
      for (int i = 0; i < length; i++) {
        key.append(chars[random.nextInt(chars.length)]);
      }
    } while (shortenedMap.containsValue(key.toString()));

    shortenedMap.put(url, key.toString());
    return shortenedMap.get(url);
  }
}