import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.ListIterator;
import java.util.Comparator;
public class CollectionsMess{
  public static int shortSort(Integer [] array){
    int leftIndex = array.length;
    int rightIndex = 0;
    ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
    int result;
    for(int i = 0; i<array.length; i++){
      while(!stack.isEmpty() && array[stack.peekLast()]<array[i]){
        leftIndex = Math.min(leftIndex,stack.removeLast());
      }
      stack.addLast(i);
    }
    for(int i = array.length-1; i>=0; i--){
      while(!stack.isEmpty() && array[stack.peekLast()]<array[i]){
        rightIndex = Math.max(rightIndex,stack.removeLast());
      }
      stack.addLast(i);
    }
    result = rightIndex - leftIndex;
    if(result > 0){
      return result+1;
    }else{
      return 0;
    }
  }
  
  public int[][] closest(int k, Integer[][] points){
    int[][] result = new int[k][2];
    distComp d1 = new distComp();
    PriorityQueue<Distance> pq = new PriorityQueue<Distance>(d1);
    for(int i = 0; i<points.length; i++){
      Distance d = new Distance(points[i][0],points[i][1]);
      pq.add(d);
    }
    for(int i = 0; i<=k;i++){
      Distance d = pq.peek();
      result[i] = new int[]{d.x, d.y};
    }
    return result;
  }
  public static void main(String [] args){
    Integer[] array = new Integer[]{2, 4, 6, 8,9, 10, 15};
    System.out.println(shortSort(array));
    Integer[][] array2 = new Integer[][]{};
  }
  public class Distance{
    public Integer x;
    public Integer y;
    public Integer distance;
    public Distance(int x, int y){
      this.x = x;
      this.y = y;
      this.distance = (x*x) + (y*y);
    }
  }
  public class distComp implements Comparator<Distance>{
    @Override
    public int compare(Distance d1, Distance d2){
      return d1.distance - d2.distance;
    }
  }
}

