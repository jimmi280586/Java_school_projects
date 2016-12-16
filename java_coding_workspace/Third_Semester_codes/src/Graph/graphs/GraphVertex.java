package graphs;



import graphs.doublyLinkedList.DLLNode;
import graphs.doublyLinkedList.DoublyLinkedList;
import graphs.doublyLinkedList.NodeIterator;

/**
* Graph ADT
* Coded by Amir El Bawab
* Date: 22 December 2014
* License: MIT License ~ Please read License.txt for more information about the usage of this software
* */
public class GraphVertex <E,T> implements Comparable<GraphVertex<E,T>>{

   // Vertex attributes
   private E data;
   private DoublyLinkedList<GraphEdge<E,T>> inEdges,outEdges;
   private DLLNode<GraphVertex<E,T>> position;
   private int status;
   private int color;
   private final int id;

   // Dijkstra options
   private GraphVertex<E,T> dijkstra_parent;
   private double dijkstra_value;
   private GraphEdge<E,T> dijkstra_edge;

   // Status
   public static final int UNVISITED = 0;
   public static final int VISITING = 1;
   public static final int VISITED = 2;

   // Colors
   protected static final int UNCOLORED = 0;

   /**
    * Constructor
    * @param data
    * @param id
    */
   protected GraphVertex(E data, int id) {
      this.data = data;
      this.status = UNVISITED;
      this.color = 0;
      this.id = id;
      inEdges = new DoublyLinkedList<GraphEdge<E,T>>();
      outEdges = new DoublyLinkedList<GraphEdge<E,T>>();
   }

   /**
    * Constructor
    * @param data
    */
   protected GraphVertex(E data) {
      this(data,0);
   }

   /**
    * Get neighbors of a node
    * @return array of the neighbor vertices
    */
   public GraphVertex<E,T>[] getNeighbors(){
      GraphVertex<E,T>[] neighbors = new GraphVertex[outEdges.size()];
      NodeIterator<GraphEdge<E,T>> iter = outEdges.iterator();
      int index = 0;
      GraphEdge<E,T> current = null;
      while(iter.hasNext()){
         current = iter.next();
         neighbors[index++] = current.getOpposite(this);
      }
      return neighbors;
   }

   /**
    * Get outEdges/incident edges
    * @return iterator on the out edges
    */
   public NodeIterator<GraphEdge<E,T>> getOutEdges(){
      return outEdges.iterator();
   }

   /**
    * Get inEdges edges
    * @return iterator on the in edges
    */
   public NodeIterator<GraphEdge<E,T>> getInEdges(){
      return inEdges.iterator();
   }

   /**
    * Store all out edges
    * @param e
    * @return node where the edge has been stored
    */
   protected DLLNode<GraphEdge<E,T>> addOutEdge(GraphEdge<E,T> e){
      return outEdges.add(e);
   }

   /**
    * Store all in edges
    * @param e
    * @return node where the edge has been stored
    */
   protected DLLNode<GraphEdge<E,T>> addInEdge(GraphEdge<E,T> e){
      return inEdges.add(e);
   }

   /**
    * Remove an in edge
    * @param node
    */
   protected void removeInEdge(DLLNode <GraphEdge<E,T>> node){
      inEdges.remove(node);
   }

   /**
    * Remove an out edge
    * @param node
    */
   protected void removeOutEdge(DLLNode <GraphEdge<E,T>> node){
      outEdges.remove(node);
   }

   /**
    * Get data stored in the vertex
    * @return data
    */
   public E getData() {
      return data;
   }

   /**
    * Get the node that stores this vertex
    * @return node
    */
   protected DLLNode<GraphVertex<E,T>> getPosition() {
      return position;
   }

   /**
    * Set the node that stores this vertex
    * @param position
    */
   protected void setPosition(DLLNode<GraphVertex<E,T>> position) {
      this.position = position;
   }

   /**
    * Set the data of this vertex
    * @param data
    */
   public void setData(E data) {
      this.data = data;
   }

   /**
    * Get vertex status
    * @return status
    */
   public int getStatus() {
      return status;
   }

   /**
    * Set vertex status
    * @param status
    */
   protected void setStatus(int status) {
      this.status = status;
   }

   /**
    * Get vertex color
    * @return color
    */
   public int getColor() {
      return color;
   }

   /**
    * Set vertex color
    * @param color
    */
   protected void setColor(int color) {
      this.color = color;
   }

   /**
    * Get vertex parent after calling Dijkstra method
    * @return parent of vertex
    */
   public GraphVertex<E,T> getDijkstra_parent() {
      return dijkstra_parent;
   }

   /**
    * Set the parent of a vertex when calling the Dijkstra method
    * @param dijkstra_parent
    */
   protected void setDijkstra_parent(GraphVertex<E,T> dijkstra_parent) {
      this.dijkstra_parent = dijkstra_parent;
   }

   /**
    * Get the accumulated edge weight when arriving to this vertex
    * @return accumulated value of a vertex
    */
   public double getDijkstra_value() {
      return dijkstra_value;
   }

   /**
    * Set the Dijkstra value of a vertex
    * @param dijkstra_value
    */
   protected void setDijkstra_value(double dijkstra_value) {
      this.dijkstra_value = dijkstra_value;
   }

   /**
    * Get the edge that connects this vertex to its parent
    * @return edge
    */
   public GraphEdge<E,T> getDijkstra_edge() {
      return dijkstra_edge;
   }

   /**
    * Set the edge that connects this vertex to its parent
    * @param dijkstra_edge
    */
   protected void setDijkstra_edge(GraphEdge<E,T> dijkstra_edge) {
      this.dijkstra_edge = dijkstra_edge;
   }

   /**
    * Get the vertex unique id
    * @return id
    */
   public int getID(){
      return id;
   }

   /**
    * Compare vertices by Dijkstra value
    * @param v
    */
   @Override
public int compareTo(GraphVertex<E,T> v) {
      if(v.getDijkstra_value() == getDijkstra_value())
         return 0;
      else if(v.getDijkstra_value() < getDijkstra_value())
         return 1;
      else
         return -1;
   }

   /**
    * Gives data as String
    */
   @Override
public String toString(){
      return String.format("<%s>", data.toString());
   }
}

