class Solution {

    Map<String, List<String>> map = new HashMap<>();
    int keyCount = 0;

    public String encode(List<String> strs) {
        String key = "key" + (keyCount++);
        map.put(key, strs);
        return key;
    }

    public List<String> decode(String str) {
        return map.get(str);
    }
}
