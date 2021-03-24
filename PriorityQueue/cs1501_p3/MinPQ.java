package cs1501_p3;
import java.util.ArrayList;
import java.lang.Comparable;

public class MinPQ<T extends Comparable<T>>{
    ArrayList<T> list;
    int size;
    public MinPQ(){
        list = new ArrayList<T>();
        size = 0;
    }

    public void add(T object){
        list.add(object);
        shiftup(size);
        size += 1;
    }

    public void shiftup(int index){
        if(index != 0){
            T child = list.get(index);
            T parent = list.get((index - 1)/2);
            if(child.compareTo(parent) < 0){
                T temp = list.get(index);
                list.set(index, parent);
                list.set((index - 1)/2, temp);
                shiftup((index-1)/2);
            }
        }
    }

    public T remove(){   
        T dummy;
        if(size == 0){
            return null;
        }
        else{
            dummy = list.get(0);
            T temp = list.remove(size-1);
            list.set(0,temp);
            size -= 1;
            shiftdown(0);
        }
        return dummy;
    }

    public void shiftdown(int index){
        T node = list.get(index);
        if((2*index + 1) < size && list.get((2*index + 1)) != null){
            // System.out.println(" Now I am checking nullity of left child OUTER : " );
            if((2*index + 2) < size && list.get((2*index + 2)) != null){
                // System.out.println(" Now I am checking nullity of right child INNER : " );
                if(list.get((2*index+1)).compareTo(list.get((2*index+2))) < 0){
                    // System.out.println("swapping with LEFT child");
                    if(list.get(index).compareTo(list.get((2*index+1))) > 0){
                        T temp = list.get(index);
                        list.set(index,list.get((2*index+1)));
                        list.set((2*index+1),temp);
                        shiftdown(2*index+1);
                    }
                }
                else{
                    if(node.compareTo(list.get((2*index+2))) > 0){
                        // System.out.println("swapping with RIGHT child");
                        T temp = list.get(index);
                        list.set(index,list.get((2*index+2)));
                        list.set((2*index+2),temp);
                        shiftdown(2*index+2);
                    }
                }
            }
            else{
                if(node.compareTo(list.get((2*index+1))) > 0){
                    // System.out.println("swapping with LEFT  child %%%%%");
                    T temp = list.get(index);
                    list.set(index,list.get((2*index+1)));
                    list.set((2*index+1),temp);
                    shiftdown(2*index+1);
                }
            }
        }
    }

    public T offer(){
        return list.get(0);
    }

    public int size(){
        return this.size();
    }

    public void printPQ(){
        System.out.print('\n' + "[");
        for(int i = 0; i < size; i++){
            if(i != size-1){
                System.out.print(list.get(i) + ", ");
            }
            else{
                System.out.print(list.get(i));
            }
        }
        System.out.print("]" + '\n');
    }

    // public static void main(String[] args){
        // // System.out.println("This is my minPQ");
        // MinPQ<String> obj = new MinPQ<>();
        // String[] arr = {"E","A","F","G","B","D","C"};
        // obj.add(arr[0]);
        // obj.add(arr[1]);
        // obj.add(arr[2]);
        // obj.add(arr[3]);
        // obj.add(arr[4]);
        // obj.add(arr[5]);
        // obj.add(arr[6]);
        // obj.printPQ();
        
        // // // System.out.println(obj.offer() + "   size : " + obj.size);

        // // System.out.println("removing 1st : " + obj.remove()  + "    size : " + obj.size);
        // // obj.printPQ();

        // // System.out.println("removing 2nd : " + obj.remove()  + "    size : " + obj.size);
        // // obj.printPQ();
        // // System.out.println("removing 3rd : " + obj.remove()  + "    size : " + obj.size);
        // // obj.printPQ();
        // // System.out.println("removing 4th : " + obj.remove()  + "    size : " + obj.size);
        // // obj.printPQ();
        // // System.out.println("removing 5th : " + obj.remove()  + "    size : " + obj.size);
        // // obj.printPQ();
        // // System.out.println("removing 6th : " + obj.remove()  + "    size : " + obj.size);
        // // obj.printPQ();
    // }
}
