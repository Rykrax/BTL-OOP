package test;

import main.DanhSachDienThoai;
import main.DienThoai;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		DanhSachDienThoai dsdt = new DanhSachDienThoai();
		int key;
		
		loop: while(true) {
			System.out.print("==================MENU=================="
					+ "\n1. Nhap thong tin khach hang/nhan vien"
					+ "\n2. Nhap thong tin san pham"
					+ "\n3. Hien thi danh sach"
					+ "\n4. Chinh sua danh sach"
					+ "\n5. Tim kiem"
					+ "\n6. Sap xep danh sach"
					+ "\n0. Exit"
					+ "\n\nNhap lua chon: ");
			while(true) {
				try {
					key = Integer.parseInt(sc.nextLine());
					if (key < 0 || key > 6) {
						System.out.print("Lua chon khong phu hop. Hay lua chon lai: ");
						continue;
					}
					break;
				} catch (Exception e) {
					System.out.println("Du lieu khong hop le! Hay lua chon lai: ");
				}
			}
		}
	}
}
