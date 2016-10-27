package com.company;

public class Main {

    public static void main(String[] args) {
        String s = "[123,[456,[789]]]";
        MiniParser mini = new MiniParser();
        mini.deserialize(s);
	// write your code here
    }
}
