package com.dxn.graph.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class IterativeDFS {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    static class Pair {
        String psf;
        int src;

        Pair(int src, String psf) {
            this.src = src;
            this.psf = psf;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int vtces = Integer.parseInt(br.readLine());
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());

        // write your code here
        Stack<Pair> st = new Stack<>();
        boolean[] visited = new boolean[vtces];
        st.push(new Pair(src, src + ""));
        while (st.size() > 0) {
            Pair p = st.pop();
            if(!visited[p.src]) {
                visited[p.src] = true;
                System.out.println(p.src + "@" + p.psf);
                for (Edge e : graph[p.src]) {
                    if (!visited[e.nbr]) {
                        st.push(new Pair(e.nbr, p.psf + e.nbr));
                    }
                }
            }
        }
    }
}
