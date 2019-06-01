package com.monkeyc.jcf;

import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("Java");
        stack.push("c++");
        stack.push("PHP");
        stack.push("Golang");
        System.out.println("栈的大小:"+stack.size());
        System.out.println("栈是否为空:"+stack.isEmpty());
        System.out.println("观察栈顶元素:"+stack.peek());
        //要出栈之前判断一下栈是否为空
        System.out.println("出栈:"+stack.pop());
        System.out.println("出栈:"+stack.pop());
        System.out.println("出栈:"+stack.pop());
        System.out.println("出栈:"+stack.pop());
        //EmptyStackException
        System.out.println("出栈:"+stack.pop());
    }
}
