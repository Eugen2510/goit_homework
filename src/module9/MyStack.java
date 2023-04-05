package module9;


public class MyStack <T> implements MyQueueInterface<T>{
    private int size;
    private MyLinkedList<T> list;

    public MyStack(){
        list = new MyLinkedList<>();
    }

    public void push(T element){
        list.add(element);
        size = list.size();
    }

    public T remove(int index){
        T element =  list.remove(index);
        size = list.size();
        return element;
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

    public T pop(){
        T element = list.remove(list.size()-1);
        size = list.size();
        return element;
    }

    @Override
    public String toString(){
        return list.toString();
    }
}

class StackTest{
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        // Додаємо елементи в stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("queue після створення і додання 5ти елементів:\n"
                + stack + ". Size = " + stack.size());
        System.out.println();

        //беремо елементи з stack
        System.out.println("Беремо перший елемент з stack: ");
        System.out.println("stack.peek() = " + stack.peek());
        System.out.println();

        //видаляємо елементи з stack допомогою методу pop()
        System.out.println("Видаляємо елементи з stack за допомогою методу pop()");
        System.out.println("you removed - " + stack.pop());
        System.out.println("you removed - " + stack.pop());
        System.out.println("stack після видалення елементів:\n"
                + stack + ". Size = " + stack.size());
        System.out.println();

        //видаляємо елементи з stack допомогою методу remove
        System.out.println("Видаляємо елементи з stack за допомогою методу remove()");
        System.out.println("you removed - " + stack.remove(1));
        System.out.println("stack після видалення елементів:\n"
                + stack + ". Size = " + stack.size());
        System.out.println();

        //очищаємо stack
        stack.clear();
        System.out.println("Очищаємо stack");
        System.out.println("stack після очищення:\n"
                + stack + ". Size = " + stack.size());
        System.out.println();

    }
}
