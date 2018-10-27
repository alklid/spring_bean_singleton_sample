package com.alklid.inflearn;

public class Parent {
    private Child child;

    public Parent(Child child) {
        this.child = child;
    }

    public Child getChild() {
        return this.child;
    }
}
