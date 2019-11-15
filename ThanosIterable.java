import java.util.*;
public class ThanosIterable<T> implements Iterable<List<T>>{
  private List<T> list;
  public ThanosIterable(List<T> list){
    this.list = list;
  }
  public Iterator<List<T>> iterator(){
    return new ThanosIterator<T>(list);
  }
}