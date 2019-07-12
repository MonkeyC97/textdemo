package com.monkeyc.binarytree;

import java.util.Arrays;

public class TestHeap implements Heap{
    private int[] elem;
    private int usedSize;
    private static final int DEFAULT_SIZE = 10;
    public TestHeap(){
        this.usedSize = 0;
        this.elem = new int[DEFAULT_SIZE];

    }


    @Override
    public void AdjustDown(int root, int len) {
        int parent = root;
        int child = 2 * parent + 1;
        while(child < len){
            if(child+1 < len && this.elem[child] < this.elem[child+1]){
                ++child;
            }
            if(elem[child] > elem[parent]){
                int temp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = temp;
                parent = child;
                child = 2 * parent + 1;
            }else{
                break;
            }
        }
    }

    @Override
    public void initHeap(int[] array) {
        for(int i = 0; i < array.length;i++){
            this.elem[i] = array[i];
            this.usedSize++;
        }
        for(int i = (this.elem.length - 1 - 1) / 2;i >= 0; i--){
            AdjustDown(i,usedSize);
        }
    }

    @Override
    public void AdjustUp(int child, int len) {
        int parent = (child - 1) / 2;
        while(child > 0){
            if(this.elem[child] > this.elem[parent]){
                int temp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = temp;
                child = parent;
                parent = (child - 1) / 2;
            }else{
                break;
            }
        }
    }

    private boolean isFull(){
        return  this.usedSize == this.elem.length;
    }

    @Override
    public void pushHeap(int item) {
        if(isFull()){
            this.elem = Arrays.copyOf(this.elem,2 * this.elem.length);
        }
        this.elem[this.usedSize] = item;
        this.usedSize++;
        AdjustUp(this.usedSize - 1,this.usedSize);
    }

    @Override
    public int popHeap() {
        if(this.usedSize == 0){
            throw new UnsupportedOperationException("堆为空");
        }
        int tmp = elem[0];
        elem[0] = elem[this.usedSize - 1];
        elem[this.usedSize - 1] = tmp;
        AdjustDown(0,this.usedSize);
        return 0;
    }

    @Override
    public int getHeapTop() {
        if(this.usedSize == 0){
            throw new UnsupportedOperationException("堆为空");
        }
        return this.elem[0];
    }

    @Override
    public void HeapSort() {
        int end = this.usedSize - 1;
        while(end > 0){
            int tmp = this.elem[0];
            this.elem[0] = this.elem[end];
            this.elem[end] = tmp;
            AdjustDown(0,end);
            end--;
        }
    }
    public void HeapSort2(){
        for(int i = (this.elem.length - 1 - 1) / 2;i >= 0; i--){
            AdjustDown(i,usedSize);
        }
    }

    @Override
    public void show() {
        for(int i = 0;i < this.usedSize;i++){
            System.out.print(this.elem[i]+"");
        }
        System.out.println();
    }
}
