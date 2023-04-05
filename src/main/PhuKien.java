/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class PhuKien  extends SanPham implements Serializable{
    private String loaisp;

    public PhuKien() {
        super();
    }
    public PhuKien(String loaisp, String tenSP, int namSX, int soLuong, int coin) {
        super(tenSP, namSX, soLuong, coin);
        this.loaisp = loaisp;
    }
    @Override
    public void nhap()
    {
        Scanner sc= new Scanner (System.in);
        
        System.out.print("Loai phu kien : ");
        loaisp=sc.nextLine();
        super.nhap();
    }

    @Override
    public String toString() {
        return "PhuKien  "+"  Loai phu kien  "+loaisp+super.toString();
    }
    
}
