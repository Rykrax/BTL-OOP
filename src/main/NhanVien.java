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
public class NhanVien extends Person{
    private String manv;

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
    }
    
    
}
