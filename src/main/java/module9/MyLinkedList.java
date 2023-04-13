package module9;

import java.util.StringJoiner;

public class MyLinkedList<T> implements MyList<T>{
    private int size;//розмір MyLinkedList
     Node <T> first;//нода для збереження початкового елементу MyLinkedList
     Node <T> last;//нода для збереження кінцевого елементу MyLinkedList

    /*
    метод для очищення MyLinkedList
     */
    @Override
    public void clear(){
        first = last = null;
        size = 0;
    }

    /*
    метод що повертає ромір MyLinkedList
     */
    @Override
    public int size(){
        return size;
    }

    /*
    метод що додає елементи в кінець MyLinkedList
     */
    @Override
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

    /*
    метод що додає елементи в початок MyLinkedList
     */
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

    /*
    метод що додає елементи в MyLinkedList за індексом, всі наступні ссуваються вправо на 1
     */
    public void add(int index, T value) {
        if (index == size){//якщо індекс дорівнює довжині додаємо в кінець MyLinkedList
            add(value);
            return;
        }
        throwException(index);//якщо індекс не валідний викинеться виключення
        Node<T> newNode = new Node<>(value);
        Node<T> current = getNode(index);
            if(index == 0){//якщо індекс дорівнює 0 додаємо в початок MyLinkedList
                addFirst(value);
                size--;//зменшуємо сайз бо метод addFirst збільшить його на 1 і це саме відбудеться в кінці цього методу
            }else {// якщо не спрацювали перші 2 умови додаємо за індексом
                newNode.setPrev(current.getPrev());
                newNode.setNext(current);
                current.getPrev().setNext(newNode);
                current.setPrev(newNode);
            }

        size++;
    }

    /*
    метод що видаляє елемент з MyLinkedList за індексом, поверне елемент
     */
    @Override
    public T remove(int index){
        throwException(index);//якщо індекс не валідний буде викинуто ексепшн
        Node<T> current = getNode(index);//беремо поточну ноду за індексом
        T value = current.getElement();//зберігаємо значення, що буде повертатись з методу
        if(size == 1){//очищеюмо MyLinkedList за умови що це єдиний елемент
            clear();
            return value;
        }

        if (current == first){//якщо це перший елемент
            first = first.getNext();
            first.setPrev(null);
            size--;
            return value;
        }

        if(current == last){//якщо останній
            last = last.getPrev();
            last.setNext(null);
        } else {//елемент з середини списку
            current.getNext().setPrev(current.getPrev());
            current.getPrev().setNext(current.getNext());

        }

        size--;

        return value;
    }

    /*
    метод що повертає елемент з MyLinkedList за індексом
     */
    @Override
    public T get(int index){
        throwException(index);//якщо індекс не валідний буде викинуто ексепшн
        return getNode(index).getElement();//за індексом знайдеться нода та повернеться її елемент
    }

    /*
    службовий метод, перевіряє чи не пустий MyLinkedList
     */
    private boolean isEmpty(){
        return size == 0;
    }


    /*
    службовий метод, перевіряє індекс на валідність
     */
    private boolean isIndexOk(int index){
        return index >= 0 && index < size;
    }

    /*
    службовий метод, викидає виключення за умови невалідного індекса
     */
    private void throwException(int index){
        if(!isIndexOk(index)){
            throw new IndexOutOfBoundsException("Index " + index +
                    " out of bounds for length " + size());
        }
    }

    /*
    службовий метод, повертає ноду за індексом
     */
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
        StringJoiner sj = new StringJoiner(", ");
        while (current != null){
           sj.add("" + current.getElement());
            current = current.getNext();

        }
        return "[" + sj + "]";
    }
}

class MyLinkedListTest{
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        // Додаємо елементи в ліст
        list.add("Java");
        list.add("is the");
        list.add("best");
        list.add("programming");
        list.add("language");
        System.out.println("Ліст після створення і додання 5ти елементів:\n"
                + list + ". Size = " + list.size());
        System.out.println();


        System.out.println("Беремо елементи з ліста: ");
        for (int i = 0; i < list.size(); i++){
            System.out.println("list.get(" + i +") = " + list.get(i));
        }
        System.out.println();


        System.out.println("Видаляємо елементи з ліста");
        System.out.println("you removed - " + list.remove(3));
        System.out.println("you removed - " + list.remove(list.size() - 1));
        System.out.println("you removed - " + list.remove(0));
        System.out.println("Ліст після видалення елементів:\n"
                + list + ". Size = " + list.size());
        System.out.println();

        //пробуємо видалити елемент за невалідним індексом
        System.out.println("Пробуємо видалити елемент за невалідним індексом - 2 при довжині 2:");
        try {
            list.remove(2);
        }catch (IndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        System.out.println();

        //очищаємо ліст
        list.clear();
        System.out.println("Очищаємо ліст");
        System.out.println("Ліст після очищення:\n"
                + list + ". Size = " + list.size());
        System.out.println();

    }
}
