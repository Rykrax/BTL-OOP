/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class NhanVienBLL {
    ArrayList<NhanVien> lnv= new ArrayList<>();
    public void nhap()
    {
       Scanner sc = new Scanner (System.in);
    
        System.out.print(" So luong nhan vien trong cua hang  : ");
        int sl=Integer.parseInt(sc.nextLine());
        int i=0;
        while(true)
        {
            NhanVien a= new NhanVien();
        a.nhap();
        lnv.add(a);
        i++;
        if(i==sl) break;
    }
    }
    public void hien() throws IOException
    {
        for(NhanVien x: docfile())
        {
            System.out.println(x.toString());
        }
    }
    public NhanVien searchbyname() throws IOException
    {
        Scanner sc= new Scanner (System.in);
        System.out.print(" ten nhan vien    : ");
        String sten=sc.nextLine();
   
        for(NhanVien x: docfile() )
        {
            if(x.getHoten().compareTo(sten)==0)
            {
                return x;
            }
        }
        return null;
        
      
    }
    public void ghifile() throws FileNotFoundException, IOException
    {
        FileOutputStream fo= new FileOutputStream("NhanVien.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fo); 
        try {
           for(Person x : lnv)//lua ghi vao file laf lop cha
           {
               oos.writeObject(x);
           }
            System.out.println("  ghi file succed ");
        } catch (Exception e) {
            System.out.println("Khong the ghi file ");
        } finally {
            if(fo!=null) fo.close();
            if(oos!=null) oos.close();
        }
       
    }
    public ArrayList<NhanVien> docfile() throws FileNotFoundException, IOException
    {
        FileInputStream fi =new FileInputStream("NhanVien.dat");
        ObjectInputStream ooi= new ObjectInputStream(fi);
        ArrayList<NhanVien> kq= new ArrayList<>();
        NhanVien nv=null;
        try {
            while(fi.available()>0)
            {
                nv=(NhanVien)ooi.readObject();
                kq.add(nv);
                
            }
           // System.out.println("Doc File thanh cong ");
        } catch (Exception e) {
            System.out.println("File khong ton tai : ");
            
        } finally {
            fi.close();
            ooi.close();
        }
        return kq;
    }
    public static void main(String[] args) throws IOException {
        NhanVienBLL a= new NhanVienBLL();
//        a.nhap();
//        a.ghifile();
       a.hien();
        
        
        
    }
    
    
}
