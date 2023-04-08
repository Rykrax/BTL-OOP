package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class DienThoaiBLL {
	public ArrayList<DienThoai> dsdt = new ArrayList<>();

	public int check(String s) {
		for (int i = 0; i < dsdt.size(); i++) {
			if (dsdt.get(i).getTenSP().compareTo(s) == 0) {
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
				dsdt.get(index).updateSoLuong(cnt);
				System.out.println("Them thanh cong");
			}
		} else {
			DienThoai dt = new DienThoai(name);
			dt.nhap();
			dsdt.add(dt);
		}
	}

	public void hienDanhSach(ArrayList<DienThoai> dsdt) throws IOException {
		if (dsdt.isEmpty()) {
			System.out.println("Danh sach rong!");
		} else {
			for (DienThoai x : dsdt) {
				System.out.println(x.toString());
			}
		}
	}

	public DienThoai searchByName () throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ten dien thoai can tim: ");
		String tensp = sc.nextLine();
		for(DienThoai x:docfile()) {
			if(x.getTenSP().compareTo(tensp)==0) {
				return x;
			}
		}
		return null;	
	}


	public void xoa() throws IOException {
		int size=dsdt.size(); 
		dsdt.remove(searchByName());
		if(size==dsdt.size())
			System.out.print("Khong co ten nao nhu the trong danh sacch nen khong the xoa \n");
	}


	public void sapXepGiaTienGiamDan() {
		Collections.sort(this.dsdt, new Comparator<DienThoai>() {
			@Override
			public int compare(DienThoai dt1, DienThoai dt2) {
				if (dt1.getCoin() < dt2.getCoin()) {
					return 1;
				} else if (dt1.getCoin() > dt2.getCoin()) {
					return -1;
				} else return 0;
			}
		});
	}

	public void sapXepGiaTienTangDan() {
		Collections.sort(this.dsdt, new Comparator<DienThoai>() {
			@Override
			public int compare(DienThoai dt1, DienThoai dt2) {
				if (dt1.getCoin() > dt2.getCoin()) {
					return 1;
				} else if (dt1.getCoin() < dt2.getCoin()) {
					return -1;
				} else return 0;
			}
		});
	}
	public void ghifile() throws FileNotFoundException, IOException {
		FileOutputStream f= new FileOutputStream("Dien Thoai2.dat");
		ObjectOutputStream oos = new ObjectOutputStream(f); 
		try {
			for(SanPham x: dsdt)
			{
				oos.writeObject(x);
			}
			//   System.out.println("Ghi File succed ");
		} catch (Exception e) {
			System.out.println("Ghi File loi ");
		} finally {
			if(oos!=null) oos.close();
			if(f!=null) f.close();
		}
	}
	public ArrayList<DienThoai> docfile() throws FileNotFoundException, IOException
	{
		FileInputStream fi = new FileInputStream("Dien Thoai2.dat");
		ObjectInputStream ooi = new ObjectInputStream(fi); 
		ArrayList<DienThoai> kq = new ArrayList<>();
		DienThoai dt=null;

		try {
			while(fi.available()>0)
			{
				dt=(DienThoai)ooi.readObject();
				kq.add(dt);
			}
		} catch (Exception e) {
			System.out.println(" File khong ton tai : ");
			//return null;
		} finally {
			ooi.close();
			fi.close();
		}
		return kq;
	}
}
