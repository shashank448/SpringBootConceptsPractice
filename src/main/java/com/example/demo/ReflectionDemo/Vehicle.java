package com.example.demo.ReflectionDemo;

public class Vehicle {
    Motor motor;
    GasChamber gasChamber;

    public Vehicle(Motor motor, GasChamber gasChamber) {
        this.motor = motor;
        this.gasChamber = gasChamber;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public GasChamber getGasChamber() {
        return gasChamber;
    }

    public void setGasChamber(GasChamber gasChamber) {
        this.gasChamber = gasChamber;
    }
}
