package module9;

import java.util.Objects;
import java.util.StringJoiner;

public class MyHashMap <K, V> implements MyMap<K, V>{

    private  Node<K,V> [] array;//Масив в якому будуть зберігатися списки елементів мапи
    private int size;//Змінна що зберігає розмір мапи
    private static final float LOAD_FACTOR = 0.75f;
    private int limit;

    private int length;

    public MyHashMap(){
        length = 16;
        array = new Node[length];
        limit = (int)(length * 8 * LOAD_FACTOR);
    }

    /*
    Вкладений клас для зберігання значень елементів мапи та організації їх збереження у вигляді однозв'язного списку
     */
    static class Node<K,V>{
        private final int hash;
        private final K key;
        private V value;
        private Node<K,V> next;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            hash = Objects.hashCode(key);
        }
    }

    private void resize(){
        if(size < limit){
            return;
        }
        length = length*2;
        limit = (int) (length * 8 * LOAD_FACTOR);
        Node <K,V> []arrayCopy = array;
        array = new Node[length];
        for (Node<K,V> node : arrayCopy){
            Node<K, V> forCopy = node;
            while (forCopy != null){
                Node<K, V> add = new Node<>(forCopy.key,forCopy.value);
                addNode(add);
                forCopy = forCopy.next;
            }

        }
    }

    /*
    Службовий метод, що використовується для розрахунку індексу масиву, в який буде покладено елемент
     */
    private int calcIndex(K key){
        return Objects.hashCode(key) & length-1;
    }

    /*
    Службовий метод, що використовується для додавання елементу мапи, без перевірки на дублювання ключів
     */
    private void addNode(Node<K,V> node){
        int index = calcIndex(node.key);
        if (array[index] == null){
            array[index] = node;
        }else {
            Node<K, V> current = array[index];
            while (current.next != null){
                current = current.next;
            }
            current.next = node;
        }

    }

    /*
    Службовий метод, що використовується для пошуку елементу мапи за ключем, якщо елементу
    з відповідним ключем в мапі немає, буде повернено null
     */
    private Node <K,V> getNode(K key){
        int index = calcIndex(key);
        if (array[index] != null){
            Node <K,V> current = array[index];
            while (true){
                if(current.hash == Objects.hashCode(key) && key.equals(current.key)){
                    return current;
                }
                if (current.next == null) break;
                current = current.next;
            }
        }
        return null;
    }

    /*
    Метод для додавання елементів в мапу
     */
    @Override
    public void put(K key, V value){
        resize();
        Node <K, V> newElement = new Node<>(key, value);

        /*нода для перевірки чи існує в мапі елемент з ідентичним ключем, посилається на елемент мапи,
        якщо існує і null, якщо ні
         */
        Node <K, V> checkNode = getNode(key);
        if(checkNode != null){// якщо елемент з ідентичним ключем вже міститься, перезаписуємо значення
            checkNode.value = value;
            return;
        }
        addNode(newElement);
        size++;
    }

    /*
    Метод для видалення елементів з мапи
     */
    @Override
    public void remove(K key){
        int index = calcIndex(key);
        Node<K, V> beforeRemove = array[index];
        if(beforeRemove == null) {//перевіряємо чи не пустий елемент масиву, який має містити відповідний ключ
            return;
        }
        if (beforeRemove.key.equals(key)){//якщо потрібний елемент є першим в списку
            array[index] = beforeRemove.next;
            size--;
            return;
        }
        while (beforeRemove.next != null){//пошук елемента що передує елементу з відповідним ключем, якщо попередні умови не виконалися
            if (beforeRemove.next.key.equals(key)){
                beforeRemove.next = beforeRemove.next.next;
                size--;
                return;
            }
            beforeRemove = beforeRemove.next;
        }

    }

    /*
    Метод для очищення мапи
     */
    @Override
    public void clear(){
        length = 16;
        array = new Node[length];
        limit = (int)(length * 8 * LOAD_FACTOR);
        size = 0;
    }

    /*
    Метод що повертає розмір мапи
     */
    @Override
    public int size(){
        return size;
    }

    /*
    Метод для отримання значення за ключем
     */
    @Override
    public V get(K key){
        Node <K, V> desired  = getNode(key);
        if (desired != null){
            return desired.value;
        }
        return null;
    }

    public String toString(){
        StringJoiner sj = new StringJoiner(", ");
        int index = 0;
        for (Node<K,V> node : array){
            sj.add("\n" + index++ + ")\n" );
            if (node == null) {
                continue;
            }
            Node <K, V> current = node;
            sj.add(current.key +" - " + current.value);
            while (current.next != null){
                current = current.next;
                sj.add(current.key +" - " + current.value);
            }
        }
        return "[" + sj + "]";
    }
}

class MyHashMapTest{
    public static void main(String[] args) {
        MyHashMap<Integer, String> map = new MyHashMap<>();
        for (int i = 0; i < 220; i++){
            map.put(i, "a"+i);
        }

        map.put(96, "b");
        map.put(97, "b");
        map.put(98, "b");

        map.remove(97);
        System.out.println(map);
        System.out.println("map.size() = " + map.size());
        System.out.println("map.get(97) = " + map.get(97));
        // Додаємо елементи в мапу
//        map.put("Ivanov", 25);
//        map.put("Luhovyi", 36);
//        map.put("Mazurenko", 24);
//        map.put("Masluc", 16);
//        map.put("Danchuk", 34);
//        System.out.println("Мапа після створення і додання 5ти елементів:\n"
//                + map + ". Size = " + map.size());
//        System.out.println();
//
//        //Додаємо елемент з вже існуючим ключем:
//        map.put("Ivanov", 999);
//        System.out.println("Мапа після додання елементу з ключем \"Ivanov\", що вже міститься в мапі:\n"
//                + map + ". Size = " + map.size());
//        System.out.println();
//
//        //Видаляємо елемент з мапи
//        map.remove("Danchuk");
//        System.out.println("Мапа після видалення елементу з ключем \"Danchuk\":\n"
//                + map + ". Size = " + map.size());
//        System.out.println();
//
//        //Беремо значення елементу за ключем
//        System.out.println("map.get(\"Luhovyi\") = " + map.get("Luhovyi"));
//        System.out.println("Після взяття значення елементу за ключем \"Luhovyi\" мапа не змінюється:\n"
//                + map + ". Size = " + map.size());
//        System.out.println();
//
//        //Очищаємо мапу
//        map.clear();
//        System.out.println("Мапа після очищення:\n"
//                + map + ". Size = " + map.size());
//        System.out.println();
//
//
//

    }
}
