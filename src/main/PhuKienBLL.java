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

public class PhuKienBLL {
	public ArrayList<PhuKien> dspk= new ArrayList<>();
	public int check(String s) {
		for (int i = 0; i < dspk.size(); i++) {
			if (dspk.get(i).getTenSP().compareTo(s) == 0) {
				return i;
			}
		}
		return -1;
	}

	public void them() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ten san pham: ");
		String name = sc.nextLine();
		int index = check(name);
		if (index != -1) {
			System.out.println("San pham da ton tai, ban co muon them so luong vao kho?"
					+ "\n1.Co"
					+ "\n2.Khong");
			int n = Integer.parseInt(sc.nextLine());
			if (n == 1) {
				System.out.print("Nhap so luong: ");
				int cnt = Integer.parseInt(sc.nextLine());
				dspk.get(index).updateSoLuong(cnt);
				System.out.println("Them thanh cong");
			}
		} else {
			PhuKien pk = new PhuKien(name);
			pk.nhap();
			dspk.add(pk);
		}
	}
	public void hienDanhSach(ArrayList<PhuKien> dspk) throws IOException, FileNotFoundException, ClassNotFoundException {
		if (dspk.isEmpty()) {
			System.out.println("Danh sach rong!");
		} else {
			for (PhuKien x : dspk) {
				System.out.println(x.toString());
			}
		}
	}
	public void rimu() throws IOException, FileNotFoundException, ClassNotFoundException
	{
		int size=dspk.size();

		dspk.remove(searchbyname());

		if(size==dspk.size())
			System.out.print("Khong co ten nao nhu the trong danh sacch nen khong the xoa \n");
	}
	public void sxtheocoin()
	{
		Collections.sort(dspk, new Comparator<SanPham>(){
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


			//                obw.writeObject(dspk);
			//                obw.flush();
			for(PhuKien x: dspk)
			{
				obw.writeObject(x);
			}




			//    System.out.println("ghi file thanh cong");
		} catch (IOException e)
		{
			System.out.print("File ko ton tai : \n");
		}
		finally{

			if(obw!=null) obw.close();
			if(fo!=null) fo.close();
		}

	}
	public ArrayList<PhuKien> docfile() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		FileInputStream fi =new FileInputStream("PhuKien2.bin");
		ObjectInputStream obi = new ObjectInputStream(fi);
		ArrayList<PhuKien> kp= new ArrayList<>();
		PhuKien pk= null;
		try {
			while(fi.available()>0)
			{

				pk=(PhuKien)obi.readObject();
				kp.add(pk);

			}
		} catch (Exception e) {
			System.out.println(" File khong ton tai ");
		} finally {
			fi.close();
			obi.close();
		}
		return kp;
	}
	public PhuKien searchbyname() throws IOException, FileNotFoundException, ClassNotFoundException
	{
		Scanner sc= new Scanner(System.in);
		System.out.print("Nhap vao ten phu kien  : ");
		String sten=sc.nextLine();

		for(PhuKien x:docfile())
		{
			if(x.getTenSP().compareTo(sten)==0)
			{
				return x;
			}

		}

		return null;

	}
}

