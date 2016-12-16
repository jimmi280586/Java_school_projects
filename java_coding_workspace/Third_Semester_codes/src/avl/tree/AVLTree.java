package tree;

public class AVLTree<E extends Comparable<? super E>>
{
   private AVLNode<E> rootAbove;

   public AVLTree()
   {
      rootAbove = new AVLNode<E>();
   }

   /**
    * @param rotateBase: The root of the subtree that is being rotated
    * @param rootAbove: The AVLNode that points to rotateBase
    *
    * This method rotates the subtree balancing it to within a margin of |1|.
    * */
   public void rotate(AVLNode<E> rotateBase, AVLNode<E> rootAbove){
        int balance = rotateBase.getBalance();

        if(Math.abs(balance) < 2){
            System.out.println("No rotate");
        }

        //gets the child on the side with the greater height
        AVLNode<E> child = (balance < 0) ? rotateBase.getLeft() : rotateBase.getRight();

        if(child == null)
            return;

        int childBalance = child.getBalance();
        AVLNode<E> grandChild = null;

        //both the child and grandchild are on the
        //left side, so rotate the child up to the root position
        if(balance < -1 && childBalance < 0){
             if(rootAbove != this.rootAbove && rootAbove.getRight() == rotateBase){
                 rootAbove.setRightNode(child);
             }
             else{
                 rootAbove.setLeftNode(child);
             }

             grandChild = child.getRight();
             child.setRightNode(rotateBase);
             rotateBase.setLeftNode(grandChild);
             return;
        }

        //both the child and the grandchild are on the
        //right side, so rotate the child up to the root position
        else if(balance > 1 && childBalance > 0){
            if(rootAbove != this.rootAbove && rootAbove.getRight() == rotateBase){
                 rootAbove.setRightNode(child);
            }
             else{
                 rootAbove.setLeftNode(child);
            }

             grandChild = child.getLeft();
             child.setLeftNode(rotateBase);
             rotateBase.setRightNode(grandChild);
             return;
        }

        //the child is on the left side, but the grandchild is on the
        //right side, so rotate the grandchild up to the child position
        //so the condition of the first if statement is satisfied,
        //then recurse to have the first if statement evaluated
        else if(balance < -1 && childBalance > 0){
            grandChild = child.getRight();
            rotateBase.setLeftNode(grandChild);
            child.setRightNode(grandChild.getLeft());
            grandChild.setLeftNode(child);
            rotate(rotateBase, rootAbove);
            return;
        }

        //the child is on the right side, but the grandchild is on the
        //left side, so rotate the grandchild up to the child position
        //so the condition of the second if statement is satisfied,
        //then recurse to have the second if statement evaluated
        else if(balance > 1 && childBalance < 0){
            grandChild = child.getLeft();
            rotateBase.setRightNode(grandChild);
            child.setLeftNode(grandChild.getRight());
            grandChild.setRightNode(child);
            rotate(rotateBase, rootAbove);
            return;
        }

   }

   /**
    * @param element: The element to insert into the Tree
    *
    * This method invokes a private helper method to insert the element.
    * It passes the root as the place to start.
    * */
   public void insert(E element){
       insert(element, rootAbove.getLeft());
   }

   /**
    * @param element: The element to insert into the Tree
    * @param temp: The AVLNode to evaluate for recursive insertion
    *
    * This method recursively traverses the Tree, inserting the
    * element at the appropriate spot and incrementing the balance
    * factors for the subtrees as it evaluates. The Tree will then
    * recursively rebalance as necessary.
    * */
   private void insert(E element, AVLNode<E> temp){
        if(this.rootAbove.getLeft() == null){
            this.rootAbove.setLeftNode(new AVLNode<E>(element));
            return;
        }

        //travel left or right based on the
        //comparison of element to temp.element
        //remember that left means that element <= temp.element
        //and right means element > temp.element
        int compare = element.compareTo(temp.getElement());


        //travel to the left of the Tree, inserting
        //if the bottom has been reached
        if(compare <= 0){

            //System.out.println(temp.getLeft());
            if(temp.getLeft() == null){
                temp.setLeft(element);
                return;
            }

            insert(element, temp.getLeft());
        }

        //otherwise, travelling to the right of the Tree,
        //inserting if the bottom has been reached
        else{

            if(temp.getRight() == null){
                temp.setRight(element);
                return;
            }

            insert(element, temp.getRight());

        }

        //if the root is being evaluated it, rotate if necessary
        if(temp == rootAbove.getLeft()){
              rotate(rootAbove.getLeft(), rootAbove);
        }

        //otherwise, rotate the left and right subtrees
        //as necessary
        if(temp.getLeft() != null){
            rotate(temp.getLeft(), temp);
        }

        if(temp.getRight() != null){
            rotate(temp.getRight(), temp);
        }


   } //end insert

