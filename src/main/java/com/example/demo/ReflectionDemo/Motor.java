package com.example.demo.ReflectionDemo;

public class Motor {

    Tube tube;

    public Motor(Tube tube) {
        this.tube = tube;
    }

    public Tube getTube() {
        return tube;
    }

    public void setTube(Tube tube) {
        this.tube = tube;
    }
}
