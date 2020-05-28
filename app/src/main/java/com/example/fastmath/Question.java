package com.example.fastmath;

import android.widget.TextView;

import java.util.Random;

public class Question {
    private   int so1, so2;
    private  boolean st;


    public Question(int so1, int so2, boolean st) {
        this.so1 = so1;
        this.so2 = so2;
        this.st=st;
    }

    public void setSt(boolean st) {
        this.st = st;
    }

    public boolean isSt() {
        return st;
    }

    public void setSo1(int so1) {
        this.so1 = so1;
    }

    public void setSo2(int so2) {
        this.so2 = so2;
    }

    public int getSo1() {
        return so1;
    }

    public int getSo2() {
        return so2;
    }


    public String createQuestion() {
        String hienthi = "";
        int soa, sob, kq;
        Random r = new Random();
        soa = r.nextInt(so1);
        sob = r.nextInt(so2);
        int pheptinh = r.nextInt(2);
        switch (pheptinh) {
            case 0: { // phep cong
                if (st==true) {
                    kq = soa + sob;
                    hienthi = "" + soa + " + " + sob + " = " + kq;
                    return hienthi;

                } else if(st==false){
                    kq = soa + r.nextInt(3) + sob;
                    hienthi = "" + soa + " + " + sob + " = " + kq;
                    return hienthi;
                }

            }
            case 1: { // phep tru
                if (st==true) {
                    kq = soa - sob;
                    hienthi = "" + soa + " - " + sob + " = " + kq;
                    return hienthi;
                } else if(st==false){
                    kq = soa - r.nextInt(3) - sob;
                    hienthi = "" + soa + " - " + sob + " = " + kq;
                    return hienthi;
                }


            }
            default: {
                return hienthi;
            }
        }
    }

}
