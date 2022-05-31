package lld.tinyurl.src;

import lld.tinyurl.src.exception.InvalidUrlException;
import lld.tinyurl.src.exception.TinyUrlException;
import lld.tinyurl.src.service.FileService;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class TinyUrl {

    private Logger logger = Logger.getLogger(TinyUrl.class.getName());

    private Map<Long, String> tokenUrlMap;

    private FileService fileService;

    public TinyUrl() {
        fileService = new FileService();
        initTokenUrlMap();
    }

    private void initTokenUrlMap() {
        tokenUrlMap = new HashMap<>();
        try {
            String mappings = fileService.readData("tokenUrlMapping.txt");
            String[] mappingArr = mappings.split("\n");
            int numOfMappings = mappingArr.length;
            for (int i = 0; i < numOfMappings; i++) {
                String[] entries = mappingArr[i].split(" ");
                tokenUrlMap.put(Long.valueOf(entries[0]), entries[1]);
            }
        } catch (TinyUrlException ex) {
            logger.info("No id:url mappings found");
        }
    }

    /* N = number of characters in tiny url
     * Y = number of unique tiny urls needed
     * N = logY base 26
     * Y = number of urls request / sec * time(in sec for how long to provide support)
     */
    public static void main(String[] args) {
        TinyUrl obj = new TinyUrl();
        //Get Short URL
        String longUrl = "https://www.google.com/imgres?imgurl=https%3A%2F%2Fthumbs.dreamstime.com%2Fz%2Fman-horse-20682533.jpg&imgrefurl=https%3A%2F%2Fwww.dreamstime.com%2Fstock-photos-man-horse-image20682533&tbnid=1WCG_NgP0d1bTM&vet=12ahUKEwjd99viguj2AhUzi9gFHRaaBDIQMygaegUIARCzAg..i&docid=oYJcPUMyMZ6OEM&w=1300&h=983&q=man%20on%20horse&client=firefox-b-d&ved=2ahUKEwjd99viguj2AhUzi9gFHRaaBDIQMygaegUIARCzAg";
        String shortUrl = obj.toShortUrl(longUrl);
        System.out.println("Long URL = " + longUrl);
        System.out.println("Short URL = " + shortUrl);

        //Get Long URL
        shortUrl = "GhP";
        longUrl = obj.toLongUrl(shortUrl);
        System.out.println("Short Url = " + shortUrl);
        System.out.println("Long Url = " + longUrl);
    }

    private String toLongUrl(String shortUrl) {
        if (shortUrl == null || shortUrl.isEmpty()) {
            throw new InvalidUrlException("Short URL is null or empty");
        }

        //convert base 62 to base 10
        long id = 0;
        int length = shortUrl.length();
        for (int i = length-1; i >=0; i--) {
            char ch = shortUrl.charAt(i);
            int val;
            if (ch >= 'a' && ch <= 'z') {
                val = ch - 'a';
            } else if (ch >= 'A' && ch <= 'Z') {
                val = ch - 'A' + 26;
            } else if (ch >= '0' && ch <= '9') {
                val = ch - '0' + 52;
            } else {
                throw new InvalidUrlException("Invalid Short URL : " + shortUrl);
            }

            id += (long)Math.pow(62, length-1-i) * val;
        }

        System.out.println("shortUrl = " + shortUrl + " : id = " + id);
        String longUrl = tokenUrlMap.get(id);
        if (longUrl == null) {
            throw new InvalidUrlException("Short URL not found");
        }

        return longUrl;
    }


    private String toShortUrl(String longUrl){
        long token = getNextToken();
        long tokenCopy = token;
        //convert base 10 to base 62
        StringBuilder sb = new StringBuilder();
        while (token > 0) {
            long rem = token%62;
            if (rem>=0 && rem<=25) {
                sb.append((char)('a'+rem));
            } else if (rem>=26 && rem<=51) {
                sb.append((char)('A'+(rem-26)));
            } else {
                sb.append((char)('0'+(rem-52)));
            }
            token = token/62;
        }

        sb.reverse(); //reversing to make first one as LSB

        fileService.persistData(tokenCopy + " " + longUrl, "tokenUrlMapping.txt", true);

        return sb.toString();
    }

    private long getNextToken() {
        long nextAvailToken = readToken();
        saveToken(nextAvailToken + 1);
        return nextAvailToken;
    }

    private long readToken() {
        return Long.parseLong(fileService.readData("token.txt"));
    }

    private void saveToken(long token) {
        fileService.persistData(String.valueOf(token), "token.txt", false);
    }

}
