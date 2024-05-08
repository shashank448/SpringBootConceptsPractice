package com.example.demo.controllers;

public class ExamResult {
    private int physics, chemistry, maths;

    public int getPhysics() {
        return physics;
    }

    public void setPhysics(int physics) {
        this.physics = physics;
    }

    public void setChemistry(int chemistry) {
        this.chemistry = chemistry;
    }

    public void setMaths(int maths) {
        this.maths = maths;
    }

    public int getChemistry() {
        return chemistry;
    }

    public int getMaths() {
        return maths;
    }

    public ExamResult(int physics, int chemistry, int maths) {
        this.physics = physics;
        this.chemistry = chemistry;
        this.maths = maths;
    }
}
