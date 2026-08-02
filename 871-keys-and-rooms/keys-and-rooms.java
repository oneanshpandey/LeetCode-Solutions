class Solution {
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();

        // List<List<Integer>>graph = new ArrayList<>();
        boolean[]ans = new boolean[n];
        dfs(0 , ans , rooms);
        for(boolean b : ans){
            if(!b){
                return false;
            }
        }
        return true;
    }

    public static void dfs(int vertex , boolean[]vis , List<List<Integer>>graph){
        vis[vertex]=true;
        List<Integer>list = graph.get(vertex);
        for(int i : list){
            if(vis[i]==false){
                dfs(i , vis , graph);
            }
        }
    }
}