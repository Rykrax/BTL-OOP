package main;

import java.io.Serializable;
import java.util.Scanner;

public class Person implements Serializable {
     private String hoten;
    private String gt;
    private String cmnd;
    private String soDT;
    private String diachi;

    public Person(String hoten, String gt, String cmnd, String soDT, String diachi) {
        this.hoten = hoten;
        this.gt = gt;
        this.cmnd = cmnd;
        this.soDT = soDT;
        this.diachi = diachi;
    }

    public Person() {
    }

    public String getHoten() {
        return hoten;
    }
    
    public void  nhap() {
        Scanner sc = new Scanner (System.in);
        System.out.print("Ho va ten: ");
        this.hoten=sc.nextLine();
        System.out.print("Gioi tinh: ");
        this.gt = sc.nextLine();
        System.out.print("Can cuoc cong dan: ");
        this.cmnd=sc.nextLine();
        System.out.print("So dien thoai: ");
        this.soDT=sc.nextLine();
        System.out.print("Dia chi: ");
        this.diachi=sc.nextLine();
    }

    @Override
    public String toString() {
        return  "Hoten: " + this.hoten 
        		+ ", gioi tinh: " + this.gt 
        		+ ", cmnd: " + this.cmnd 
        		+ ", SDT: " + this.soDT 
        		+ ", diachi: " + this.diachi ;
    }    
}