   public void remove(E element)
   {
      remove(element, rootAbove);
   }

   /**
    * @param element: The element to remove from the AVLTree
    * @param temp: The root node of the subtree
    *
    * This method recursively traverses the AVLTree based on
    * the ordering of the element with respect to the Tree's
    * elements. If the element is not found, then nothing happens.
    * Otherwise, the element is removed, and either the far-right
    * element on its left child or the far left element on its right
    * child replaces it.
    ***/
   private void remove(E element, AVLNode<E> temp){
       if(temp == null)
            return;

        int compare = 0;

        if(temp != rootAbove)
            compare = element.compareTo(temp.getElement());

        boolean direction = (compare > 0 && temp != rootAbove);

        AVLNode<E> child = direction ? temp.getRight() : temp.getLeft();

        if(child == null)
            return;

       //if the root is perfectly balanced, slide the left Node up
       //and reinsert the left.right element if necessary
        if(temp == rootAbove && child.getBalance() == 0
                && child.getElement().equals(element)){

           AVLNode<E> newRoot = child.getLeft();

           if(newRoot == null){
               rootAbove.setLeftNode(null);
               return;
            }

          else{
              enactRemoval(temp, child, false);
              return;
          }
       }

        //if the element is found and the root is not
        // perfectly balanced, remove it using enactRemoval()
        else if(element.compareTo(child.getElement()) == 0){
            enactRemoval(temp, child, direction);
        }

        //otherwise, recursively traverse the tree
        else{
            remove(element, child);
        }

   }

   /**
    * @param parent: The parent of the element to be removed
    * @param remove: The element to remove from the Tree
    * @param direction: false if remove is to the left of parent, true otherwise
    *
    * This method physically removes the AVLNode with the element from the
    * AVLTree, replacing it with the appropriate successor.
    ***/
   private void enactRemoval(AVLNode<E> parent, AVLNode<E> remove, boolean direction){
       AVLNode<E> temp = null;
       AVLNode<E> left = remove.getLeft();
       AVLNode<E> right = remove.getRight();

       //if the Node to remove is not a leaf, find the appropriate successor
        if(left != null || right != null){
           temp = findSuccessor(remove);
        }

       //if remove is the right child of parent, update parent's right node
        if(direction && (parent != rootAbove)){
            parent.setRightNode(temp);
       }

       //otherwise, update its left node with the successor
        else
            parent.setLeftNode(temp);

       //and update temp to point to remove's children
        if(temp != null){

            if(temp != left){
                temp.setLeftNode(remove.getLeft());
            }

            if(temp != right){
                temp.setRightNode(remove.getRight());
            }
        }

        //and finally, discard those references from remove
       //so that the removed Node is garbage collected sooner
        remove.setLeftNode(null);
        remove.setRightNode(null);
   }

   /**
    * @param root: The element for which to find a successor AVLNode
    * @return AVLNode<E>: The successor Node
    ***/
   private AVLNode<E> findSuccessor(AVLNode<E> root){
        AVLNode<E> temp = root;
        AVLNode<E> parent = null;

        //if the balance favors the right, traverse right
        //otherwise, traverse left
        boolean direction = (temp.getBalance() > 0);

        parent = temp;
        temp = (direction) ? temp.getRight() : temp.getLeft();

        if(temp == null)
            return temp;

        //and find the farthest left-Node on the right side,
        //or the farthest right-Node on the left side
        while((temp.getRight() != null && !direction ) ||
              (temp.getLeft() != null && direction)){

              parent = temp;
              temp = (direction) ? temp.getLeft() : temp.getRight();
        }



       //finally, update the successor's parent's references
       //to adjust for a left child on the right node, or a right
        //child on the left-node
       if(temp == parent.getLeft()){
           parent.setLeftNode(temp.getRight());
           temp.setRightNode(null);
       }
       else{
           parent.setRightNode(temp.getLeft());
           temp.setLeftNode(null);
       }

       return temp;
   }


   /**
    * @param element: The element to search for in the AVLTree
    * @return boolean: true if the element is found, false otherwise
    *
    * The contains method simply traverses the binary search tree based on
    * element's relation to the AVLNodes in the Tree until a match is found
    * or it hits the bottom of the Tree.
    * */
   public boolean contains(E element){

       AVLNode<E> temp = rootAbove.getLeft();

       while(temp != null){
            if(temp.getElement().equals(element))
                return true;

            int balance = element.compareTo(temp.getElement());
            temp = (balance < 0) ? temp.getLeft() : temp.getRight();
       }

       return false;
   }

}
