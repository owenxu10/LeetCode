// 261. Graph Valid Tree

// Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), 
// write a function to check whether these edges make up a valid tree.

// Example 1:
// Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
// Output: true

// Example 2:
// Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
// Output: false

// Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0,1] is the same as [1,0] and thus will not appear together in edges.

//DFS
class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
          graph.add(i, new ArrayList<Integer>());
        }

        for (int i = 0; i < edges.length; i++) {
          graph.get(edges[i][0]).add(edges[i][1]);
          graph.get(edges[i][1]).add(edges[i][0]);
        }

        Set visited = new HashSet();
        if (!dfs(visited, graph, -1, 0))
          return false;

        return visited.size() == n;
    }

    public boolean dfs(Set visited, List<List<Integer>> graph, int parent, int current) {
        visited.add(current);
        List<Integer> adj = graph.get(current);
        for (int i = 0; i < adj.size(); i++) {
            if (parent == adj.get(i))
                continue;
          if (visited.contains(adj.get(i)) ) {
            return false;
          }
          if (!dfs(visited, graph, current, adj.get(i)))
            return false;
        }
        return true;
    }
}

//union find
class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] uf = new int[n];
        for (int i = 0; i < n; i++) {
            uf[i] = -1;
        }
        
        for (int i = 0; i < edges.length; i++) {
            int x = find(uf, edges[i][0]);
            int y = find(uf, edges[i][1]);
            
            if (x == y) return false;
            uf[x] = y;
        }
        
        return edges.length == n-1;
    }
    
    public int find(int[] uf,int num) {
        if (uf[num] == -1) return num;
        else return find(uf, uf[num]);
    }
}