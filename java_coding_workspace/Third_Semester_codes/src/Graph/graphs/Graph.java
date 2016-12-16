package graphs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* Graph ADT
* Coded by Amir El Bawab
* Date: 22 December 2014
* License: MIT License ~ Please read License.txt for more information about the usage of this software
* */
import graphs.doublyLinkedList.DLLNode;
import graphs.doublyLinkedList.DoublyLinkedList;
import graphs.doublyLinkedList.NodeIterator;

public class Graph <E,T> {

   // Graph content
   private DoublyLinkedList<GraphVertex <E,T>> GraphVertexList;
   private DoublyLinkedList<GraphEdge<E,T>> GraphEdgeList;

   // Graph options
   private boolean directed;
   private boolean isCyclic;
   private boolean isConnected;
   private int connectedComponents;

   // Unique id for each GraphVertex in a graph. In a cloned graph, cloned vertices will have the same id
   private int unique_id = 0;

   /**
    * Constructor
    * @param directed true if the graph is directed, false if undirected
    */
   public Graph(boolean directed) {
      GraphVertexList = new DoublyLinkedList<GraphVertex<E,T>>();
      GraphEdgeList = new DoublyLinkedList<GraphEdge<E,T>>();
      this.directed = directed;
   }

   /**
    * Add GraphVertex to the graph
    * @param data
    * @return Added GraphVertex
    */
   public GraphVertex<E,T> addGraphVertex(E data){
      return addGraphVertex(data, unique_id++);
   }

   /**
    * Add GraphEdge between two vertices
    * @param v1
    * @param v2
    * @param label
    * @param weight
    * @return Array of 2 GraphEdges if the graph is undirected, array of 1 GraphEdge if the graph is directed
    */
   public GraphEdge<E,T>[] addGraphEdge(GraphVertex<E,T> v1, GraphVertex<E,T> v2, T label, double weight){
      GraphEdge<E,T> GraphEdges[] = new GraphEdge[directed ? 1 : 2];

      // Create the first GraphEdge from v1 to v2 and set its configuration
      GraphEdges[0] = new GraphEdge<E,T>(v1, v2);
      GraphEdges[0].setLabel(label);
      GraphEdges[0].setWeight(weight);
      GraphEdges[0].setPosition(GraphEdgeList.add(GraphEdges[0]));

      // If graph is undirected, create an GraphEdge in the opposite direction
      if(!directed){

         // Create the second GraphEdge from v2 to v1 and set its configuration
         GraphEdges[1] = new GraphEdge<E,T>(v2, v1);
         GraphEdges[1].setLabel(label);
         GraphEdges[1].setWeight(weight);
         GraphEdges[1].setPosition(GraphEdgeList.add(GraphEdges[1]));
      }
      return GraphEdges;
   }

   /**
    * Add GraphEdge between two vertices
    * @param v1
    * @param v2
    * @return Array of 2 GraphEdges if the graph is undirected, array of 1 GraphEdge if the graph is directed
    */
   public GraphEdge<E,T>[] addGraphEdge(GraphVertex<E,T> v1, GraphVertex<E,T> v2){
      return addGraphEdge(v1, v2, null, 0.0);
   }

   /**
    * Remove GraphVertex
    * @param GraphVertex
    */
   public void removeGraphVertex(GraphVertex<E,T> GraphVertex){

      // Remove outgoing GraphEdges & trigger
      NodeIterator<GraphEdge<E,T>> iterOutGraphEdges = GraphVertex.getOutEdges();
      while(iterOutGraphEdges.hasNext()){
         GraphEdge<E,T> currentE = iterOutGraphEdges.next();
         GraphVertex<E,T> vTo = currentE.getV2();

         // Remove GraphEdge from inGraphEdge of V2
         vTo.removeInEdge(currentE.getIncidentPositionV2());

         // Remove GraphEdge from the graph content
         GraphEdgeList.remove(currentE.getPosition());
      }

      // Remove ingoing GraphEdges & trigger
      NodeIterator<GraphEdge<E,T>> iterInGraphEdges = GraphVertex.getInEdges();
      while(iterInGraphEdges.hasNext()){
         GraphEdge<E,T> currentE = iterInGraphEdges.next();
         GraphVertex<E,T> vFrom = currentE.getV1();

         // Remove GraphEdge from outGraphEdge of V1
         vFrom.removeOutEdge(currentE.getIncidentPositionV1());

         // Remove GraphEdge from the graph content
         GraphEdgeList.remove(currentE.getPosition());
      }

      // Remove GraphVertex
      GraphVertexList.remove(GraphVertex.getPosition());
   }

