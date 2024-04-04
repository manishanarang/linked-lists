class TimeMap {
    Map<String, TreeMap<Integer, String>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        
        if(map.get(key) == null)return "";
        
        Integer floorKey = map.get(key).floorKey(timestamp);
        // Return searched time's value, if exists.
        if (floorKey != null) {
            return map.get(key).get(floorKey);
        }
        
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */