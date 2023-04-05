package module9;

public class MyQueue <T> implements MyQueueInterface<T>{
    private int size;
    private MyLinkedList <T> list;

    public MyQueue(){
        list = new MyLinkedList<>();
    }


    public void add(T value){
        list.add(value);
        size = list.size();
    }

    @Override
    public void clear() {
        list.clear();
        size = list.size();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T peek() {
        return list.get(0);
    }

    public T poll(){
        T element = list.remove(0);
        size = list.size();
        return element;
    }

    @Override
    public String toString(){
        return list.toString();
    }
}

class MyQueueTest{
    public static void main(String[] args) {
        MyQueue <Integer> queue = new MyQueue<>();
        // Додаємо елементи в queue
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println("queue після створення і додання 5ти елементів:\n"
                + queue + ". Size = " + queue.size());
        System.out.println();

        //беремо елементи з queue
        System.out.println("Беремо перший елемент з queue: ");
        System.out.println("queue.peek() = " + queue.peek());
        System.out.println();

        //видаляємо елементи з queue
        System.out.println("Видаляємо елементи з queue");
        System.out.println("you removed - " + queue.poll());
        System.out.println("you removed - " + queue.poll());
        System.out.println("you removed - " + queue.poll());
        System.out.println("Ліст після видалення елементів:\n"
                + queue + ". Size = " + queue.size());
        System.out.println();

        //очищаємо queue
        queue.clear();
        System.out.println("Очищаємо queue");
        System.out.println("Ліст після очищення:\n"
                + queue + ". Size = " + queue.size());
        System.out.println();

    }
}
