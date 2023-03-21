package main;

import java.util.Scanner;

public class DienThoai extends SanPham {
	private String loaiDT;
	Scanner sc = new Scanner(System.in);
	public DienThoai() {
		super();
	}

	public DienThoai(String tenSP,int namSX, int soLuong, int coin, String loaiDT) {
		super(tenSP, namSX, soLuong, coin);
		this.loaiDT = loaiDT;
	}

	public String getLoaiDT() {
		return loaiDT;
	}

	public void setLoaiDT(String loaiDT) {
		this.loaiDT = loaiDT;
	}
	

	@Override
	public String toString() {
		return "DienThoai [loaiDT=" + loaiDT + ", " + super.toString() + "]";
	}

	@Override
	public void nhap() {
		super.nhap();
		System.out.print("Nhập loại điện thoại: ");
		this.loaiDT = sc.nextLine();
	}
}
