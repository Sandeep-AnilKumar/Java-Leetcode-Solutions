package Graphs;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sandeepa
 */

public class DFS {
    public static void main(String[] args) {
        DFS dfsImplementation = new DFS();
        Node[] adjacencyList = new Node[7];

        for(int i = 0; i < 7; ++i) {
            adjacencyList[i] = new Node(i);
        }

        adjacencyList[0].addAdjacentNode(adjacencyList[1]);
        adjacencyList[0].addAdjacentNode(adjacencyList[2]);
        adjacencyList[0].addAdjacentNode(adjacencyList[4]);

        adjacencyList[1].addAdjacentNode(adjacencyList[0]);
        adjacencyList[1].addAdjacentNode(adjacencyList[2]);
        adjacencyList[1].addAdjacentNode(adjacencyList[5]);

        adjacencyList[2].addAdjacentNode(adjacencyList[0]);
        adjacencyList[2].addAdjacentNode(adjacencyList[1]);
        adjacencyList[2].addAdjacentNode(adjacencyList[3]);

        adjacencyList[3].addAdjacentNode(adjacencyList[2]);
        adjacencyList[3].addAdjacentNode(adjacencyList[5]);

        adjacencyList[4].addAdjacentNode(adjacencyList[0]);
        adjacencyList[4].addAdjacentNode(adjacencyList[5]);

        adjacencyList[5].addAdjacentNode(adjacencyList[1]);
        adjacencyList[5].addAdjacentNode(adjacencyList[3]);
        adjacencyList[5].addAdjacentNode(adjacencyList[4]);
        adjacencyList[5].addAdjacentNode(adjacencyList[6]);

        adjacencyList[6].addAdjacentNode(adjacencyList[5]);

        int[] parent = new int[7];
        for(int i = 0; i < 7; ++i) {
            parent[i] = -1;
        }

        int start = 0;
        PrintAdjacencyList.print(adjacencyList);
        dfsImplementation.dfs(adjacencyList, start, parent, -1);

        //DFS doesn't give the shortest path.
        for(int i = 1; i < 7; ++i) {
            System.out.print("The shortest path from " + start + " to " + i + " is := ");
            dfsImplementation.shortestPath(start, i, parent);
            System.out.println();
        }
    }

    public void dfs(int start, Node[] adjacencyList, int[] parent) {
        if(adjacencyList == null || adjacencyList.length == 0) return;
        Node cur = adjacencyList[start];

        if(!cur.isUnvisited()) return;

        cur.setVisiting();

        for(Node adjacent: cur.getAdjacentNodes()) {
            if(adjacent.isUnvisited()) {
                parent[adjacent.getValue()] = cur.getValue();
                dfs(adjacent.getValue(), adjacencyList, parent);
            }
        }

        cur.setVisited();
        return;
    }

    public void dfs(Node[] list, int cur, int[] parent, int prev) {
        if (list == null || list.length == 0) return;
        if (!list[cur].isUnvisited()) return;
        list[cur].setVisiting();
        parent[cur] = prev;

        for (Node next : list[cur].getAdjacentNodes()) {
            dfs(list, next.getValue(), parent, cur);
            list[cur].setVisited();
        }
    }

    public void dfsIterative(Node[] list, int cur, int[] parent, int prev) {
        if (list == null || list.length == 0) return;
        if (!list[cur].isUnvisited()) return;
        parent[cur] = prev;

        Node curNode = null;
        Deque<Node> dq = new ArrayDeque<>();
        dq.offer(list[cur]);

        while (!dq.isEmpty()) {
            curNode = dq.pollLast();
            if (curNode == null || !curNode.isUnvisited()) continue;

            curNode.setVisiting();
            for (Node next : curNode.getAdjacentNodes()) {
                if (next.isUnvisited()) {
                    parent[next.getValue()] = curNode.getValue();
                    dq.offer(next);
                }
            }
            curNode.setVisited();
        }
    }

    public void shortestPath(int start, int end, int[] parent) {
        if(start == end) return;

        if(parent[end] == start) {
            System.out.print(start + " -> " + end);
        } else {
            shortestPath(start, parent[end], parent);
            System.out.print(" -> " + end);
        }
        return;
    }
}
