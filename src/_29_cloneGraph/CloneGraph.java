/*
 * Cone an undirected graph. Each node in the graph contains a label and a list
 * of its neighbors.
 * There are two ways to traverse a graph: breath-first or depth-first. Let's
 * try the depth first, which is a recursion algorithm. Then we will look at the
 * breath-frist approach, which is an iterative algorithm that uses a queue.
 * 
 */
package _29_cloneGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 *
 * @author I300939
 */
public class CloneGraph {
   /* O(n) runtime, O(n) space - Depth-first traversal: 
      A graph is simply represented by a graph node that serves as its starting
      point. In fact, the starting point could be any other graph nodes, and it
      does not affect the clone algorithm. As each of it neighbors is a graph node
      too, we could recursively clone each of its neighbors and assign it to each
      neighbor of the cloned node. We can easily see that it is doing a depth first
      traversal of each node.
      Note that the graph could contain cycles, for example a node could have a
      neighbor that points back to it. Therefor, we should use a map that records
      each nodes' copy to avoid infinite recursion.
    */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode graph) {
        if (graph == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        return DFS(graph, map);
    }
    private UndirectedGraphNode DFS(UndirectedGraphNode graph, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
        if (map.containsKey(graph)) {
            return map.get(graph);
        }
        UndirectedGraphNode copy = new UndirectedGraphNode(graph.label);
        map.put(graph, copy);
        for (UndirectedGraphNode neighber : graph.neighbers) {
            copy.neighbers.add(DFS(neighber, map));
        }
        return copy;
    }
    
    /*
    Breadth-frist traversal: O(n) runtime, O(n) space
    How does the breath first traversal works? We pop a node off the queue, we
    copy each of its neighbors, and push them to the queue. We must take extra
    care to handle infinite loop. We could use a hash table to handle this. As
    we copy a node, we insert it into the table. If we later find that one of a
    node's neighbors is already in the table, we do not make a copy of that neighbor,
    but to push its neighbor's copy to its copy instread.
    */
    public UndirectedGraphNode cloneGroup(UndirectedGraphNode graph) {
        if (graph == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.add(graph);
        UndirectedGraphNode copy = new UndirectedGraphNode(graph.label);
        map.put(graph, copy);
        while (!q.isEmpty()) {
            UndirectedGraphNode node = q.poll();
            for (UndirectedGraphNode neighbor : node.neighbers) {
                if (map.containsKey(neighbor)) {
                    map.get(node).neighbers.add(map.get(neighbor));
                } else {
                    UndirectedGraphNode neighborCopy = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, neighborCopy);
                    map.get(node).neighbers.add(neighborCopy);
                    q.add(neighbor);
                }
            }
        }
        return copy;
    }
}

class UndirectedGraphNode {
    String label;
    List<UndirectedGraphNode> neighbers;
    public UndirectedGraphNode() {};
    public UndirectedGraphNode(String label) {
        this.label = label;
    }
}
