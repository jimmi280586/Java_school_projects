package boundedBuffer.generic;

public class MyBoundedBufferUsingGenerics 
{
   public static void main (String [] args) {
     BoundedBuffer b1 = new BoundedBuffer(3);
     BoundedBuffer b2 = new BoundedBuffer(3);

     b1.add(new Element());
     b1.add(new Element());

     (new InOut1(b1,b2)).start();
     (new InOut2(b2,b1)).start();
   } 
}

class Element
{
	
}

/**
 * @observable 
 *   EXP Full: (head_ == tail_);
 *   EXP Empty:  head_ == ((tail_+1) % bound_);
 *   EXP IndexRange: (head_ >= 0 && tail_ >= 0 && head_ < bound_ && tail_ < bound_);
 */
class BoundedBuffer<T> {
   T [] buffer_;  
   int bound_;
   int head_, tail_;

   /**
    * @assert
    *   PRE PositiveBound: (b > 0);
    */
   public BoundedBuffer(int b) {
     bound_ = b;
     buffer_ = (T[]) new Element[bound_];
     head_ = 0;
     tail_ = bound_-1;
   }

   /**
    * @assert
    *   POST addPost: (head_==0) ? buffer_[bound_-1]==o : buffer_[head_-1]==o;
    * @observable
    *   INVOKE addInvoke;
    */
   public synchronized void add(T o) {
    while ( tail_ == head_ )
      try { wait(); } catch ( InterruptedException ex) {}

    buffer_[head_] = o;
    head_ = (head_+1) % bound_;
    notifyAll();
   }

   /**
    * @observable
    *   RETURN takeReturn;
    *   LOCATION[successTake] take;
    */
   public synchronized T take() { 
     while ( head_ == ((tail_+1) % bound_) )
       try { wait(); } catch ( InterruptedException ex) {}

     successTake:
     tail_ = (tail_+1) % bound_;
     notifyAll();
     return buffer_[tail_];
   }

   public synchronized boolean isEmpty() { return head_ == ((tail_+1) % bound_); }
}

class InOut1<T> extends Thread {
  BoundedBuffer in_,out_;
  public InOut1(BoundedBuffer in, BoundedBuffer out) {   
    in_ = in;
    out_ = out;
  }
  public void run() {
    T tmp;
    while(true) {
      tmp = (T) in_.take();
      System.out.println("Take 1");
      out_.add(tmp);
      System.out.println("Put 1");
    }
  }
}

class InOut2<T> extends Thread {
  BoundedBuffer in_,out_;
  public InOut2(BoundedBuffer in, BoundedBuffer out) {   
    in_ = in;
    out_ = out;
  }
  public void run() {
    T tmp;
    while(true) {
      tmp = (T) in_.take();
      System.out.println("Take 2");
      out_.add(tmp);
      System.out.println("Put 2");
    }
  }
}
