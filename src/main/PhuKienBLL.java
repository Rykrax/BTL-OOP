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
public class PhuKienBLL  {
    List <PhuKien> lsp= new ArrayList<>();
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
        for(PhuKien x: lsp)
        {
            System.out.println(x.toString());
        }
    }
    public PhuKien searchbyname()
    {
        System.out.print("Nhap vao ten phu kien  : ");
        String sten=sc.nextLine();
      
        for(PhuKien x:lsp)
        {
            if(x.getTenSP().compareTo(sten)==0)
            {
                return x;
            }
            
        }
       
        return null;
       
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
          Collections.sort(lsp, new Comparator<PhuKien>(){
              @Override
              public int compare(PhuKien o1, PhuKien o2) {
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
        FileOutputStream fo =new FileOutputStream("PhuKien.dat");
        ObjectOutputStream obw = new ObjectOutputStream (fo);
        try {
          
            for(PhuKien x: lsp)
            {
                obw.writeObject(x);
            }
        } catch (IOException e)
                {
                    System.out.print("File ko ton tai : \n");
                }
        finally{
            System.out.println("Ghi file thanh cong ");
            if(obw!=null) obw.close();
            if(fo!=null) fo.close();
            
        }
    }
    public void docfile() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        FileInputStream fi =new FileInputStream("PhuKien.dat");
        ObjectInputStream obi = new ObjectInputStream(fi);
      
        Object pk= null;
       while(fi.available()>0)
       {
        
               pk=obi.readObject();
               System.out.println(pk);
       
       }
        fi.close();
        obi.close();
    }

   
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException  {
        PhuKienBLL a = new PhuKienBLL();
      a.nhap();
       a.hien();
        a.ghifile();
       a.docfile();
       
    }
}

