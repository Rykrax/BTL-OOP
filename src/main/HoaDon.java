/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class HoaDon {
    //private String note;
    
    private Date ngaylap;
    private KhachHang kh;
    private SanPham sp;// lay ten lay coi lay so luong
    private NhanVien nv;

    public HoaDon() {
        
    }
    public void nhap() throws ParseException, IOException, FileNotFoundException, ClassNotFoundException
    {
        SimpleDateFormat df = new SimpleDateFormat("dd-mm-yyyy");
        Scanner sc = new Scanner (System.in);
        System.out.print("Ngay lap : ");
        ngaylap=df.parse(sc.nextLine());
        System.out.print(" Khach Hang ");
        do
        {
           
            kh=new KhachHangBLL().searchbyma();
        }while(kh==null);
        System.out.print("  Ten Nhan vien lap don : ");
        do
        {
            nv=new NhanVienBLL().searchbyname();
        }while(nv==null);
//        System.out.print("Ghi chu : ");
//        note=sc.nextLine();
        do
        {
            System.out.println("1.Dien Thoai ");
            System.out.println("2.PhuKien ");
            System.out.print("Nhap vao lua chon loai san pham : ");
            int lc=Integer.parseInt(sc.nextLine());
            switch(lc)
            {
                case 1:
                {
                    sp=new DanhSachDienThoai().searchByName();
                    break;
                }
                case 2: 
                {
                    sp=new PhuKienBLL().searchbyname();
                    break;
                }
                default : System.out.print("Hay nhap lai lua chon : ");
                    
            }
        }while(sp==null);
       
        
    }

    @Override
    public String toString() {
        return "  Hoa Don "+"  Nguoi lap hoa don "+nv.toString()+" Khach Hang "+kh.toString()+" tong gia tri hoa don "+sp.tinhgia();
    }
    
    
}
