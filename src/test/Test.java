package test;

import java.util.ArrayList;
import java.util.Scanner;
import main.DienThoaiBLL;
import main.KhachHangBLL;
import main.NhanVienBLL;
import main.PhuKienBLL;
import main.KhachHang;
import main.NhanVien;
import main.DienThoai;
import main.PhuKien;
import java.io.IOException;

public class Test {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		DienThoaiBLL dsdt = new DienThoaiBLL();
		PhuKienBLL dspk = new PhuKienBLL();
		KhachHangBLL dskh = new KhachHangBLL();
		NhanVienBLL dsnv = new NhanVienBLL();
		int key, option, n, m;

		loop: while(true) {
			System.out.print("==================MENU=================="
					+ "\n1. Nhap thong tin khach hang/nhan vien"
					+ "\n2. Nhap thong tin san pham"
					+ "\n3. Hien thi danh sach"
					+ "\n4. Chinh sua danh sach"
					+ "\n5. Tim kiem"
					+ "\n6. Sap xep danh sach"
					+ "\n7. Doc/ghi du lieu file"
					+ "\n0. Exit"
					+ "\n\nNhap lua chon: ");
			while(true) {
				try {
					key = Integer.parseInt(sc.nextLine());
					if (key < 0 || key > 7) {
						System.out.print("Lua chon khong phu hop. Hay lua chon lai: ");
						continue;
					}
					break;
				} catch (Exception e) {
					System.out.println("Du lieu khong hop le! Hay lua chon lai: ");
				}
			}
			switch(key) {
			case 1:
				System.out.println("Ban muon nhap thong tin cua: "
						+ "\n1.Khach hang"
						+ "\n2.Nhan vien");
				option = Integer.parseInt(sc.nextLine());
				if (option == 1) {
					System.out.print("Nhap so luong ban muon them: ");
					n = Integer.parseInt(sc.nextLine());
					for (int i = 0; i < n; i++) {
						dskh.them();
					}
				} else if (option == 2) {
					System.out.print("So luong nhan vien trong cua hang: ");
					n = Integer.parseInt(sc.nextLine());
					for (int i = 0; i < n; i++) {
						dsnv.them();
					}
				}
				break;
			case 2:
				System.out.println("Ban muon nhap thong tin cua: "
						+ "\n1.Dien thoai"
						+ "\n2.Phu kien");
				option = Integer.parseInt(sc.nextLine());
				if (option == 1) {
					System.out.print("Nhap so luong dien thoai co trong cua hang: ");
					n = Integer.parseInt(sc.nextLine());
					for (int i = 0; i < n; i++) {
						dsdt.them();
					}
				} else if (option == 2) {
					System.out.print("Nhap so luong phu kien co trong cua hang: ");
					n = Integer.parseInt(sc.nextLine());
					for (int i = 0; i < n; i++) {
						dspk.them();
					}
				}
				break;
			case 3:
				System.out.println("Chon danh sach muon xem:"
						+ "\n1. Danh sach khach hang"
						+ "\n2. Danh sach nhan vien"
						+ "\n3. Danh sach dien thoai"
						+ "\n4. Danh sach phu kien");
				option = Integer.parseInt(sc.nextLine());
				switch(option) {
				case 1:
					ArrayList<KhachHang> tmp1 = dskh.dskh;
					dskh.hienDanhSach(tmp1);
					break;
				case 2:
					ArrayList<NhanVien> tmp2 = dsnv.dsnv;
					dsnv.hienDanhSach(tmp2);
					break;
				case 3:
					ArrayList<DienThoai> tmp3 = dsdt.dsdt;
					dsdt.hienDanhSach(tmp3);
					break;
				case 4:
					ArrayList<PhuKien> tmp4 = dspk.dspk;
					dspk.hienDanhSach(tmp4);
					break;
				}
				break;
			case 4:
				System.out.println("Chon danh sach muon chinh sua:"
						+ "\n1. Danh sach khach hang"
						+ "\n2. Danh sach nhan vien"
						+ "\n3. Danh sach dien thoai"
						+ "\n4. Danh sach phu kien");
				option = Integer.parseInt(sc.nextLine());
				switch(option) {
				case 1:
				case 2:
				case 3:
					System.out.print("Ban muon xoa(1)/them(2)? ");
					m = Integer.parseInt(sc.nextLine());
					if (m == 1) {
						dsdt.xoa();
					} else {
						dsdt.them();
					}
					break;
				case 4:
				}
				break;
			case 5:
				System.out.println("Ban muon tim kiem:"
						+ "\n1. Khach hang"
						+ "\n2. Nhan vien"
						+ "\n3. Dien thoai"
						+ "\n4. Phu kien");
				option = Integer.parseInt(sc.nextLine());
				switch(option) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					dsdt.search();
					break;
				case 4:
					dspk.search();
					break;
				}
				break;
			case 0:
				System.out.println("Da thoat chuong trinh.");
				break loop;
			}
		}
	}
}