   /**
    * Remove GraphEdge
    * @param GraphEdge
    */
   public void removeGraphEdge(GraphEdge<E,T> GraphEdge){
      GraphEdge.getV1().removeOutEdge(GraphEdge.getIncidentPositionV1());
      GraphEdge.getV2().removeInEdge(GraphEdge.getIncidentPositionV2());
      GraphEdgeList.remove(GraphEdge.getPosition());
   }

   /**
    * Breadth-First-Search starting from a specific GraphVertex
    * @return Array of vertices traversed by BFS
    */
   public GraphVertex<E,T>[] BFS(GraphVertex<E,T> GraphVertex){

      // Mark all vertices as unvisited
      NodeIterator<GraphVertex<E,T>> iterV = vertices();
      while(iterV.hasNext())
         iterV.next().setStatus(graphs.GraphVertex.UNVISITED);

      // Mark all GraphEdges as undiscovered
      NodeIterator<GraphEdge<E,T>> iterE = GraphEdges();
      while(iterE.hasNext())
         iterE.next().setStatus(GraphEdge.UNDISCOVERED);

      // Create the list to store the vertices
      DoublyLinkedList<GraphVertex<E,T>> BFS_list = new DoublyLinkedList<>();

      // Add the starting GraphVertex and mark it as visiting
      Queue<GraphVertex<E,T>> q = new LinkedList<GraphVertex<E,T>>();
      q.add(GraphVertex);
      GraphVertex.setStatus(graphs.GraphVertex.VISITING);
      while(!q.isEmpty()){

         // Remove a GraphVertex from the queue and mark it as visited
         GraphVertex<E,T> polled = q.poll();
         BFS_list.add(polled);
         polled.setStatus(graphs.GraphVertex.VISITED);

         // Iterator on all neighbors of the removed GraphVertex and add them to the queue
         NodeIterator<GraphEdge<E,T>> incidentGraphEdges = polled.getOutEdges();
         while(incidentGraphEdges.hasNext()){
            GraphEdge<E,T> GraphEdge = incidentGraphEdges.next();
            GraphVertex<E,T> oppositeGraphVertex = GraphEdge.getV2();

            // If neighbor is not already visited, put it in the queue
            if(oppositeGraphVertex.getStatus() == graphs.GraphVertex.UNVISITED){

               // Mark GraphEdge between the removed GraphVertex and the current neighbor as discovered
               GraphEdge.setStatus(graphs.GraphEdge.DISCOVERED);
               oppositeGraphVertex.setStatus(graphs.GraphVertex.VISITING);
               q.offer(oppositeGraphVertex);

            // If neighbor has already been visited, don't put it in the queue
            }else{

               // Mark GraphEdge as cross if undiscovered
               if(GraphEdge.getStatus() == graphs.GraphEdge.UNDISCOVERED)
                  GraphEdge.setStatus(graphs.GraphEdge.CROSS);
            }
         }
      }

      NodeIterator<GraphVertex<E,T>> BFS_iter = BFS_list.iterator();
      GraphVertex<E,T> BFS[] = new GraphVertex[BFS_iter.size()];
      int index = 0;
      while(BFS_iter.hasNext())
         BFS[index++] = BFS_iter.next();
      return BFS;
   }

