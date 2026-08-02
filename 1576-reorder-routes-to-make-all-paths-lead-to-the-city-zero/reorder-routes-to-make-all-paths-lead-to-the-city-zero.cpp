class Solution {
public:
    void dfs(int node, int parent, vector<bool>& visited,
             vector<vector<pair<int, int>>>& adj, int& count) {
        visited[node] = 1;

        for (int j = 0; j < adj[node].size(); j++) {
            int neigh = adj[node][j].first;
            int check = adj[node][j].second;
            if (neigh != parent) {
                if (check)
                    count++;
                if (!visited[neigh]) {
                    dfs(neigh, node, visited, adj, count);
                }
            }
        }
    }

    void bfs(int node, vector<bool>& visited,
             vector<vector<pair<int, int>>>& adj, int& count) {
        queue<int> q;
        q.push(0);
        visited[0] = 1;

        while (!q.empty()) {
            int node = q.front();
            q.pop();

            for (int j = 0; j < adj[node].size(); j++) {
                int neigh = adj[node][j].first;
                int check = adj[node][j].second;

                if (!visited[neigh]) {
                    if (check)
                        count++;
                    q.push(neigh);
                    visited[neigh] = 1;
                }
            }
        }
    }

    int minReorder(int n, vector<vector<int>>& connections) {
        vector<vector<pair<int, int>>> adj(n);
        for (auto& e : connections) {
            int u = e[0];
            int v = e[1];
            adj[u].push_back({v, 1});
            adj[v].push_back({u, 0});
        }

        int count = 0;
        vector<bool> visited(n, false);

        // dfs(0, -1, visited, adj, count);
        bfs(0, visited, adj, count);

        return count;
    }
};