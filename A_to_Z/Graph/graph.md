## Theory 

- What is Graph?
- What are vertices and edges?
- What are the types of graphs available?
- What is a cyclic and acyclic graph?
- What is the time complexity of BFS and DFS?
- When to use DFS and BFS?

## Order of the Graph problems

Si.No, Problem Name, Link to the problem, (Approach/Method), [Time Complexity, Space Complexity]  
NOTE: Space Complexity for the return type is not considered.

Tips:- 
| Algorithm | Undirected Graph | Directed Graph |
| --------- | ---------------- | -------------- |
| **BFS**   | O(V + E)         | O(V + E)       |
| **DFS**   | O(V + E)         | O(V + E)       |


1. Graph Creation  
2. BFS [https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1]  
3. DFS [https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1]  
4. Find all path source target [https://leetcode.com/problems/all-paths-from-source-to-target/description/] (DFS)  
5. Number of Islands [https://leetcode.com/problems/number-of-islands/] (DFS)  
6. Number of Islands in GG [https://www.geeksforgeeks.org/problems/find-the-number-of-islands/1] (DFS)  
7. Flood Fill [https://leetcode.com/problems/flood-fill/submissions/] (DFS)  
8. Bipartite Graph [https://leetcode.com/problems/is-graph-bipartite/submissions/] (DFS) [O(V+E),O(V)]  
9. Word Search [https://leetcode.com/problems/word-search/description/] (DFS) [O(N*M*4^L),O(L)]  
10. Connected Components [https://www.geeksforgeeks.org/problems/connected-components-in-an-undirected-graph/1] (DFS) [O(E+V),O(E+V)]  
11. No. of Complete Components [https://leetcode.com/problems/count-the-number-of-complete-components/description/] (DFS) [O(E+V),O(E+V)]  
12. Number of Provinces [https://leetcode.com/problems/number-of-provinces/submissions/] (DFS) [O(E+V),O(E+V)]  
13. Surrounded Regions [https://leetcode.com/problems/surrounded-regions/description/] (DFS) [O(N*M),O(N*M)]
14. Number of Enclaves [https://leetcode.com/problems/number-of-enclaves/description/] (DFS) [O(N*M),O(N*M)]
15. Word Ladder - I [https://leetcode.com/problems/word-ladder/description/] (BFS) [O(N*L*26),O(N)]
16. Rotten Oranges [https://leetcode.com/problems/rotting-oranges/description/] (BFS)  [O(N*M),O(N*M)]
17. Cycle Detection in Undirected Graph [https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1] (DFS) [O(V+E),O(V+E)]
18. Cycle Detection in Undirected Graph [https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1] (BFS) [O(V+E),O(V+E)]
19. Topological Sort & Kahn's Algo [https://takeuforward.org/data-structure/kahns-algorithm-topological-sort-algorithm-bfs-g-22/] (BFS) [O(V+E),O(N)]
20. Course Schedule I [https://leetcode.com/problems/course-schedule/description/] (Topological Sort)  [O(V+E),O(V+E)]
21. Course Schedule II [https://leetcode.com/problems/course-schedule-ii/description/] (Topological Sort) [O(V+E),O(V+E)]
22. Find Eventual Safe States [https://leetcode.com/problems/find-eventual-safe-states/description/] (Topological Sort/DP)  [O(V+E),O(V+E)]
23. Alien Dictionary [https://www.geeksforgeeks.org/problems/alien-dictionary/1] (Topological Sort)  [O(L*N),O(C+E)]
24. Dijkstra's Algorithm  [https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1] (BFS) [O(E*log*V),O(V)]
25. Shortest Path in Directed Graph [https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1](Dijkstra) [(E*log*V),O(V)]
26. Shortest Path in Binary Maze [https://leetcode.com/problems/shortest-path-in-binary-matrix/description/] (Dijkstra)  [O(N^2*log*N),O(N^2)]
27. Path with Minimum Effort [https://leetcode.com/problems/path-with-minimum-effort/description/] (Dijkstra)  [O(n*mlog(n*m)),O(n*m)]
28. Cheapest Flights within K Stops (Dijkstra without visited array and PriorityQueue)  
29. Network Delay Time [https://leetcode.com/problems/network-delay-time/description/] (Dijkstra)  [O(E*logV),O(V)]
30. Number of Ways to Arrive at Destination [https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/](Dijkstra)  [O(E*logV),O(V)]
31. Minimum Multiplications to Reach End [https://www.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1](Dijkstra)  [O(MOD*N*logMOD),O(MOD)]
32. Bellman Ford Algo 
33. Floy Warshal Algo 
34. Find the City With the Smallest Number of Neighbors at a Threshold Distance (Floyd-Warshall Algorithm)


# Tips and Tricks 

- When ever it's about finding total path / all possible path go with the DFS 
- When ever it's about finding the minimum path go with the BFS
- During the BFS if ( remove -> work -> add ) lead to TLE then operate work during the add itself.