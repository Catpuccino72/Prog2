package de.uni_hannover.task2.communication;

import java.io.IOException;
import java.net.*;
import java.net.http.*;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest.*;
import java.net.http.HttpResponse.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.*;

import de.uni_hannover.task2.offerings.Category;
import de.uni_hannover.task2.offerings.Item;
import netscape.javascript.JSObject;


/**
 * This class exposes function
 * that communicate with the online 
 * marketplace via http.
 * 
 * @author Kevin Schumann
 * @version 03/05/2023
 */
public class Communicator {

    public static String BASE_URL = "https://marketplace-server-kevin-schumanns-projects.vercel.app";

    
    /**
     * Logs an user with a given username and password in
     * 
     * @author Kevin Schumann
     * @param username Username
     * @param password Password for the user
     * @return True if login was succesful, otherwise False
     */
    public static boolean login(String username, String password) {
        
        JSONObject obj = new JSONObject();
        obj.put("username", username);
        obj.put("password", password);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .version(Version.HTTP_1_1)
                .uri(URI.create(BASE_URL + "/login"))
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(obj.toString()))
                .build();

        HttpResponse<String> res = null;
        
        try {
            res = client.send(request, BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return new JSONObject(res.body()).getBoolean("success");
    }

    
    
    /**
     * Registers an user with username and password
     * in the marketplace
     * 
     * @author Kevin Schumann
     * @param username Username, shall not be null or empty
     * @param password Password for the user, shall not be null or empty
     * @return True if registering was succesful. 
     *         Returns false if a user with the same username exists already or
     *         any argument is null or empty
     */
    
    public static boolean register(String username, String password) {
        if(username == null || username.length() == 0 || password == null || password.length() == 0) {
            return false;
        }

        JSONObject obj = new JSONObject();
        obj.put("username", username);
        obj.put("password", password);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .version(Version.HTTP_1_1)
                .uri(URI.create(BASE_URL + "/register"))
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(obj.toString()))
                .build();

        // send request
        HttpResponse<String> res = null;
        
        try {
            res = client.send(request, BodyHandlers.ofString());
        } catch (Exception e) {
            System.out.println(e);
        }

        return new JSONObject(res.body()).getBoolean("success");
    }
    

    /**
     * Adds an item to a user on the marketplace.
     * 
     * @author Kevin Schumann
     * @param username Username, shall not be null or empty
     * @param item Item that shall be added to the user 
     *             (with the given username) on the marketplace, shall not be null
     * @return True if adding the item to the user was succesful. 
     *         Returns false if any argument is null or empty.
     */
    public static boolean addItem(String username, Item item) {
        if(item == null || username == null || username.length() == 0) {
            return false;
        }

        JSONObject obj = new JSONObject();
        obj.put("name", item.getName());
        obj.put("price", item.getVerkaufspreis());
        obj.put("description", item.getBeschreibung());
        obj.put("category", item.getCategory().name());
        obj.put("username", username);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .version(Version.HTTP_1_1)
                .uri(URI.create(BASE_URL + "/addItem"))
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(obj.toString()))
                .build();

        // send request
        HttpResponse<String> res = null;
        
        try {
            res = client.send(request, BodyHandlers.ofString());
        } catch (Exception e) {
            System.out.println(e);
        }

        return new JSONObject(res.body()).getBoolean("success");
    }
    
    /**
     * Fetches items from the marketplace owned by username and 
     * are within the given category.
     * 
     * @author Kevin Schumann
     * @param category If specified only items with given category will be fetched
     * @param username If specifid only items that belong to the username will be fetched
     * @return Returns Item[] with specified category and are owned by username. 
     *         Null if there are no such items.
     * 
     */
    public static Item[] getItemsWith(Category category, String username) {
        JSONObject obj = new JSONObject();
        
        // if category is null we want all items
        if (category != null) {
            obj.put("category", category.name());
            
        }
        
        if (username.length() != 0) {
            obj.put("userId", username);
        }
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
        .version(Version.HTTP_1_1)
        .uri(URI.create(BASE_URL + "/getItems"))
        .header("Content-Type", "application/json")
        .POST(BodyPublishers.ofString(obj.toString()))
        .build();
        
        // send request
        HttpResponse<String> res = null;
        
        try {
            res = client.send(request, BodyHandlers.ofString());
        } catch (Exception e) {
            System.out.println(e);
        }
        
        // Get item array as JSONArray
        JSONArray response = new JSONObject(res.body()).getJSONArray("items");
        
        // Parse Array into Items
        List<Item> items = new ArrayList<>();
        for (Object o : response) {
            JSONObject json_item = (JSONObject) o;
            
            items.add(new Item(
                json_item.getInt("id"),
                json_item.getString("name"), 
                json_item.getFloat("price"), 
                json_item.getJSONObject("seller").getString("email"),
                json_item.getString("description"),
                Category.valueOf(json_item.getString("category")))
                );
        }
            
        return (Item[]) items.toArray(new Item[items.size()]);
    }

    /**
     * Fetches items from the marketplace that are within the given category.
     * 
     * @author Kevin Schumann
     * @param category If specified only items with given category will be fetched
     * @return Returns Item[] with specified category and are owned by username. 
     *         Null if there are no such items.
     * 
     */
    public static Item[] getItems(Category category) {
        return getItemsWith(category, "");
    } 
    

    /**
     * Fetches items from the marketplace that are owned by username
     * 
     * @author Kevin Schumann
     * @param username If specifid only items that belong to the username will be fetched
     * @return Returns Item[] with specified category and are owned by username. 
     *         Null if there are no such items.
     * 
     */
    
    public static Item[] getUserItems(String username) {
        return getItemsWith(null, username);
    }
    

    /**
     * Removes an item to a user on the marketplace.
     * 
     * @author Kevin Schumann
     * @param item Item that shall be removed.
     
     * @return True if removing the item was succesful. 
     *         Returns false if any argument is null or empty.
     */
    public static boolean removeItem(Item item) {
        JSONObject obj = new JSONObject();
        obj.put("itemId", item.getItemId());
        obj.put("userId", item.getVerkäufer());

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .version(Version.HTTP_1_1)
                .uri(URI.create(BASE_URL + "/removeItem"))
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(obj.toString()))
                .build();

        // send request
        HttpResponse<String> res = null;
        
        try {
            res = client.send(request, BodyHandlers.ofString());
        } catch (Exception e) {
            System.out.println(e);
        }

        return new JSONObject(res.body()).getBoolean("success");
    }
    
    
    /**
     * Updates an item on the marketplace.
     * 
     * @author Kevin Schumann
     * @param item Item that shall be updated on the server.

     * @return True if updating the item  was succesful. 
     *         If an item with the same id does not exist
     *         on the server, this function will return false.
     */
    public static boolean updateItem(Item item) {
        if(item == null) {
            return false;
        }

        JSONObject obj = new JSONObject();
        obj.put("itemId", item.getItemId());
        obj.put("name", item.getName());
        obj.put("price", item.getVerkaufspreis());
        obj.put("description", item.getBeschreibung());
        obj.put("category", item.getCategory().name());
        obj.put("userId", item.getVerkäufer());
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
        .version(Version.HTTP_1_1)
        .uri(URI.create(BASE_URL + "/updateItem"))
        .header("Content-Type", "application/json")
        .POST(BodyPublishers.ofString(obj.toString()))
        .build();
        
        // send request
        HttpResponse<String> res = null;
        
        try {
            res = client.send(request, BodyHandlers.ofString());
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println(res.body());
        return new JSONObject(res.body()).getBoolean("success");
    } 
}