   /**
    * Breadth-First-Search
    * @return Array of vertices traversed by BFS
    */
   public GraphVertex<E,T>[] BFS(){
      GraphVertex<E,T>[] BFS = new GraphVertex[GraphVertexList.size()];
      int index = 0;

      // Mark all vertices as unvisited
      NodeIterator<GraphVertex<E,T>> iterV = vertices();
      while(iterV.hasNext())
         iterV.next().setStatus(GraphVertex.UNVISITED);

      // Mark all GraphEdges as undiscovered
      NodeIterator<GraphEdge<E,T>> iterE = GraphEdges();
      while(iterE.hasNext())
         iterE.next().setStatus(GraphEdge.UNDISCOVERED);

      // Start BFS
      iterV = vertices();
      while(iterV.hasNext()){
         GraphVertex<E,T> current = iterV.next();
         if(current.getStatus() == GraphVertex.UNVISITED){

            // Add the starting GraphVertex and mark it as visiting
            Queue<GraphVertex<E,T>> q = new LinkedList<GraphVertex<E,T>>();
            q.add(current);
            current.setStatus(GraphVertex.VISITING);
            while(!q.isEmpty()){

               // Remove a GraphVertex from the queue and mark it as visited
               GraphVertex<E,T> polled = q.poll();
               BFS[index++] = polled;
               polled.setStatus(GraphVertex.VISITED);

               // Iterator on all neighbors of the removed GraphVertex and add them to the queue
               NodeIterator<GraphEdge<E,T>> incidentGraphEdges = polled.getOutEdges();
               while(incidentGraphEdges.hasNext()){
                  GraphEdge<E,T> GraphEdge = incidentGraphEdges.next();
                  GraphVertex<E,T> oppositeGraphVertex = GraphEdge.getV2();

                  // If neighbor is not already visited, put it in the queue
                  if(oppositeGraphVertex.getStatus() == GraphVertex.UNVISITED){

                     // Mark GraphEdge between the removed GraphVertex and the current neighbor as discovered
                     GraphEdge.setStatus(graphs.GraphEdge.DISCOVERED);
                     oppositeGraphVertex.setStatus(GraphVertex.VISITING);
                     q.offer(oppositeGraphVertex);

                  // If neighbor has already been visited, don't put it in the queue
                  }else{

                     // Mark GraphEdge as cross if undiscovered
                     if(GraphEdge.getStatus() == graphs.GraphEdge.UNDISCOVERED)
                        GraphEdge.setStatus(graphs.GraphEdge.CROSS);
                  }
               }
            }
         }
      }
      return BFS;
   }

   /**
    * Depth-First-Search
    * @return Array of vertices traversed by DFS
    */
   public GraphVertex<E,T>[] DFS(){
      GraphVertex<E,T>[] DFS = new GraphVertex[GraphVertexList.size()];
      int index[] = {0};

      // Configure Graph options
      this.connectedComponents = 0;
      this.isCyclic = false;

      // Mark all vertices as unvisited and uncolored
      NodeIterator<GraphVertex<E,T>> iterV = vertices();
      while(iterV.hasNext()){
         GraphVertex<E,T> currentV = iterV.next();
         currentV.setStatus(GraphVertex.UNVISITED);
         currentV.setColor(GraphVertex.UNCOLORED);
      }

      // Mark all GraphEdges as undiscovered
      NodeIterator<GraphEdge<E,T>> iterE = GraphEdges();
      while(iterE.hasNext())
         iterE.next().setStatus(GraphEdge.UNDISCOVERED);

      // Start DFS
      iterV = vertices();
      while(iterV.hasNext()){
         GraphVertex<E,T> current = iterV.next();
         if(current.getStatus() == GraphVertex.UNVISITED){

            // +1 disconnected graph, trigger connection detection
            this.connectedComponents++;
            this.isConnected = this.connectedComponents == 1;
            DFS(current, DFS, index);
         }
      }
      return DFS;
   }

