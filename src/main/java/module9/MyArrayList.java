package module9;

import java.util.StringJoiner;

public class MyArrayList <T> implements MyList<T>{
    private static final int DEFAULT_CAPACITY = 10;//розмір масиву за замовчанням

    private Object[] array;//масив на базі якого організовано MyArrayList
    private int size;//розмір MyArrayList

    public MyArrayList (){
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /*
    метод для додавання елементів в кінець MyArrayList
     */
    @Override
    public void add(T value){
        isSizeOk();// метод перевірить чи достатній розмір для додання елементу, якщо ні то збільшить розмір поля array, а після додасть елемент
        array[size++] = value;
    }

    /*
    метод для додання елементу в MyArrayList за індексом всі наступні елементи з тим
    чий індекс дорівнює індексу вставки будуть зміщені на 1 праворуч
     */
    public void add(int index,T value){
        if(this.size < index                //викинемо виключення, якщо індекс не валідний
                || index < 0){
            throw new IndexOutOfBoundsException("Index " + index +
                    " out of bounds for length " + size());
        }
        isSizeOk();//перевіряємо чи достатній розмір масиву
        Object [] newArray = new Object[array.length];
        System.arraycopy(array,0,newArray,0, index);//копіюємо елементи до індексу
        newArray[index] = value;//присвоюємо значення за індексом
        System.arraycopy(array,index,newArray,index+1, array.length-index-1);//копіюємо решту елементів
        array = newArray;
        this.size++;
    }

    /*
    службовий метод, що перевіряє розмір масиву, за необхідності збільшує його в 1,5 рази
     */
    private void isSizeOk(){
        if (size == array.length -1){
            System.out.println("size = " + array.length);
            Object [] newArray = new Object[(int)(array.length*1.5)];
            System.arraycopy(array,0,newArray,0, array.length);
            array = newArray;
            System.out.println("size = " + array.length);
        }
    }

    /*
    службовий метод, що перевіряє індекс для вставки/видалення в разі невалідності, кидає виключення
     */
    private void isIndexOk(int index){
        if(this.size <= index
                || index < 0){
            throw new IndexOutOfBoundsException("Index " + index +
                    " out of bounds for length " + size());
        }
    }

    /*
    Метод для видалення елементу за індексом, поверне елемент, що був видалений
     */
    @Override
    public T remove (int index){
        isIndexOk(index);// в разі невалідності індекса викинеться виключення
        T toRemove = (T)array[index];
        Object [] withoutToRemove = new Object[array.length];
        System.arraycopy(array,0,withoutToRemove,0, index);
        System.arraycopy(array,index+1,withoutToRemove,index, array.length-index-1);
        array = withoutToRemove;
        this.size--;

        return toRemove;
    }

    /*
    метод що видаляє елемент за значенням поверне true, якщо елемент існував в листі і був видалений і false, якщо ні
     */
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

    /*
    поверне розмір колекції
     */
    @Override
    public int size(){
        return size;
    }

    /*
    поверне елемент за індексом
     */
    @Override
    public T get(int index){
        isIndexOk(index);
        return (T)array[index];
    }

    /*
    очистити колекцію
     */
    @Override
    public void clear(){
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public String toString() {
        int start = 0;
        StringJoiner sj = new StringJoiner(", ");
        while (start < size){
            sj.add("" + array[start++]);
        }
        return "[" + sj + "]";
    }
}

class MyArrayListTest{
    public static  void main (String [] args){
        MyArrayList <String> list = new MyArrayList<>();
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
