/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class PhuKienBLL {
    ArrayList <SanPham> lsp= new ArrayList<>();
Scanner sc= new Scanner (System.in);
    public PhuKienBLL() {
    }
    public  void nhap()
    {
        
        System.out.print("so luong phu kien co trong cua hang : ");
        int sl=Integer.parseInt(sc.nextLine());
        int i=0;
        while(true)
        {
            PhuKien a= new PhuKien();
        a.nhap();
        lsp.add(a);
        i++;
        if(i==sl) break;
        
        
        }
    }
    public void hien()
    {
        for(SanPham x: lsp)
        {
            System.out.println(x.toString());
        }
    }
    public String searchbyname()
    {
        System.out.print("Nhap vao ten phu kien  : ");
        String sten=sc.nextLine();
      
        for(SanPham x:lsp)
        {
            if(x.getTenSP().compareTo(sten)==0)
            {
                return x.toString();
            }
            
        }
       
        return "Khong co phu kien nhu the!";
       
    }
    public void rimu()
    {
        int size=lsp.size();
            
            lsp.remove(searchbyname());
            
            if(size==lsp.size())
                   System.out.print("Khong co ten nao nhu the trong danh sacch nen khong the xoa \n");
    }
    public void sxtheocoin()
    {
          Collections.sort(lsp, new Comparator<SanPham>(){
              @Override
              public int compare(SanPham o1, SanPham o2) {
                  if(o1.getCoin()<o2.getCoin())
                  {
                      return -1;
                  }
                  else return 1;
              }
              
          });
    }
    public void ghifile() throws FileNotFoundException, IOException
    {
        FileOutputStream fo =new FileOutputStream("PhuKien2.bin");
        ObjectOutputStream obw = new ObjectOutputStream (fo);
        try {
          
        
//                obw.writeObject(lsp);
//                obw.flush();
    for(SanPham x: lsp)
    {
        obw.writeObject(x);
    }
        
        
                
              
            System.out.println("ghi file thanh cong");
        } catch (IOException e)
                {
                    System.out.print("File ko ton tai : \n");
                }
         finally{
            
            if(obw!=null) obw.close();
            if(fo!=null) fo.close();
        }
        
    }
    public void docfile() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        FileInputStream fi =new FileInputStream("PhuKien2.bin");
        ObjectInputStream obi = new ObjectInputStream(fi);
      
        Object pk= null;
        try {
              while(fi.available()>0)
       {
        
               pk=obi.readObject();
               System.out.println(pk.toString());
       
       }
        } catch (Exception e) {
            System.out.println(" File khong ton tai ");
        } finally {
            fi.close();
            obi.close();
        }
        
    }

   
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException  {
        PhuKienBLL a = new PhuKienBLL();
         a.nhap();
         System.out.println();
         a.hien();  System.out.println();
         
      a.ghifile();
            a.docfile();
       
    }
}