   /**
    * Recursive DFS that generates the content of DFS[]
    * @param v
    * @param DFS
    * @param index
    */
   private void DFS(GraphVertex<E,T> v, GraphVertex<E,T>[] DFS, int[] index){
      // Color all vertices with the same color for each GraphVertex start ((v0-> v1) <- v2) [for DiGraph]
      v.setColor(connectedComponents);
      v.setStatus(GraphVertex.VISITING);
      DFS[index[0]++] = v;

      // Iterate on all neighbors of the current GraphVertex
      NodeIterator<GraphEdge<E,T>> incidentGraphEdges = v.getOutEdges();
      while(incidentGraphEdges.hasNext()){
         GraphEdge<E,T> GraphEdge = incidentGraphEdges.next();
         GraphVertex<E,T> oppositeGraphVertex = GraphEdge.getV2();

         // Recur on neighbor if not visited
         if(oppositeGraphVertex.getStatus() == GraphVertex.UNVISITED){
            GraphEdge.setStatus(graphs.GraphEdge.DISCOVERED);
            oppositeGraphVertex.setStatus(GraphVertex.VISITING);
            DFS(oppositeGraphVertex, DFS,index);
         }else{

            // Checks if the undirected/directed graph is cyclic
            if(
                  (!directed && oppositeGraphVertex.getStatus() == GraphVertex.VISITED) ||
                  (directed && oppositeGraphVertex.getStatus() == GraphVertex.VISITING && v.getColor() == oppositeGraphVertex.getColor()) // Third condition is for DiGraph (Check earlier this method...)
            ){
               isCyclic = true;
            }

            /// Mark GraphEdge as cross if the undiscovered
            if(GraphEdge.getStatus() == graphs.GraphEdge.UNDISCOVERED)
               GraphEdge.setStatus(graphs.GraphEdge.CROSS);
         }
      }

      // Mark GraphVertex as visited if more neighbors needs to be visited
      v.setStatus(GraphVertex.VISITED);
   }

   /**
    * Depth-First-Search from a specific GraphVertex
    * @return Array of vertices traversed by DFS
    */
   public GraphVertex<E,T>[] DFS(GraphVertex<E,T> GraphVertex){

      // Mark all vertices as unvisited and uncolored
      NodeIterator<GraphVertex<E,T>> iterV = vertices();
      while(iterV.hasNext()){
         GraphVertex<E,T> currentV = iterV.next();
         currentV.setStatus(graphs.GraphVertex.UNVISITED);
         currentV.setColor(graphs.GraphVertex.UNCOLORED);
      }

      // Mark all GraphEdges as undiscovered
      NodeIterator<GraphEdge<E,T>> iterE = GraphEdges();
      while(iterE.hasNext())
         iterE.next().setStatus(GraphEdge.UNDISCOVERED);

      // Create the list to store the vertices
      DoublyLinkedList<GraphVertex<E,T>> DFS_list = new DoublyLinkedList<>();

      // Populate the list
      DFS(GraphVertex, DFS_list);

      // Create the return array
      NodeIterator<GraphVertex<E,T>> iter_DFS = DFS_list.iterator();
      GraphVertex<E,T> DFS[] = new GraphVertex[iter_DFS.size()];
      int index = 0;
      while(iter_DFS.hasNext())
         DFS[index++] = iter_DFS.next();

      return DFS;
   }

   /**
    * Recursive DFS that generates the content of DFS_list
    * @param GraphVertex
    * @param DFS_list
    */
   private void DFS(GraphVertex<E,T> GraphVertex, DoublyLinkedList<GraphVertex<E,T>> DFS_list){
      GraphVertex.setStatus(graphs.GraphVertex.VISITING);
      DFS_list.add(GraphVertex);

      // Iterate on all neighbors of the current GraphVertex
      NodeIterator<GraphEdge<E,T>> incidentGraphEdges = GraphVertex.getOutEdges();
      while(incidentGraphEdges.hasNext()){
         GraphEdge<E,T> GraphEdge = incidentGraphEdges.next();
         GraphVertex<E,T> oppositeGraphVertex = GraphEdge.getV2();

         // Recur on neighbor if not visited
         if(oppositeGraphVertex.getStatus() == graphs.GraphVertex.UNVISITED){
            GraphEdge.setStatus(graphs.GraphEdge.DISCOVERED);
            oppositeGraphVertex.setStatus(graphs.GraphVertex.VISITING);
            DFS(oppositeGraphVertex, DFS_list);
         }else{

            /// Mark GraphEdge as cross if the undiscovered
            if(GraphEdge.getStatus() == graphs.GraphEdge.UNDISCOVERED)
               GraphEdge.setStatus(graphs.GraphEdge.CROSS);
         }
      }

      // Mark GraphVertex as visited if more neighbors needs to be visited
      GraphVertex.setStatus(graphs.GraphVertex.VISITED);
   }

