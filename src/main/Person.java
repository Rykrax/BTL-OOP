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
public class Person implements Serializable{
    private String hoten;
    private String gt;
    private String cmnd;
    private String sodt;
    private String diachi;

    public Person(String hoten, String gt, String cmnd, String sodt, String diachi) {
        this.hoten = hoten;
        this.gt = gt;
        this.cmnd = cmnd;
        this.sodt = sodt;
        this.diachi = diachi;
    }

    public Person() {
    }

    public String getHoten() {
        return hoten;
    }
    
    public void  nhap()
    {
        Scanner sc = new Scanner (System.in);
        System.out.print("Ho va ten : ");
                hoten=sc.nextLine();
               
        System.out.print(" Gioi tinh : ");
        gt=sc.nextLine();
        System.out.print("Can cuoc cong dan : ");
        cmnd=sc.nextLine();
        System.out.print(" So dien thoai : ");
        sodt=sc.nextLine();
        System.out.print("Dia chi :  ");
        diachi=sc.nextLine();
    }

    @Override
    public String toString() {
        return  " Hoten " + hoten + " gt  " + gt + " cmnd  " + cmnd + " sodt  " + sodt + "  diachi  " + diachi ;
    }
    
    
}
