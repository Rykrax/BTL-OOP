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
	public ArrayList<NhanVien> dsnv = new ArrayList<>();

	public boolean check(String s) {
		for(NhanVien x : dsnv) {
			if(x.getMaNV().compareTo(s)==0)
				return true;
		}
		return false;
	}
	public void them() {
		Scanner sc = new Scanner(System.in); 
		String maNV; 
		System.out.print("Ma nhan vien: ");
		maNV = sc.nextLine();
		while(true) {
			if (check(maNV)) {
				System.out.print("Ma nhan vien da ton tai! ");
			} else break;
			System.out.print("Nhap lai ma nhan vien: ");
			maNV = sc.nextLine();
		}
		NhanVien nv = new NhanVien(maNV);
		nv.nhap();
		dsnv.add(nv);
	}
	public void hienDanhSach(ArrayList<NhanVien> dsnv) throws IOException {
		if (dsnv.isEmpty()) {
			System.out.println("Danh sach rong!");
		} else {
			for(NhanVien x : dsnv) {
				System.out.println(x.toString());
			}
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
			for(Person x : dsnv)//lua ghi vao file laf lop cha
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
}