   /**
    * Get an iterator for the list of vertices
    * @return NodeIterator of vertices
    */
   public NodeIterator<GraphVertex<E,T>> vertices() {
      return GraphVertexList.iterator();
   }

   /**
    * Get an iterator for the list of GraphEdges
    * @return NodeIterator of GraphEdges
    */
   public NodeIterator<GraphEdge<E,T>> GraphEdges() {
      return GraphEdgeList.iterator();
   }

   /**
    * Get an array of the list of vertices
    * @return Array of vertices
    */
   public GraphVertex<E,T>[] vertices_array(){
      GraphVertex<E,T>[] tmp = new GraphVertex[GraphVertexList.size()];
      NodeIterator<GraphVertex<E,T>> iter = vertices();
      int index = 0;
      while(iter.hasNext())
         tmp[index++] = iter.next();
      return tmp;
   }

   /**
    * Get an array of the list of vertices
    * @return Array of vertices
    */
   public GraphEdge<E,T>[] GraphEdges_array(){
      GraphEdge<E,T>[] tmp = new GraphEdge[GraphEdgeList.size()];
      NodeIterator<GraphEdge<E,T>> iter = GraphEdges();
      int index = 0;
      while(iter.hasNext())
         tmp[index++] = iter.next();
      return tmp;
   }

   /**
    * Checks if the graph is directed or not
    * @return boolean
    */
   public boolean isDirected() {
      return directed;
   }

   /**
    * Checks if the graph contains a cycle
    * @return boolean
    */
   public boolean isCyclic(){
      DFS();
      return isCyclic;
   }

   /**
    * Checks if the graph is connected
    * @return boolean
    */
   public boolean isConnected(){
      if(directed)
         BFS_DiGraph_helper();
      else
         DFS();
      return isConnected;
   }

   /**
    * Gives the number of connected components
    * @return connected components
    */
   public int connectedComponents(){
      if(directed)
         BFS_DiGraph_helper();
      else
         DFS();
      return connectedComponents;
   }

   /**
    * Create the shortest path from a GraphVertex to all other vertices
    * @param v Starting GraphVertex
    */
   public void dijkstra(GraphVertex<E,T> v){

      // Mark all vertices as unvisited and reset Dijkstra options
      NodeIterator<GraphVertex<E,T>> iterV = vertices();
      while(iterV.hasNext()){
         GraphVertex<E,T> currentV = iterV.next();
         currentV.setStatus(GraphVertex.UNVISITED);
         currentV.setDijkstra_value(Double.MAX_VALUE);
         currentV.setDijkstra_parent(null);
      }

      // Mark all GraphEdges as undiscovered
      NodeIterator<GraphEdge<E,T>> iterE = GraphEdges();
      while(iterE.hasNext())
         iterE.next().setStatus(GraphEdge.UNDISCOVERED);

      // Mark the starting GraphVertex
      v.setDijkstra_value(0);

      // Create the Priority Queue (Using a heap)
      PriorityQueue<GraphVertex<E,T>> pq = new PriorityQueue<>();

      // Start from the starting GraphVertex by putting it in the Priority queue
      pq.offer(v);
      v.setStatus(GraphVertex.VISITING);
      v.setDijkstra_parent(v);
      while(!pq.isEmpty()){

         // Remove the GraphVertex with minimum Dijkstra value
         GraphVertex<E,T> polled = pq.poll();
         v.setStatus(GraphVertex.VISITED);
         NodeIterator<GraphEdge<E,T>> incidentGraphEdges = polled.getOutEdges();

         // Put all the neighbors of the removed GraphVertex in the Priority queue and adjust their Dijkstra value and parent
         while(incidentGraphEdges.hasNext()){
            GraphEdge<E,T> GraphEdge = incidentGraphEdges.next();
            GraphVertex<E,T> oppositeGraphVertex = GraphEdge.getV2();
            double pathCost = GraphEdge.getWeight() + polled.getDijkstra_value();

            // If the neighbor has not been visited, mark it visiting and adjust its configuration
            if(oppositeGraphVertex.getStatus() == GraphVertex.UNVISITED){
               oppositeGraphVertex.setDijkstra_value(pathCost);
               oppositeGraphVertex.setDijkstra_edge(GraphEdge);
               GraphEdge.setStatus(graphs.GraphEdge.DISCOVERED);
               oppositeGraphVertex.setStatus(GraphVertex.VISITING);
               oppositeGraphVertex.setDijkstra_parent(polled);
               pq.offer(oppositeGraphVertex);

            // If the neighbor is still in the priority queue, check for minimum path cost, adjust if the cost can be reduced
            }else if(oppositeGraphVertex.getStatus() == GraphVertex.VISITING){

               if(oppositeGraphVertex.getDijkstra_value() > pathCost){
                  oppositeGraphVertex.setDijkstra_value(pathCost);
                  GraphEdge.setStatus(graphs.GraphEdge.DISCOVERED);
                  oppositeGraphVertex.setDijkstra_parent(polled);
                  oppositeGraphVertex.getDijkstra_edge().setStatus(graphs.GraphEdge.FORWARD); // Mark previous GraphEdge as FORWARD
                  oppositeGraphVertex.setDijkstra_edge(GraphEdge); // Update GraphEdge that makes it shortest path
               }
            }
         }
      }
   }

