package module9;

public class MyArrayList <T> implements MyList<T>{
    private static final int DEFAULT_CAPACITY = 10;

    private Object[] array;
    private int size;

    public MyArrayList (){
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    //
    public void add(T value){
        isSizeOk();
        array[size++] = value;
    }

    public void add(int index,T value){
        if(this.size < index
                || index < 0){
            throw new IndexOutOfBoundsException("Index " + index +
                    " out of bounds for length " + size());
        }
        isSizeOk();
        Object [] newArray = new Object[array.length];
        System.arraycopy(array,0,newArray,0, index);
        newArray[index] = value;
        System.arraycopy(array,index,newArray,index+1, array.length-index-1);
        array = newArray;
        this.size++;
    }

    private void isSizeOk(){
        if (size == array.length -1){
            System.out.println("size = " + array.length);
            Object [] newArray = new Object[array.length + array.length/2];
            System.arraycopy(array,0,newArray,0, array.length);
            array = newArray;
            System.out.println("size = " + array.length);
        }
    }

    private void isIndexOk(int index){
        if(this.size <= index
                || index < 0){
            throw new IndexOutOfBoundsException("Index " + index +
                    " out of bounds for length " + size());
        }
    }

    public T remove (int index){
        isIndexOk(index);
        T toRemove = (T)array[index];
        Object [] withoutToRemove = new Object[array.length];
        System.arraycopy(array,0,withoutToRemove,0, index);
        System.arraycopy(array,index+1,withoutToRemove,index, array.length-index-1);
        array = withoutToRemove;
        this.size--;

        return toRemove;
    }

    public boolean remove (T value){
        boolean isT = false;
        int indexT = 0;
        for (int i = 0; i < size(); i++){
            if (array[i].equals(value)){
                isT = true;
                break;
            }
            indexT++;
        }
        if(isT){
            remove(indexT);
        }

        return isT;
    }

    public int size(){
        return size;
    }

    public T get(int index){
        isIndexOk(index);
        return (T)array[index];
    }

    public void clear(){
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public String toString() {
        int start = 0;
        StringBuilder sb = new StringBuilder("[");
        while (start < size){
            if (start == size -1){
                sb.append(array[start]);
                break;
            }
            sb.append(array[start++]).append(", ");
        }
        return sb.append("]").toString();
    }
}

class MyArrayListTest{
    public static  void main (String [] args){
//        MyArrayList <String> list = new MyArrayList<>();
//        System.out.println("list size before el add = " + list.size() +"\n");
//        list.add("Java");
//        list.add("is the");
//        list.add("best");
//        list.add("programming");
//        list.add("language");
//
//        System.out.println("list after elements add:");
//        System.out.println("your list: " + list);
//        System.out.println("list size after el add = " + list.size());
//
//        System.out.println("\nget list elements test: ");
//        for (int i = 0; i < list.size(); i++){
//            System.out.println(list.get(i));
//        }
//
//        System.out.println();
//        System.out.println("you removed - " + list.remove(3));
//        System.out.println("you removed - " + list.remove(list.size() - 1));
//        System.out.println("you removed - " + list.remove(0));
//
//        System.out.println("\nafter remove\nyour list: " + list);
//        System.out.println("list size after el remove = " + list.size());
//
//        list.clear();
//
//        System.out.println("\nafter clear\nyour list: " + list);
//        System.out.println("list size after clear = " + list.size());
//
//        for (int i = 0; i < list.size(); i++){
//            System.out.println(list.get(i));
//        }
//
//        System.out.println("\ntrying to remove element from empty list ");
//        try {
//            list.remove(0);
//        }catch (IndexOutOfBoundsException e){
//            System.out.println(e.getMessage());
//        }
//
//        System.out.println("\nfill list new elements, by index & value");
//        list.add(0,"Hello");
//        list.add("my");
//        list.add("name");
//        list.add("is");
//        list.add(4,"Eugene");
//        list.add(2,"first");
//        System.out.println("your list: " + list);
//        System.out.println("list size after el add = " + list.size());
//
//        System.out.println("\nremove elements by value");
//        System.out.println("is removing element in your list? - " + list.remove("first"));
//        System.out.println("is removing element in your list? - " + list.remove("false element"));
//        System.out.println("after remove\nyour list: " + list);
//        System.out.println("list size after el remove = " + list.size());

        MyList <String> list = new MyArrayList<>();
        list.add("My");
        System.out.println(list.remove(0));
        list.add("name");
        list.add("is");
        list.add("Eugene");
        list.add(1,"first");
        list.add(0,"it's all");
        list.add(0,"");
        list.add(6,"!");
        System.out.println(list);

    }
}
