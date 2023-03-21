package main;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class SanPham {
	private String tenSP;
	private int namSX;
	private int soLuong;
	private int coin;
	Locale lc = new Locale("vi","VN");
	NumberFormat numf = NumberFormat.getInstance(lc);
	Scanner sc = new Scanner(System.in);
	
	public SanPham() {
		super();
	}

	public SanPham(String tenSP, int namSX, int soLuong, int coin) {
		super();
		this.tenSP = tenSP;
		this.namSX = namSX;
		this.soLuong = soLuong;
		this.coin = coin;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	
	public int getNamSX() {
		return namSX;
	}

	public void setNamSX(int namSX) {
		this.namSX = namSX;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}
	
	public void nhap() {
		System.out.print("Nhập tên sản phẩm: ");
		this.tenSP = sc.nextLine();
		System.out.print("Nhập năm sản xuất: ");
		this.namSX = Integer.parseInt(sc.nextLine());
		System.out.print("Nhập số lượng: ");
		this.soLuong = Integer.parseInt(sc.nextLine());
		System.out.print("Nhập giá: ");
		this.coin = Integer.parseInt(sc.nextLine());
	}

	@Override
	public String toString() {
		return "SanPham [tenSP=" + tenSP + ", namSX=" + namSX + ", soLuong=" + soLuong + ", coin=" + numf.format(coin) + "]";
	}
}
