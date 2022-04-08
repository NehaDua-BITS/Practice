package lld.cache;

import lld.cache.factory.CacheFactory;
import lld.cache.service.Cache;

public class Driver {

    public static void main(String[] args) {

        CacheFactory<String, String> cacheFactory = new CacheFactory<>();
        Cache<String, String> cache = cacheFactory.getDefaultCache(4);

        //add keys
        cache.add("Neha" , "Dua");
        cache.add("Parth", "Savjani");
        cache.add("Himanshu", "Dua");
        cache.add("Manju" , "Dua");
        System.out.println("Currently cache is : \n" + cache);

        cache.add("Hayzel", "Savjani");
        System.out.println("Now cache after crossing capacity is : \n" + cache);

        cache.add("Parth", "Savjani");
        System.out.println("Now cache after reaccessing is : \n" + cache);

        cache.add("ABC", "DEF");
        System.out.println("Now cache after crossing capacity is : \n" + cache);

    }
}
