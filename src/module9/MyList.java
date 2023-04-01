package module9;

public interface MyList<T> extends MyCollection<T>{
    void add(T value);
    public void add(int index,T value);
    Object remove(int index);
    Object get(int index);
}