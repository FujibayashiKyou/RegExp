package Task1;

import java.util.LinkedHashMap;

public class MapData {
    /*
     * Structure -> <PrimaryKey,<field,value>>
     */
    private LinkedHashMap<Integer, LinkedHashMap<String,String>> collection =
            new LinkedHashMap<Integer, LinkedHashMap<String,String>>();
    
    //Node, pair field - value
    private LinkedHashMap<String, String> node;
    
    private Integer primaryKey;

    MapData(){
        node = new LinkedHashMap<String,String>();
    }
    
    //Append the new node in Map
    public String addNode(String field, String value){
        node.put(field, value);
        return "The new node: FIELD: " + field + " VALUE: " + value + " has been append!";
    }
    
    //Clear old node
    private void newNode(){
        node = new LinkedHashMap<String,String>();
    }
    
    //Return node
    public LinkedHashMap<String, String> getNode(){
        return node;
    }
    
    public void addNodeToCollection(Integer id, LinkedHashMap<String,String> values){
        collection.put(id, values);
        newNode();
    }
    
    public void showCollection(){
        for(Integer id: collection.keySet()){
            System.out.println("ID: " + id + " values: " + collection.get(id));
        }
    }
   
    public LinkedHashMap<Integer, LinkedHashMap<String,String>> getCollection(){
        
        return collection;
    }
}