   /**
    * Get the shortest path from one GraphVertex to another
    * @param vFrom
    * @param vTo
    * @return Array of shortest GraphEdges to go from vFrom to vTo
    */
   public GraphEdge<E,T>[] dijkstra(GraphVertex<E,T> vFrom, GraphVertex<E,T> vTo){
      this.dijkstra(vFrom);
      Stack<GraphEdge<E,T>> path = new Stack<>();
      GraphVertex<E,T> current = vTo;

      // Push the path in the stack in backward direction
      while(current.getDijkstra_edge() != null){
         path.push(current.getDijkstra_edge());
         current = current.getDijkstra_parent();
      }

      // Store path, in the correct direction, in an array
      GraphEdge<E,T>[] GraphEdges = new GraphEdge[path.size()];
      int index =  0;
      while(!path.isEmpty())
         GraphEdges[index++] = path.pop();
      return GraphEdges;
   }

   /**
    * Checks if two vertices are adjacent
    * @param v1 From
    * @param v2 To
    * @return boolean
    */
   public boolean areAdjacent(GraphVertex<E,T> v1, GraphVertex<E,T> v2){

      // If directed graph or size of v1 out GraphEdges < size of v2 out GraphEdges
      GraphVertex<E,T> v = directed || (v1.getOutEdges().size() < v2.getOutEdges().size()) ? v1 : v2;

      NodeIterator<GraphEdge<E,T>> iterOutE = v.getOutEdges();
      while(iterOutE.hasNext())
         if( (v == v1 && iterOutE.next().getV2() == v2) || (v == v2 && iterOutE.next().getV2() == v1) )
            return true;
      return false;
   }

   /**
    * Transitive Closure by Floyd–Warshall
    * Idea: if (i->k->j) then create (i->j) if doesn't already exist
    */
   public void transitiveClosure(){
      GraphVertex<E,T> vertices[] = this.vertices_array();
      for(int k = 0; k < vertices.length; k++){
         for(int i = 0; i < vertices.length; i++){
            // If i = k, then skip
            if(i == k) continue;

            // If i and k are adjacent, check for k and j
            if(areAdjacent(vertices[i], vertices[k])){
               for(int j = 0; j < vertices.length; j++){
                  // If j = i or j = k, then skip
                  if(j == i || j == k) continue;

                  // If k and j are adjacent AND i and j are not adjacent, create an GraphEdge between i and j
                  if(areAdjacent(vertices[k], vertices[j]) && !areAdjacent(vertices[i], vertices[j]))
                     this.addGraphEdge(vertices[i],vertices[j], null, 0.0);
               }
            }
         }
      }
   }

