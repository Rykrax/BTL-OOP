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
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class KhachHangBLL {
    ArrayList<KhachHang> lkh= new ArrayList<>();
    public  boolean check(String makh)
    {
        for(KhachHang x : lkh)
        {
           if(x.getMakh().compareTo(makh)==0)
            {
                return false;
            }
        }
        return true;
    }
    public void themkh()// kiem tra xem neu co ma khach hang nhu the thi bat nhap lai
    {
       Scanner sc= new Scanner(System.in);
       
       String makh;
       System.out.print("So luong khach hang : ");
       int slkh=Integer.parseInt(sc.nextLine());
       int i=1;
       while(i<=slkh)
       {
           do
       {
           System.out.print(" Ma khach hang : ");
            makh=sc.nextLine();
       }while(!check(makh));
           KhachHang a= new KhachHang ();
           
           a.nhap();
           a.setMakh(makh);
           lkh.add(a);
           i++;
       }
       
        
    }
    public void hien()
    {
        for(KhachHang x:lkh)
        {
            System.out.println(x.toString());
        }
    }
    public KhachHang searchbyma() throws IOException
    {
        Scanner sc= new Scanner (System.in);
        System.out.print(" Nhap ma khach hang  ");
        String makh=sc.nextLine();
        for(KhachHang x:docfile())
        {
            if(x.getMakh().compareTo(makh)==0)
            {
                return x;
            }
        }
        return null;
                    
    } 
    public void ghifile() throws FileNotFoundException, IOException
    {
        FileOutputStream fo= new FileOutputStream("KhachHang.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fo);
          try {
           for(KhachHang x : lkh)
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
    public ArrayList<KhachHang> docfile() throws FileNotFoundException, IOException
    {
        FileInputStream fi= new FileInputStream("KhachHang.dat");
        ObjectInputStream ooi = new ObjectInputStream(fi);
        ArrayList<KhachHang> kq= new ArrayList<>();
        KhachHang nv=null;
        try {
            while(fi.available()>0)
            {
                nv=(KhachHang)ooi.readObject();
                kq.add(nv);
                
            }
            System.out.println("Doc File thanh cong ");
        } catch (Exception e) {
            System.out.println("File khong ton tai : ");
            
        } finally {
            fi.close();
            ooi.close();
        }
        return kq;
    }
    public static void main(String[] args) throws IOException {
        KhachHangBLL a= new KhachHangBLL();
//       a.themkh();
//       a.hien();
//       a.ghifile();
       for(KhachHang x: a.docfile())
       {
           System.out.println(x.toString());
       }
       
        
    }
    }
