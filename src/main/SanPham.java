package main;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class SanPham implements Serializable{
	protected String tenSP;
	protected int namSX;
	protected int soLuong;
	protected double coin;
	
	
	public SanPham() {
		super();
	}

	public SanPham(String tenSP, int namSX, int soLuong, double coin) {
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

    public int getSoLuong() {
        return soLuong;
    }
	

	
	public double getCoin() {
		return coin;
	}

	public void setCoin(double coin) {
		this.coin = coin;
	}
	
	public void nhap() {
            Scanner sc = new Scanner(System.in);
		System.out.print("Nhap ten san pham: ");
		this.tenSP = sc.nextLine();
		System.out.print("Nhap nam san xuat: ");
		this.namSX = Integer.parseInt(sc.nextLine());
		System.out.print("Nhap so luong: ");
		this.soLuong = Integer.parseInt(sc.nextLine());
		System.out.print("Nhap gia: ");
		this.coin = Integer.parseInt(sc.nextLine());
	}
public String tinhgia()
    {
        return"tong gia thanh cua san pham la : "+soLuong*coin;
    }
	@Override
	public String toString() {
            Locale lc = new Locale("vi","VN");
	NumberFormat numf = NumberFormat.getInstance(lc);
	Scanner sc = new Scanner(System.in);
		return "   Ten SanPham  " + tenSP + ", namSX=" + namSX + ", soLuong=" + soLuong + ", coin=" + numf.format(coin);
	}
}