   /**
    * Clone vertices and GraphEdges, but does not clone the data of the GraphVertex
    * @return cloned graph
    */
   @Override
public Graph<E,T> clone(){

      // Create new graph, (To avoid GraphEdge duplication the graph is marked directed, but adjusted at the end)
      Graph<E,T> graph = new Graph<E,T>(true);

      // Clone Vertices
      NodeIterator<GraphVertex<E,T>> iterV = GraphVertexList.iterator();
      while(iterV.hasNext()){
         GraphVertex<E,T> GraphVertex = iterV.next();
         graph.addGraphVertex(GraphVertex.getData(), GraphVertex.getID());
      }

      // Store vertices in an array so we can clone using unique id and indices
      GraphVertex<E,T> vertices[] = graph.vertices_array();

      // Clone GraphEdges
      NodeIterator<GraphEdge<E,T>> iterE = GraphEdgeList.iterator();
      while(iterE.hasNext()){
         GraphEdge<E,T> currentE = iterE.next();

         // Binary search is used because the ID are sorted in ascending order
         // Note: Searching for vertices is required because any GraphVertex can be removed, and gaps in IDs will be formed
         GraphVertex<E,T> v1 = vertices[getIndexOfGraphVertexByID(vertices, currentE.getV1().getID())];
         GraphVertex<E,T> v2 = vertices[getIndexOfGraphVertexByID(vertices, currentE.getV2().getID())];
         graph.addGraphEdge(v1, v2, currentE.getLabel(), currentE.getWeight());
      }

      // Adjust the directed/undirected graph option and unique id counter
      graph.directed = directed;
      graph.unique_id = unique_id;

      return graph;
   }

   /**
    * Gives all the vertices and GraphEdges that form this graph
    * @return String
    */
   @Override
public String toString(){
      String output = "Vertices:\n";
      for(GraphVertex<E,T> v : vertices_array())
         output += String.format("%s ", v.toString());

      output += "\n\nGraphEdges:\n";

      for(GraphEdge<E,T> e : GraphEdges_array()){
         output += String.format("%s\n", e.toString());
      }
      return output;
   }

   //////////////////////////// I/O /////////////////////////////

   /**
    * Read graph from input
    * @param fileName
    * @param directed
    * @return Graph created
    * @throws FileNotFoundException
    */
   public static Graph<String,String> inParser (String fileName, boolean directed) throws FileNotFoundException{
      Graph<String,String> graph = new Graph<String,String>(directed);

      Scanner scan = new Scanner(new File(fileName));
      String readLine;
      Pattern pattern;
      Matcher matcher;

      readLine = scan.nextLine();
      pattern = Pattern.compile("size\\s*=\\s*(\\d+)");
      matcher = pattern.matcher(readLine);
      matcher.find();
      GraphVertex<String,String> vertices[] = new GraphVertex[Integer.parseInt(matcher.group(1))];

      while(!(readLine = scan.nextLine()).equals(";") ){
         pattern = Pattern.compile("([^0-9]*)\\s*(\\d+)\\s*=\\s*(.*)");
         matcher = pattern.matcher(readLine);
         matcher.find();
         if(matcher.group(1) == null || matcher.group(1).isEmpty()){
            vertices[Integer.parseInt(matcher.group(2))] = graph.addGraphVertex(matcher.group(3));
         }else if(matcher.group(1).trim().equals("//") || matcher.group(1).trim().equals("#")){
            continue;
         }else{
            throw new InputMismatchException();
         }
      }

      while(!(readLine = scan.nextLine()).equals(";") ){
         pattern = Pattern.compile("(.*)\\s*\\(\\s*(\\d+)\\s*,\\s*(\\d+)\\s*(,\\s*(\\d+|\\d+\\.\\d+)\\s*)?\\)(\\s*=\\s*(.*))?");
         matcher = pattern.matcher(readLine);
         matcher.find();
         if(matcher.group(1) == null || matcher.group(1).isEmpty()){
            double weight = 0.0;
            int v1Index = Integer.parseInt(matcher.group(2));
            int v2Index = Integer.parseInt(matcher.group(3));
            if(matcher.group(5) != null)
               weight = Double.parseDouble(matcher.group(5));
            String label = matcher.group(7);

            graph.addGraphEdge(vertices[v1Index], vertices[v2Index], label, weight);
         }else if(matcher.group(1).trim().equals("//") || matcher.group(1).trim().equals("#")){
            continue;
         }else{
            throw new InputMismatchException();
         }
      }
      return graph;
   }

/////////////////////////////// HELPER ////////////////////////////////

