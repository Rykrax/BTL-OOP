/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class HoaDon  implements Serializable {
    //private String note;
    private int soluongmh;
    private Date ngaylap;
    private KhachHang kh;
    private HashMap<SanPham,Integer> sp = new HashMap<>();// lay ten lay coi lay so luong
    private NhanVien nv;

    public HoaDon() {
        
    }
    public void taoHoaDon() throws ParseException, IOException, FileNotFoundException, ClassNotFoundException
    {
        SimpleDateFormat df = new SimpleDateFormat("dd-mm-yyyy");
        Scanner sc = new Scanner (System.in);
        System.out.print("Ngay lap : ");
        ngaylap=df.parse(sc.nextLine());
        System.out.println("Danh sach khach hang : ");
        new KhachHangBLL().hien();
        System.out.print(" Khach Hang ");
         
        do
        {
           
            kh=new KhachHangBLL().searchbyma();
        }while(kh==null);
        System.out.println("Danh sach Nhan Vien trong cua hang");
        new NhanVienBLL().hien();
        System.out.print("  Ten Nhan vien lap don : ");
        do
        {
            nv=new NhanVienBLL().searchbyname();
        }while(nv==null);
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
                    System.out.println("Danh sach dien thoai co trong cua hang  : ");
                    new DanhSachDienThoai().hienDanhSach();
                    SanPham a = new SanPham();
                    a=new DanhSachDienThoai().searchByName();
                    System.out.println(a);
                    System.out.print("So luong : ");
                    int sl=Integer.parseInt(sc.nextLine());
                    sp.put(a, sl);
                    break;
                }
                case 2: 
                {
                    System.out.println("Danh sach cac phu kien ");
                    new PhuKienBLL().hienDanhSach();
                    SanPham b= new SanPham ();
                    b=new PhuKienBLL().searchbyname();
                    System.out.println(b);
                        System.out.print("So luong : ");
                    int sl=Integer.parseInt(sc.nextLine());
                    sp.put(b, sl);
                    break;
                }
            }
           System.out.print("Co them san pham nua khong : ");
                String rep=sc.nextLine();
                if(rep.compareTo("khong")==0||rep.compareTo("ko")==0||rep.compareTo("k")==0)
                {
                    break;
                }
        }while(true);
    }
//    public String dssp()
//    {
//         for(SanPham x: sp.keySet())
//         {
//             
//         }
//    }
    public String tongbill()
    {
          Locale lc = new Locale("vi","VN");
	NumberFormat numf = NumberFormat.getInstance(lc);
        double sum=0;
      String ds= new String();
        for(SanPham x : sp.keySet())
        {
            ds+=x.getTenSP()+"    "+sp.get(x)+"\n";
            sum+=(x.getCoin()*sp.get(x));
        }
        return ds+" tong bill "+numf.format(sum);
    }
    @Override
    public String toString() {
          Locale lc = new Locale("vi","VN");
	NumberFormat numf = NumberFormat.getInstance(lc);
        SimpleDateFormat df= new SimpleDateFormat("dd-mm-yyyy");
        return "  Hoa Don "+"  Ngay "+df.format(ngaylap)+ " Nguoi lap hoa don "+nv.getHoten()+" Khach Hang "+kh.getHoten()+" \nDanh sach Hoa don \n "+tongbill();
    }
 
    public static void main(String[] args) throws ParseException, IOException, FileNotFoundException, ClassNotFoundException {
   
        HoaDon a= new HoaDon();
        a.taoHoaDon();
       System.out.println( a.toString());
 
    }
    
}
   
// toi can so luong mat hang ma khach do mua -> cho vong lap for va cho vao list
// toi can tao ra 1 san pham day mua  bao nhieu cai 
