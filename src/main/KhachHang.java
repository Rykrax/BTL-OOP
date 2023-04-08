package main;

import java.util.Scanner;

public class KhachHang extends Person{
    private String maKH;

    public KhachHang() {
        super();
    }
    
    public KhachHang(String maKH) {
    	this.maKH = maKH;
    }
    public KhachHang(String maKH, String hoten, String gt, String cmnd, String sodt, String diachi) {
        super(hoten, gt, cmnd, sodt, diachi);
        this.maKH = maKH;
    }

    public void setMakh(String maKH) {
        this.maKH = maKH;
    }

    public String getMakh() {
        return maKH;
    }
    
    @Override
    public void nhap() {
        Scanner sc= new Scanner(System.in);
        super.nhap(); 
    }

    @Override
    public String toString() {
        return "KhachHang - " + super.toString() + ", ma khach hang: " + this.maKH;
    }
}
