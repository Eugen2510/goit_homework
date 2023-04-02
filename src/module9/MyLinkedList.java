package module9;

public class MyLinkedList<T> implements MyList<T>{
    private int size;
     Node <T> first;
     Node <T> last;
    @Override
    public void clear(){
        first = last = null;
        size = 0;
    }
    @Override
    public int size(){
        return size;
    }

    public void add(T element){
        Node <T> newNode = new Node<>(element);
        if(isEmpty()){
            first = newNode;
        }else {
            newNode.setPrev(last);
            last.setNext(newNode);
        }
        last = newNode;
        size++;
    }

    public void addFirst(T value){
        Node <T> newNode = new Node<>(value);
        if (isEmpty()){
            last = newNode;
        }else {
            newNode.setNext(first);
            first.setPrev(newNode);
        }
        first = newNode;
        size++;
    }

    @Override
    public void add(int index, T value) {
        if (index == size){
            add(value);
            return;
        }
        throwException(index);
        Node<T> newNode = new Node<>(value);
        Node<T> current = getNode(index);
            if(index == 0){
                addFirst(value);
                size--;
            }else {
                newNode.setPrev(current.getPrev());
                newNode.setNext(current);
                current.getPrev().setNext(newNode);
                current.setPrev(newNode);
            }

        size++;
    }
    @Override
    public T remove(int index){
        throwException(index);
        Node<T> current = getNode(index);
        T value = current.getElement();
        if(size == 1){
            clear();
            return value;
        }

        if (current == first){
            first = first.getNext();
            first.setPrev(null);
            size--;
            return value;
        }

        if(current == last){
            last.getPrev().setNext(null);
        } else {
            current.getNext().setPrev(current.getPrev());
            current.getPrev().setNext(current.getNext());

        }

        size--;

        return value;
    }
    @Override
    public T get(int index){
        throwException(index);
        return getNode(index).getElement();
    }

    private boolean isEmpty(){
        return size == 0;
    }


    private boolean isIndexOk(int index){
        return index >= 0 && index < size;
    }

    private void throwException(int index){
        if(!isIndexOk(index)){
            throw new IndexOutOfBoundsException("Index " + index +
                    " out of bounds for length " + size());
        }
    }

    private Node<T> getNode(int index){
        Node <T> current = first;
        int start = 0;
        while (start < index){
            start++;
            current = current.getNext();
        }
        return current;
    }

    @Override
    public String toString() {
        if(isEmpty()) return "[]";
        Node<T> current = first;
        int start = 0;
        StringBuilder listToString = new StringBuilder("[");
        listToString.append(first.getElement());
        while (start < size-1){
            start++;
            if(current == last){
                listToString.append(current.getElement());
                break;
            }
            current = current.getNext();
            listToString.append(", ").append(current.getElement());
        }
        return listToString.append("]").toString();
    }
}

class MyLinkedListTest{
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.add(0,5);
        System.out.println(list.size());
//        list.remove(0);
        System.out.println(list);


    }
}
