package main;

import java.io.Serializable;
import java.util.Scanner;

public class DienThoai extends SanPham implements Serializable {
	private String loaiDT;
	public DienThoai() {
		super();
	}
	
	public DienThoai(String name) {
		this.tenSP = name;
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
