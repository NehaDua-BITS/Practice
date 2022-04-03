package designpatterns.structural.command.service;

import java.util.HashMap;
import java.util.Map;

public class Database {

    private static Database database;

    private HashMap<String, Double> map;

    public static Database getDatabase() {
        if (database == null) {
            database = new Database();
        }
        return database;
    }

    private Database() {
        map = new HashMap<>();
        map.put("Neha", 0.0);
        map.put("Parth", 110.0);
    }

    public void upsertUser(String name, Double balance) {
        map.put(name, balance);
    }

    public Double getUserBalance(String name) {
        Double balance = map.get(name);
        if (balance == null) {
            throw new RuntimeException("User not found");
        }
        return balance;
    }

}
