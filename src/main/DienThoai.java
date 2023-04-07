package main;

import java.io.Serializable;
import java.util.Scanner;

public class DienThoai extends SanPham implements Serializable {
	private String loaiDT;
	
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
		return "Dien thoai - " + super.toString() + ", loai dien thoai: " + this.loaiDT;
	}

	@Override
	public void nhap() {
        Scanner sc = new Scanner(System.in);
		super.nhap();
		System.out.print("Nhap loai dien thoai: ");
		this.loaiDT = sc.nextLine();
	}
}
