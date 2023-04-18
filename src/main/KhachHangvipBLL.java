/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class KhachHangvipBLL {
    public List<KhachHangvip> arr = new ArrayList<>();
    public int checkma(String ma)
    {
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i).getMaKH().compareTo(ma)==0)
            {
                return i;
            }
        }
        return -1;
    }
    public void nhapttkhachvip()
    {
        Scanner sc= new Scanner(System.in);
        System.out.print("nhap so luong khach den mua hang : ");
        int sl=Integer.parseInt(sc.nextLine());
        
       String ma;
       for(int i=0;i<sl;i++)
       {
           System.out.print("Nhap ma khach hang : ");
           ma=sc.nextLine();
           if(checkma(ma)==-1)
           {
               KhachHangvip a= new KhachHangvip();
               a.setMaKH(ma);
               a.nhap();
             
             a.updaterank();
               arr.add(a);
           }
           else 
           {
               System.out.print("So tien mua hang hom nay cua "+arr.get(checkma(ma)).getHoten());
               long biltoday=Long.parseLong(sc.nextLine());
               arr.get(checkma(ma)).themdtl(biltoday);
                arr.get(checkma(ma)).updaterank();
               
           }
       }
    }
    public void hien()
    {
        for(KhachHangvip x:arr)
        {
            System.out.println(x.toString());
        }
    }
    public void sxbyname()
    {
        Collections.sort(arr, new Comparator<KhachHangvip>(){
            @Override
            public int compare(KhachHangvip o1, KhachHangvip o2) {
                if(o1.getName().compareTo(o2.getName())>0)
                {
                    return 1;
                }
                else return -1;
            }
            
        });
    }
    public void sxbyrank()
    {
        Collections.sort(arr, new Comparator<KhachHangvip>(){
            @Override
            public int compare(KhachHangvip o1, KhachHangvip o2) {
                if(o1.getRankvip().compareTo(o2.getRankvip())>0)
                {
                    return 1;
                }
                else  return -1;
            }
            
        });
    }
    public void search()
    {
        Scanner sc= new Scanner (System.in);
        System.out.print("Nhap ma khach hang ban muon tim: ");
        String ma=sc.nextLine();
        if(checkma(ma)==-1)
        {
            System.out.println("Khong co thong tin gi ve khach hang ");
        }
        else System.out.println(arr.get(checkma(ma)).toString());
    }
    
    public static void main(String[] args) {
        KhachHangvipBLL a= new KhachHangvipBLL();
        a.nhapttkhachvip();
        a.hien();
        a.search();
    }
}
