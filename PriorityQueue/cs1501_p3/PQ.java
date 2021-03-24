package cs1501_p3;

import java.util.Comparator;
import java.lang.Comparable;
class PQ {
    Object[] queue;
    int size;
    public PQ(){
        this.size = 1;
        this.queue = new Object[this.size];
    }

    public void add(Object o, Comparator<Object> comp){
        if(this.size == 1 && queue[size-1] == null){
            this.queue[0] = o;
        }
        else if(this.queue[size - 1] != null){
            Object[] temp = new Object[2*this.size];
            for(int i = 0; i < this.size ; i++){
                temp[i] = queue[i];
            }
            queue = temp;
            queue[size] = o;
            shiftup(size,comp);
            size = 2*size;
        }
        else{
            queue[size] =o;
            shiftup(size,comp);
            size += 1;
        }
    }

    public Object remove(CarComparator comp) throws EmptyQueueException{
        Object dummy;
        if(this.size == 1 && this.queue[size-1] == null){
            throw new EmptyQueueException("Queue is empty");
        }
        else if(this.size == 0){
            throw new EmptyQueueException("Queue is empty");

        }
        else{
            dummy = this.queue[0];
            this.queue[0] = this.queue[size-1];
            this.size -= 1;
            shiftdown(0,comp);
        }
        return dummy;
    }

    public void shiftup(int index, Comparator<Object> comp){
        if(index != 0){
            Object child = this.queue[index];
            Object parent = this.queue[(index-1)/2];
            if(comp.compare(child,parent) < -1){
                Object temp = this.queue[index];
                this.queue[index] = parent;
                this.queue[(index-11)/2] = temp;
                shiftup((index-1)/2,comp);
            }
        }
    }

    public void shiftdown(int index, CarComparator comp){
        if((2*index + 1) < size && this.queue[(2*index + 1)] != null ){
            if((2*index + 2) < size && this.queue[(2*index + 2)] != null){
                if(comp.compare(this.queue[(2*index + 1)],this.queue[(2*index + 2)]) < -1){
                    if(comp.compare(this.queue[index],this.queue[(2*index + 1)])< 0){
                        Object temp = this.queue[index];
                        this.queue[index] = this.queue[(2*index + 1)];
                        this.queue[(2*index + 1)] = temp;
                        shiftdown(2*index +1,comp);
                    }

                }
                else{
                    if(comp.compare(this.queue[index],this.queue[(2*index + 2)])< 0){
                        Object temp = this.queue[index];
                        this.queue[index] = this.queue[(2*index + 2)];
                        this.queue[(2*index + 2)] = temp;
                        shiftdown(2*index +2,comp);
                    }
                }
            }
            else{
                if(comp.compare(this.queue[index],this.queue[(2*index + 1)])< 0){
                    Object temp = this.queue[index];
                    this.queue[index] = this.queue[(2*index + 1)];
                    this.queue[(2*index + 1)] = temp;
                    shiftdown(2*index +1,comp);
                }
            }
        }
    }

    public Object offer(){
        return this.queue[0];
    }

    public int size(){
        return this.size();
    }

    public class EmptyQueueException extends Exception{
        public EmptyQueueException(String s){
            super(s);
        }
    }
    
    public class CarComparator implements Comparator<Object>{
        public int compare(Object o1, Object o2){
            if(compare(o1,o2) == 0){
                return 0;
            }
            else if(compare(o1,o2) < 0){
                return -1;
            }
            else{
                return 1;
            }
        }
    
    }
    public static void main(String[] args){
        System.out.println("This is Priority Queue");
        PQ obj = new PQ();  
    }

}