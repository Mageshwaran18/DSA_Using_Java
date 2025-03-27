package Hashing;

import java.util.HashMap;
import java.util.Map;

public class basic_hashing {
    public static void main(String[] args) {
        // Create a new HashMap
        HashMap<String, Integer> map = new HashMap<>();
        
        // Adding elements (Key-Value pairs)
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        
        // Get value by key
        System.out.println("Value of 'One': " + map.get("One"));
        
        // Check if key exists
        System.out.println("Contains key 'Two'? " + map.containsKey("Two"));
        
        // Check if value exists
        System.out.println("Contains value 3? " + map.containsValue(3));
        
        // Remove an element
        map.remove("Two");
        
        // Size of HashMap
        System.out.println("Size of HashMap: " + map.size());
        
        // Check if HashMap is empty
        System.out.println("Is HashMap empty? " + map.isEmpty());
        
        // Iterate through HashMap
        System.out.println("\nIterating through HashMap:");
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        
        // Clear all elements
        map.clear();
        
        // Demonstrate null key and value
        map.put(null, 0);
        map.put("Null Value", null);
        
        // Replace value
        map.replace("One", 100);
        
        // Get value with default
        int value = map.getOrDefault("Four", 4);
        
        // Put if absent
        map.putIfAbsent("Five", 5);
    }
}
    
