package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class NhanVienBLL {
	public ArrayList<NhanVien> dsnv = new ArrayList<>();

	public int check(String id) {
		for (int i = 0; i < dsnv.size(); i++) {
			if (dsnv.get(i).getMaNV().compareTo(id) == 0) {
				return i;
			}
		}
		return -1;
	}
	public int check2(String name) {
		for (int i = 0; i < dsnv.size(); i++) {
			if (dsnv.get(i).getHoten().compareTo(name) == 0) {
				return i;
			}
		}
		return -1;
	}
	public void them() {
		Scanner sc = new Scanner(System.in); 
		String maNV; 
		System.out.print("Ma nhan vien: ");
		maNV = sc.nextLine();
		while(true) {
			if (check(maNV) != -1) {
				System.out.print("Ma khach hang da ton tai! ");
			} else break;
			System.out.print("Nhap lai ma khach hang: ");
			maNV = sc.nextLine();
		}
		NhanVien nv = new NhanVien(maNV);
		nv.nhap();
		dsnv.add(nv);
	}
	
	public void xoa() {
		Scanner sc = new Scanner(System.in); 
		System.out.println("Nhap ma nhan vien: ");
		String maNV;
		maNV = sc.nextLine();
		int index = check(maNV);
		if (index == -1) {
			System.out.println("Khong tim thay thong tin nhan vien");
		} else {
			dsnv.remove(index);
			System.out.println("Xoa thanh cong");
		}
	}
	public void hienDanhSach() {
		if (dsnv.isEmpty()) {
			System.out.println("Danh sach rong!");
		} else {
			for(NhanVien x : dsnv) {
				System.out.println(x.toString());
			}
		}
	}
	public void hienDanhSach(ArrayList<NhanVien> dsnv) {
		if (dsnv.isEmpty()) {
			System.out.println("Danh sach rong!");
		} else {
			for(NhanVien x : dsnv) {
				System.out.println(x.toString());
			}
		}
	}
	public void sapXep() {
		Collections.sort(this.dsnv, new Comparator<NhanVien>() {
			@Override
			public int compare(NhanVien nv1, NhanVien nv2) {
				if (nv1.getName().compareTo(nv2.getName()) > 0) {
					return 1;
				} else return -1;
			}	
		});
	}
	public void search() {
		Scanner sc = new Scanner(System.in); 
		String name; 
		System.out.print("Nhap ten nhan vien: ");
		name = sc.nextLine();
		if (check2(name) == -1) {
			System.out.println("Khong tim thay thong tin khach hang");
		} else {
			for (NhanVien x : dsnv) {
				if (x.getHoten().compareTo(name) == 0) {
					System.out.println(x.toString());
				}
			}
		}
	}
	public void ghiFile(ArrayList<NhanVien> dsnv) throws FileNotFoundException, IOException {
		FileOutputStream fo= new FileOutputStream("NhanVien.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fo); 
		try {
			for(Person x : dsnv) {
				oos.writeObject(x);
			}
			System.out.println("Ghi file thanh cong");
		} catch (Exception e) {
			System.out.println("Da xay ra loi trong qua trinh ghi file!!!");
		} finally {
			if(fo!=null) fo.close();
			if(oos!=null) oos.close();
		}

	}
	public ArrayList<NhanVien> docfile() throws FileNotFoundException, IOException {
		FileInputStream fi =new FileInputStream("NhanVien.dat");
		ObjectInputStream ooi= new ObjectInputStream(fi);
		ArrayList<NhanVien> kq= new ArrayList<>();
		NhanVien nv=null;
		try {
			while(fi.available()>0) {
				nv=(NhanVien)ooi.readObject();
				kq.add(nv);

			}
			// System.out.println("Doc File thanh cong ");
		} catch (Exception e) {
			System.out.println("File khong ton tai: ");
		} finally {
			fi.close();
			ooi.close();
		}
		return kq;
	}
}
