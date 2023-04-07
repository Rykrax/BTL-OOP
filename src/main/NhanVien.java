/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class NhanVien extends Person implements Serializable{
    private String manv;
    private double hsl;
    private final long lcb =2500000;

    public NhanVien() {
        super();
    }

    public NhanVien(String manv, String hoten, String gt, String cmnd, String sodt, String diachi) {
        super(hoten, gt, cmnd, sodt, diachi);
        this.manv = manv;
    }

    
    @Override
    public void nhap() {
        Scanner sc= new Scanner(System.in);
        super.nhap(); 
        System.out.print("Ma Nhan Vien : ");
        manv=sc.nextLine();
        System.out.print("He so luong : ");
        hsl=Double.parseDouble(sc.nextLine());
    }
    public double luong()
    {
        return hsl*lcb;
    }

    @Override
    public String toString() {
          Locale lc = new Locale("vi","VN");
	NumberFormat numf = NumberFormat.getInstance(lc);
        return "NhanVien  "+super.toString()+" Ma nhan vien  "+manv+"  Luong  "+numf.format(luong());
    }
    
}
