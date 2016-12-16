package graphTest;


import java.io.FileNotFoundException;

import graphs.Graph;
import graphs.GraphVertex;

public class Controller {
   public static void main(String[] args) {
      try {
         Graph<String,String> graph = Graph.inParser("MIT.txt", true);

         System.out.println("Print graph state\n");
         System.out.println(graph);

         System.out.println("BFS:");
         for(GraphVertex<String,String> v : graph.BFS())
            System.out.print(v + " ");

         System.out.println("\n\nDFS");
         for(GraphVertex<String,String> v : graph.DFS())
            System.out.print(v + " ");

         System.out.println("\n\nIs connected: "+graph.isConnected());
         System.out.println("Is directed: "+graph.isDirected());
         System.out.println("Is cyclic: "+graph.isCyclic());
         System.out.println("Number of Connected components: "+graph.connectedComponents());

         System.out.println("\nClone graph ... ");
         Graph<String,String> cloned = graph.clone();

         System.out.println("Apply Transitive closure to the cloned graph");
         cloned.transitiveClosure();

         System.out.println("Print state of the new graph\n");
         System.out.println(cloned);

      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
   }
}

