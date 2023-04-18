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
	public int check2(String name) {
		for (int i = 0; i < dskh.size(); i++) {
			if (dskh.get(i).getHoten().compareTo(name) == 0) {
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

	public void xoa() {
		Scanner sc = new Scanner(System.in); 
		System.out.println(" Nhap ma khach hang: ");
		String maKH;
		maKH = sc.nextLine();
		int index = check(maKH);
		if (index == -1) {
			System.out.println("Khong tim thay thong tin khach hang");
		} else {
			dskh.remove(index);
			System.out.println("Xoa thanh cong");
		}
	}
	public void hienDanhSach() {
		if (dskh.isEmpty()) {
			System.out.println("Danh sach rong!");
		} else {
			for (KhachHang x : dskh) {
				System.out.println(x.toString());
			}
		}
	}
	public void hienDanhSach(ArrayList<KhachHang> dskh) {
		if (dskh.isEmpty()) {
			System.out.println("Danh sach rong!");
		} else {
			for (KhachHang x : dskh) {
				System.out.println(x.toString());
			}
		}
	}

	public void search() {
		Scanner sc = new Scanner(System.in); 
		String name; 
		System.out.print("Nhap ten khach hang: ");
		name = sc.nextLine();
		if (check2(name) == -1) {
			System.out.println("Khong tim thay thong tin khach hang");
		} else {
			for (KhachHang x : dskh) {
				if (x.getHoten().compareTo(name) == 0) {
					System.out.println(x.toString());
				}
			}
		}
	}

	public void sapXep() {
		Collections.sort(this.dskh, new Comparator<KhachHang>() {
			@Override
			public int compare(KhachHang kh1, KhachHang kh2) {
				if (kh1.getName().compareTo(kh2.getName()) > 0) {
					return 1;
				} else return -1;
			}	
		});
	}
	public void ghiFile(ArrayList<KhachHang> dskh) throws FileNotFoundException, IOException {
		FileOutputStream fo= new FileOutputStream("KhachHang.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fo);
		try {
			for(KhachHang x : dskh) {
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
	public ArrayList<KhachHang> docfile() throws FileNotFoundException, IOException {
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
