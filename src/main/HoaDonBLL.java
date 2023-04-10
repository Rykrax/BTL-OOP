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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class HoaDonBLL {
	public ArrayList<HoaDon> list = new ArrayList<>();
	
	public void them(HoaDon hd) {
		list.add(hd);
	}
	
	public  void hienDanhSach() {
		for(HoaDon x: list) {
			System.out.println(x.toString());
		}
	}
//	public  void hien2() throws IOException
//	{
//		for(HoaDon x: docfile())
//		{
//			System.out.println(x);
//		}
//	}
	public void ghiFile() throws FileNotFoundException, IOException {
		FileOutputStream f= new FileOutputStream("HoaDon.dat");
		ObjectOutputStream oos = new ObjectOutputStream (f);
		try {
			for(HoaDon x: list) {
				oos.writeObject(x);
			}
		} catch (Exception e) {
			System.out.println("ghi file fail!");
		} finally {
			f.close();
			oos.close();
		}
	}
	public ArrayList<HoaDon> docFile() throws FileNotFoundException, IOException
	{
		FileInputStream fi = new FileInputStream("HoaDoa.dat");
		ObjectInputStream ooi = new ObjectInputStream (fi);
		ArrayList<HoaDon> lhd = new ArrayList<>();
		HoaDon a= new HoaDon();
		try {
			while(fi.available()>0)
			{
				a=(HoaDon)ooi.readObject();
				lhd.add(a);
				a= new HoaDon();
			}
		} catch (Exception e) {
			System.out.println("ghi file fail!");
		} finally {
			fi.close();
			ooi.close();
		}
		return lhd;
	}
}
