package main;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class PhuKien  extends SanPham implements Serializable{
    private String loaiSP;

    public PhuKien() {
        super();
    }
    public PhuKien(String loaiSP, String tenSP, int namSX, int soLuong, double coin) {
        super(tenSP, namSX, soLuong, coin);
        this.loaiSP = loaiSP;
    }
    
    @Override
    public void nhap() {
        Scanner sc= new Scanner (System.in);
        super.nhap();
        System.out.print("Loai phu kien : ");
        loaiSP = sc.nextLine();
    }
    
    @Override
    public String toString() {
        return "PhuKien - " + super.toString() + ", loai phu kien: " + this.loaiSP;
    }
    
}
