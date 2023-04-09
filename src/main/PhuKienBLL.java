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
	public void hienDanhSach() {
		if (dspk.isEmpty()) {
			System.out.println("Danh sach rong!");
		} else {
			for (PhuKien x : dspk) {
				System.out.println(x.toString());
			}
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
	public void xoa() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ten muon xoa: ");
		String name = sc.nextLine();
		int index = check(name);
		if (index != -1) {
			dspk.remove(index);
			System.out.println("Xoa thanh cong");
		} else {
			System.out.println("Khong tim thay ten trong danh sach");
		}
	}

	public void search() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ten san pham muon tim: ");
		String name = sc.nextLine();
		int index = check(name);
		if (index != -1) {
			System.out.println(dspk.get(index).toString());
		} else {
			System.out.println("Khong tim thay ten trong danh sach");
		}
	}
	public void sapXepGiaTienGiamDan() {
		Collections.sort(this.dspk, new Comparator<PhuKien>() {
			@Override
			public int compare(PhuKien pk1, PhuKien pk2) {
				if (pk2.getCoin() < pk2.getCoin()) {
					return 1;
				} else return -1;
			}
		});
	}

	public void sapXepGiaTienTangDan() {
		Collections.sort(this.dspk, new Comparator<PhuKien>() {
			@Override
			public int compare(PhuKien pk1, PhuKien pk2) {
				if (pk1.getCoin() > pk2.getCoin()) {
					return 1;
				} else return -1;
			}
		});
	}
	public void ghiFile(ArrayList<PhuKien> dspk) throws FileNotFoundException, IOException { 
		FileOutputStream fo = new FileOutputStream("PhuKien.bin");
		ObjectOutputStream obw = new ObjectOutputStream (fo);
		try {
			for(PhuKien x: dspk) {
				obw.writeObject(x);
			}
			System.out.println("Ghi file thanh cong");
		} catch (Exception e) {
			System.out.println("Da xay ra loi trong qua trinh ghi file!!!");
		} finally{
			if(obw!=null) obw.close();
			if(fo!=null) fo.close();
		}
	}
	public ArrayList<PhuKien> docfile() throws FileNotFoundException, IOException, ClassNotFoundException
	{
		FileInputStream fi =new FileInputStream("PhuKien.bin");
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

