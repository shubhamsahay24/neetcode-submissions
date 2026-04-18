class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        // maintaing freq count {element->freq}
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        //return maxHeapApproach(k, map);
        
        return bucketSort(nums, k, map);
        
    }

    private int[] maxHeapApproach(int k, Map<Integer, Integer> map) {
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

    private int[] bucketSort(int[] nums, int k, Map<Integer, Integer> map) {
        // creating a bucket of n+1 lengths, will store elements on freq index (index as frequencies)
        List<Integer>[] bucket = new List[nums.length+1];
        for(int key : map.keySet()) {
            int freq = map.get(key);
            if(bucket[freq]==null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int[] res = new int[k];
        int ind=0;

        for(int i=bucket.length-1; i>=0 && ind<k; i--) {
            if(bucket[i]!=null) {
                for(int el : bucket[i]) {
                    res[ind++] = el;
                    if(ind==k) {
                        break;
                    }
                }
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
