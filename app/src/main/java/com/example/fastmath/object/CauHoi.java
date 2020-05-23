package com.example.fastmath.object;

import java.util.Random;

public class CauHoi {
    int soA;
    int soB;
    int ketQua;
    boolean kiemTra;

    public CauHoi(int soA, int soB, int ketQua, boolean kiemTra) {
        this.soA = soA;
        this.soB = soB;
        this.ketQua = ketQua;
        this.kiemTra = kiemTra;
    }



    public void setSoA(int soA) {
        this.soA = soA;
    }

    public void setSoB(int soB) {
        this.soB = soB;
    }
    public void setKetQua(int ketQua) {
        this.ketQua = ketQua;
    }

    public void setKiemTra(boolean kiemTra) {
        this.kiemTra = kiemTra;
    }
}
