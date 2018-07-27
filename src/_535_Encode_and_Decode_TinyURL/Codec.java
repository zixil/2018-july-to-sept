package _535_Encode_and_Decode_TinyURL;

import java.util.HashMap;

public class Codec {
    HashMap<String, String> de = new HashMap<>();
    int size = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (de.containsValue(longUrl))
            for (String k : de.keySet())
                if (de.get(k).equals(longUrl)) return k;
        String shortUrl = String.valueOf(size++);
        de.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return de.get(shortUrl);
    }
}
