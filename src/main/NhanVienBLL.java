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
    ArrayList<Person> lnv= new ArrayList<>();
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
    public void hien()
    {
        Iterator it = lnv.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next().toString());
        }
    }
    public String searchbyname()
    {
        Scanner sc= new Scanner (System.in);
        System.out.print(" ten nhan vien ban muon tim   : ");
        String sten=sc.nextLine();
   
        for(Person x: lnv )
        {
            if(x.getHoten().compareTo(sten)==0)
            {
                return x.toString();
            }
        }
        return "Khong co nhan vien do trong cua hang ";
        
      
    }
    public void ghifile() throws FileNotFoundException, IOException
    {
        FileOutputStream fo= new FileOutputStream("NhanVien.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fo); 
        try {
           for(Person x : lnv)
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
    public void docfile() throws FileNotFoundException, IOException
    {
        FileInputStream fi =new FileInputStream("NhanVien.dat");
        ObjectInputStream ooi= new ObjectInputStream(fi);
        Object nv=null;
        try {
            while(fi.available()>0)
            {
                nv=ooi.readObject();
                System.out.println(nv);
                
            }
            System.out.println("Doc File thanh cong ");
        } catch (Exception e) {
            System.out.println("File khong ton tai : ");
            
        } finally {
            fi.close();
            ooi.close();
        }
    }
    public static void main(String[] args) throws IOException {
        NhanVienBLL a= new NhanVienBLL();
        a.nhap();
        a.hien();
        a.ghifile();
        a.docfile();
        
    }
    
    
}
