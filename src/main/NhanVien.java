package main;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class NhanVien extends Person implements Serializable{
    private String maNV;
    private double hsl;
    private final long lcb = 2500000;

    public NhanVien() {
        super();
    }
    public NhanVien(String maNV) {
    	this.maNV = maNV;
    }
    public NhanVien(String maNV, String hoten, String gt, String cmnd, String sodt, String diachi) {
        super(hoten, gt, cmnd, sodt, diachi);
        this.maNV = maNV;
    }
    public String getMaNV() {
		return maNV;
	}

	@Override
    public void nhap() {
        Scanner sc= new Scanner(System.in);
        super.nhap(); 
        System.out.print("He so luong: ");
        hsl=Double.parseDouble(sc.nextLine());
    }
    public double luong()
    {
        return hsl*lcb;
    }

    @Override
    public String toString() {
    Locale lc = new Locale("vi","VN");
	NumberFormat numf = NumberFormat.getInstance(lc);
        return "NhanVien - " + super.toString() 
        	+ ", ma nhan vien: " + this.maNV 
        	+ ", luong: " + numf.format(this.luong());
    }
    
}