   /**
    * BFS for detecting connected components and is connected in DiGraphs
    * Idea is to consider the DiGraph as UnDiGraph by concatenating the in and out GraphEdges
    */
   private GraphVertex<E,T>[] BFS_DiGraph_helper() {
      GraphVertex<E,T>[] BFS = new GraphVertex[GraphVertexList.size()];
      int index = 0;

      // Configure DiGraph options
      this.connectedComponents = 0;

      // Mark all vertices as unvisited
      NodeIterator<GraphVertex<E,T>> iterV = vertices();
      while (iterV.hasNext())
         iterV.next().setStatus(GraphVertex.UNVISITED);

      // Mark all GraphEdges as undiscovered
      NodeIterator<GraphEdge<E,T>> iterE = GraphEdges();
      while (iterE.hasNext())
         iterE.next().setStatus(GraphEdge.UNDISCOVERED);

      // Start BFS
      iterV = vertices();
      while (iterV.hasNext()) {
         GraphVertex<E,T> current = iterV.next();
         if (current.getStatus() == GraphVertex.UNVISITED) {

            // +1 disconnected graph, trigger connection detection
            this.connectedComponents++;
            this.isConnected = this.connectedComponents == 1;

            Queue<GraphVertex<E,T>> q = new LinkedList<GraphVertex<E,T>>();
            q.add(current);
            current.setStatus(GraphVertex.VISITING);
            while (!q.isEmpty()) {
               GraphVertex<E,T> polled = q.poll();
               BFS[index++] = polled;
               polled.setStatus(GraphVertex.VISITED);

               NodeIterator<GraphEdge<E,T>> inOutGraphEdges = polled.getOutEdges().concatenate(polled.getInEdges());
               while (inOutGraphEdges.hasNext()) {
                  GraphEdge<E,T> GraphEdge = inOutGraphEdges.next();
                  GraphVertex<E,T> oppositeGraphVertex = GraphEdge.getOpposite(polled);
                  if (oppositeGraphVertex.getStatus() == GraphVertex.UNVISITED) {
                     GraphEdge.setStatus(graphs.GraphEdge.DISCOVERED);
                     oppositeGraphVertex.setStatus(GraphVertex.VISITING);
                     q.offer(oppositeGraphVertex);
                  } else {
                     if (GraphEdge.getStatus() == graphs.GraphEdge.UNDISCOVERED)
                        GraphEdge.setStatus(graphs.GraphEdge.CROSS);
                  }
               }
            }
         }
      }
      return BFS;
   }

   /**
    * Binary search for finding the index of a GraphVertex in an array of vertices using the GraphVertex unique id
    * @param array
    * @param target
    * @return index of target GraphVertex or -1 if GraphVertex not found
    */
   public int getIndexOfGraphVertexByID(GraphVertex<E,T>[] vertices, int id){
      int left = 0;
      int right = vertices.length-1;
      int mid;
      while(left <= right){
         mid = (left + right) / 2;
         if(vertices[mid].getID() == id)
            return mid;
         if(vertices[mid].getID() < id)
            left = mid + 1;
         else
            right = mid - 1;
      }
      return -1;
   }

   /**
    * Add GraphVertex to the graph with custom ID
    * Private to avoid possible conflict if used manually
    * @param data
    * @return GraphVertex
    */
   private GraphVertex<E,T> addGraphVertex(E data, int id){
      GraphVertex<E,T> GraphVertex = new GraphVertex<E,T>(data, id);
      DLLNode<GraphVertex<E,T>> node = GraphVertexList.add(GraphVertex);
      GraphVertex.setPosition(node);
      return GraphVertex;
   }
}
