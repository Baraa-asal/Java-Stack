package Hashmatique;

import java.util.HashMap;
import java.util.Set;
public class Main {
    public static void main(String[] args) {

        HashMap<String, String> tracks = new HashMap<String, String>(); // what's after "new" is CALLED A CONSTRUCTOR(it
                                                                        // always should be the same name of the class)
        tracks.put("Maroon", "So scarlet, it was maroon");
        tracks.put("Search", "Last year, I had a breakdown");
        tracks.put("Beautiful", "Lately I've been hard to reach");
        tracks.put("Venom", "I got a song filled with shit for the strong-willed");

        String trackLyrics = tracks.get("Search");
        System.out.println(trackLyrics);
        Set<String> keys = tracks.keySet();
        for(String key : keys) {
            System.out.println(key + ": " + tracks.get(key));    
        }
    }
}
