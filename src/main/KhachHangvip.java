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
public class KhachHangvip extends KhachHang implements Serializable{
    private long billtoday;
    private String rankvip;
    private int dtl;

    public KhachHangvip(long billtoday, String rankvip, int dtl, String maKH, String hoten, String gt, String cmnd, String sodt, String diachi) {
        super(maKH, hoten, gt, cmnd, sodt, diachi);
        this.billtoday = billtoday;
        this.rankvip = rankvip;
        this.dtl = dtl;
    }

    public KhachHangvip() {
        super();
    }public void themdtl(long dtl)
    {
        this.dtl+=dtl/1000000;
    }
    
//    public void updatedtl(){
//        this.dtl+=billtoday/1000000;
//    }
//----------------------  
    public void updaterank()
    {
          if(dtl>=0&&dtl<=3)
          {
              rankvip="D";
          }
          else if (dtl>=4&&dtl<=6)
          {
              rankvip="C";
          }
          else if (dtl>=7&&dtl<=9)
          {
              rankvip="B";
          }
          else rankvip="A";
    }
    public void nhap()
    {
        Scanner sc= new Scanner (System.in);
        super.nhap();
        System.out.print(" So tien mua hang hom nay : ");
        billtoday=Long.parseLong(sc.nextLine());
        dtl+=billtoday/1000000;
         
    }

    public String getRankvip() {
        return rankvip;
    }

    @Override
    public String toString() {
        return "Khach Hang Vip"+super.toString()+" So tien da mua hang tai shop "+billtoday+" Diem tich luy "+dtl+" Rank "+rankvip;
    }
    
   
    
}
