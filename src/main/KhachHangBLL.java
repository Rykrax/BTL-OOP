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
import java.util.List;
import java.util.Scanner;

public class KhachHangBLL {
	public ArrayList<KhachHang> dskh= new ArrayList<>();
	public int check(String id) {
		for (int i = 0; i < dskh.size(); i++) {
			if (dskh.get(i).getMaKH().compareTo(id) == 0) {
				return i;
			}
		}
		return -1;
	}
	public void them() {
		Scanner sc = new Scanner(System.in); 
		String maKH; 
		System.out.print("Ma khach hang: ");
		maKH = sc.nextLine();
		while(true) {
			if (check(maKH) != -1) {
				System.out.print("Ma khach hang da ton tai! ");
			} else break;
			System.out.print("Nhap lai ma khach hang: ");
			maKH = sc.nextLine();
		}
		KhachHang kh = new KhachHang(maKH);
		kh.nhap();
		dskh.add(kh);
	}
	public void hienDanhSach(ArrayList<KhachHang> dskh) throws IOException {
		if (dskh.isEmpty()) {
			System.out.println("Danh sach rong!");
		} else {
			for (KhachHang x : dskh) {
				System.out.println(x.toString());
			}
		}
	}

//	public void 
	public void ghifile() throws FileNotFoundException, IOException
	{
		FileOutputStream fo= new FileOutputStream("KhachHang.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fo);
		try {
			for(KhachHang x : dskh)
			{
				oos.writeObject(x);
			}
			System.out.println("  ghi file succed ");
		} catch (Exception e) {
			System.out.println(" Khong the ghi file ");
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
			// System.out.println("Doc File thanh cong ");
		} catch (Exception e) {
			System.out.println("File khong ton tai : ");

		} finally {
			fi.close();
			ooi.close();
		}
		return kq;
	}
}
