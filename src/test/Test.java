package test;

import java.util.ArrayList;
import java.util.Scanner;
import main.DienThoaiBLL;
import main.HoaDon;
import main.HoaDonBLL;
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
		HoaDonBLL list = new HoaDonBLL();
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
					+ "\n8. In phieu thanh toan"
					+ "\n0. Exit"
					+ "\n\nNhap lua chon: ");
			while(true) {
				try {
					key = Integer.parseInt(sc.nextLine());
					if (key < 0 || key > 8) {
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
						+ "\n4. Danh sach phu kien"
						+ "\n5. Danh sach hoa don");
				option = Integer.parseInt(sc.nextLine());
				switch(option) {
				case 1:
					dskh.hienDanhSach();
					break;
				case 2:
					dsnv.hienDanhSach();
					break;
				case 3:
					dsdt.hienDanhSach();
					break;
				case 4:
					dspk.hienDanhSach();
					break;
				case 5:
					list.hienDanhSach();
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
					System.out.print("Ban muon xoa(1)/them(2)? ");
					m = Integer.parseInt(sc.nextLine());
					if (m == 1) {
						dskh.xoa();
					} else {
						dskh.them();
					}
					break;
				case 2:
					System.out.print("Ban muon xoa(1)/them(2)? ");
					m = Integer.parseInt(sc.nextLine());
					if (m == 1) {
						dsnv.xoa();
					} else {
						dsnv.them();
					}
					break;
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
					System.out.print("Ban muon xoa(1)/them(2)? ");
					m = Integer.parseInt(sc.nextLine());
					if (m == 1) {
						dspk.xoa();
					} else {
						dspk.them();
					}
					break;
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
					dskh.search();
					break;
				case 2:
					dsnv.search();
					break;
				case 3:
					dsdt.search();
					break;
				case 4:
					dspk.search();
					break;
				}
				break;
			case 6:
				System.out.println("Chon danh sach muon sap xep: "
						+ "\n1. Khach hang"
						+ "\n2. Nhan vien"
						+ "\n3. Dien thoai"
						+ "\n4. Phu kien");
				option = Integer.parseInt(sc.nextLine());
				switch(option) {
				case 1:
					dskh.sapXep();
					dskh.hienDanhSach();
					break;
				case 2:
					dsnv.sapXep();
					dsnv.hienDanhSach();
					break;
				case 3:
					System.out.println("Sap xep gia tien:"
							+ "\n1.Cao -> thap"
							+ "\n2.Thap -> cao");
					m = Integer.parseInt(sc.nextLine());
					if (m == 1) {
						dsdt.sapXepGiaTienGiamDan();
						dsdt.hienDanhSach();
					} else {
						dsdt.sapXepGiaTienTangDan();
						dsdt.hienDanhSach();
					}
					break;
				case 4:
					System.out.println("Sap xep gia tien:"
							+ "\n1.Cao -> thap"
							+ "\n2.Thap -> cao");
					m = Integer.parseInt(sc.nextLine());
					if (m == 1) {
						dspk.sapXepGiaTienGiamDan();
						dspk.hienDanhSach();
					} else {
						dspk.sapXepGiaTienTangDan();
						dspk.hienDanhSach();
					}
					break;
				}
				break;
			case 7:
				System.out.print("Ban muon doc(1)/ghi(2) file? ");
				option = Integer.parseInt(sc.nextLine());
				if (option == 1) {
					System.out.println("Chon danh sach muon doc: "
							+ "\n1. Khach hang"
							+ "\n2. Nhan vien"
							+ "\n3. Dien thoai"
							+ "\n4. Phu kien");
					m = Integer.parseInt(sc.nextLine());
					switch(m) {
					case 1:
						ArrayList<KhachHang> tmp1 = dskh.docfile();
						for (KhachHang x : tmp1) {
							System.out.println(x.toString());
						}
						break;
					case 2:
						ArrayList<NhanVien> tmp2 = dsnv.docfile();
						for (NhanVien x : tmp2) {
							System.out.println(x.toString());
						}
						break;
					case 3:
						ArrayList<DienThoai> tmp3 = dsdt.docfile();
						for (DienThoai x : tmp3) {
							System.out.println(x.toString());
						}
						break;
					case 4:
						ArrayList<PhuKien> tmp4 = dspk.docfile();
						for (PhuKien x : tmp4) {
							System.out.println(x.toString());
						}
						break;
					}
				} else {
					System.out.println("Chon danh sach muon ghi: "
							+ "\n1. Khach hang"
							+ "\n2. Nhan vien"
							+ "\n3. Dien thoai"
							+ "\n4. Phu kien");
					m = Integer.parseInt(sc.nextLine());
					switch(m) {
					case 1:
						ArrayList<KhachHang> tmp1 = dskh.dskh;
						dskh.ghiFile(tmp1);
						break;
					case 2:
						ArrayList<NhanVien> tmp2 = dsnv.dsnv;
						dsnv.ghiFile(tmp2);
						break;
					case 3:
						ArrayList<DienThoai> tmp3 = dsdt.dsdt;
						dsdt.ghiFile(tmp3);
						break; 
					case 4:
						ArrayList<PhuKien> tmp4 = dspk.dspk;
						dspk.ghiFile(tmp4);
						break;
					}
				}
				break;
			case 8:
				HoaDon temp = new HoaDon();
				temp.taoHoaDon(dskh, dsnv, dsdt, dspk);
				list.them(temp);
				System.out.println(temp.toString());
				list.ghiFile();
				break;
			case 0:
				System.out.println("Da thoat chuong trinh.");
				break loop;
			}
		}
	}
}
