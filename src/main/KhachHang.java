/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class KhachHang  extends Person{
    private String makh;

    public KhachHang() {
        super();
    }

    public KhachHang(String makh, String hoten, String gt, String cmnd, String sodt, String diachi) {
        super(hoten, gt, cmnd, sodt, diachi);
        this.makh = makh;
    }

    @Override
    public void nhap() {
        Scanner sc= new Scanner(System.in);
        super.nhap(); 
        System.out.print(" Ma Khach Hang : ");
        makh=sc.nextLine();
    }

    @Override
    public String toString() {
        return "KhachHang   "+super.toString()+" Ma khach hang "+makh;
    }
    
    
    
    
    
}
