package main;

import java.io.Serializable;
import java.util.Scanner;

public class KhachHang extends Person implements Serializable{
	private String maKH;

	public KhachHang() {
		super();
	}

	public KhachHang(String maKH) {
		this.maKH = maKH;
	}
	public KhachHang(String maKH, String hoten, String gt, String cmnd, String sodt, String diachi) {
		super(hoten, gt, cmnd, sodt, diachi);
		this.maKH = maKH;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	@Override
	public void nhap() {
		Scanner sc= new Scanner(System.in);
		super.nhap(); 
	}

	@Override
	public String toString() {
		return "KhachHang - " + super.toString() + ", ma khach hang: " + this.maKH;
	}

}
