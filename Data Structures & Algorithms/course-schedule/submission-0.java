class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();

        int[] indegree = new int[numCourses];

        for(int i=0; i<numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int i=0 ; i<prerequisites.length; i++) {
            // creating adjList {vetex->neighbours}
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]); 
            // calculaing indegree
            indegree[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<numCourses; i++) {
            if(indegree[i]==0)
                queue.add(i);
        }
        int courseFinished=0;
        while(!queue.isEmpty()) {
            int course = queue.poll();
            courseFinished++;
            adjList.get(course).stream().forEach(v -> {
                indegree[v]--;
                if(indegree[v]==0)
                    queue.add(v);
            });
        }

        if(courseFinished==numCourses)
            return true;

        return false;
    }

    // 
}
