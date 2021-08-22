package hw2_Generics;

import java.util.Arrays;

public class MyList <T> {

    private T[] list;
    private int numberOfElements;

    public MyList() {
        this.list = (T[]) new Object[10];
    }

    public MyList(int capacity) {
        this.list = (T[]) new Object[capacity];
    }

    public int size(){
        return this.numberOfElements;
    }

    public int getCapacity(){
        return this.list.length;
    }

    public void add(T data){
        if (size() == this.list.length){
            T[] tempList = this.list;
            this.list = (T[]) new Object[tempList.length * 2];
            for (int i = 0; i < tempList.length; i++){
                this.list[i] = tempList[i];
            }
        }
        this.list[numberOfElements] = data;
        numberOfElements++;
    }

    public T get(int index){
        if (index < 0 || index >= this.list.length){
            return null;
        }
        return this.list[index];
    }

    public T remove(int index){
        if (index < 0 || index >= this.list.length){
            return null;
        }
        T removedItem = this.list[index];
        this.list[index] = null;
        for (int i = index; i < this.numberOfElements - 1; i++){
            this.list[index] = this.list[index+1];
        }
        numberOfElements--;
        return removedItem;
    }

    public T set(int index, T data){
        if (index < 0 || index >= this.list.length){
            return null;
        }
        T oldItem = this.list[index];
        this.list[index] = data;
        return oldItem;
    }

    public String toString() {
        String items = "[";
        for (int i = 0; i < this.numberOfElements; i++){
            items += this.list[i];
            if (i != this.numberOfElements - 1){
                items += ", ";
            }
        }
        items += "]";
        return items;
    }

    public int indexOf(T data){
        for(int i = 0; i < this.numberOfElements; i++){
            if (this.list[i].equals(data)){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data){
        for(int i = this.numberOfElements-1; i >= 0; i--){
            if (this.list[i].equals(data)){
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty(){
        return this.list[0] == null;
    }

    public T[] toArray(){
        T[] temp = (T[]) new Object[this.numberOfElements];
        for (int i = 0; i < this.numberOfElements; i++){
            temp[i] = this.list[i];
        }
        return temp;
    }

    public void clear(){
        this.list = (T[]) new Object[this.numberOfElements];
        this.numberOfElements = 0;
    }

    public MyList<T> subList(int start, int finish){
        if(start < 0 || finish < 0 || start > finish){
            return null;
        }
        MyList<T> tempList = new MyList<>(finish - start + 1);
        for (int i = start; i <= finish; i++){
            tempList.add(this.list[i]);
        }
        return tempList;
    }

    public boolean contains(T data){
        for (int i = 0; i < this.numberOfElements; i++){
            if (this.list[i].equals(data)){
                return true;
            }
        }
        return false;
    }

}
