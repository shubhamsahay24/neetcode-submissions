class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        // maintaing freq count {element->freq}
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.freq-a.freq);
        // Descending order acc. to freq
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }

        int[] res = new int[k];
        int ind = 0;
        while(!pq.isEmpty()) {
            Pair p = pq.peek();
            pq.poll();
            if(k>0) {
                res[ind++] = p.value;
                k--;
            } else {
                break;
            }
        }
        return res;
        
    }

    class Pair {
        int value;
        int freq;
        Pair(int a, int b) {
            value = a;
            freq = b;
        }
    }
}
