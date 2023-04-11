package main;

import java.io.Serializable;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class HoaDon implements Serializable {
	private String kh;
	private String nv;
	private String thoiGian;
	private HashMap<SanPham,Integer> sp = new HashMap<>();

	public HoaDon() {

	}
	public void taoHoaDon(KhachHangBLL dskh, NhanVienBLL dsnv, DienThoaiBLL dsdt, PhuKienBLL dspk) {
		LocalDateTime data = LocalDateTime.now();
		DateTimeFormatter dformat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		thoiGian = dformat.format(data);
		Locale lc = new Locale("vi","VN");
		NumberFormat numf = NumberFormat.getInstance(lc);
		Scanner sc = new Scanner(System.in);
		int index;
		System.out.println("==============Danh sach khach hang==============");
		for (int i = 0; i < dskh.dskh.size(); i++) {
			System.out.println(i+1 
					+ ". " + dskh.dskh.get(i).getHoten() 
					+ " - Ma khach hang: " + dskh.dskh.get(i).getMaKH());
		}
		System.out.print("Chon vi tri khach hang theo danh sach: ");
		while(true) {
			int n = Integer.parseInt(sc.nextLine());
			n--;
			if (n < 0 || n >= dskh.dskh.size()) {
				System.out.print("Hay nhap lai: ");
			} else {
				kh = dskh.dskh.get(n).getHoten();
				System.out.println("\n===============================================\n");
				break;
			}
		}	
		System.out.println("==============Danh sach nhan vien==============");
		for (int i = 0; i < dsnv.dsnv.size(); i++) {
			System.out.println(i+1 
					+ ". " + dsnv.dsnv.get(i).getHoten() 
					+ " - Ma nhan vien: " + dsnv.dsnv.get(i).getMaNV());
		}
		System.out.print("Chon vi tri nhan vien tao hoa don theo danh sach: ");
		while(true) {
			int n = Integer.parseInt(sc.nextLine());
			n--;
			if (n < 0 || n >= dsnv.dsnv.size()) {
				System.out.print("Hay nhap lai: ");
			} else {
				nv = dsnv.dsnv.get(n).getHoten();
				System.out.println("\n===============================================\n");
				break;
			}
		}
		lord: while(true) {
			System.out.println("1.Dien Thoai ");
			System.out.println("2.PhuKien ");
			System.out.print("Lua chon san pham: ");
			int option = Integer.parseInt(sc.nextLine());
			if (option == 1) {
				if (dsdt.dsdt.isEmpty()) {
					System.out.println("Hien khong co san pham trong cua hang!");
				} else {
					System.out.println("Danh sach dien thoai co trong cua hang: ");
					for (int i = 0; i < dsdt.dsdt.size(); i++) {
						System.out.println("Ten: " + dsdt.dsdt.get(i).getTenSP() 
								+ ", gia: " + numf.format(dsdt.dsdt.get(i).getCoin()));
					}
					System.out.print("Nhap ten san pham: ");
					String name = sc.nextLine();
					loop: while(true) {
						int vt = dsdt.check(name);
						if (vt != -1 && dsdt.dsdt.get(vt).getSoLuong() != 0) {
							System.out.println("So luong hien co: " + dsdt.dsdt.get(vt).getSoLuong());
							System.out.print("Nhap so luong mua: ");
							int cnt = Integer.parseInt(sc.nextLine());
							while(true) {
								if (cnt < 0 || cnt > dsdt.dsdt.get(vt).getSoLuong()) {
									System.out.print("So luong khong phu hop! Hay nhap lai: ");
								} else {
									SanPham temp = dsdt.dsdt.get(vt);
									sp.put(temp, cnt);
									dsdt.dsdt.get(vt).updateSoLuong(-cnt);
									break loop;
								}
								cnt = Integer.parseInt(sc.nextLine());
							}
						} else if (vt != -1 && dsdt.dsdt.get(vt).getSoLuong() == 0) {
							System.out.println("San pham da het.");
							break loop;
						} else {
							System.out.print("Khong tim thay. Hay nhap lai ten san pham: ");
						}
						name = sc.nextLine();
					}
				}
			} else {
				if (dspk.dspk.isEmpty()) {
					System.out.println("Hien khong co san pham trong cua hang!");
				} else {
					System.out.println("Danh sach phu kien co trong cua hang: ");
					for (int i = 0; i < dspk.dspk.size(); i++) {
						System.out.println("Ten: " + dspk.dspk.get(i).getTenSP() 
								+ ", gia: " + numf.format(dspk.dspk.get(i).getCoin()));
					}
					System.out.print("Nhap ten san pham: ");
					String name = sc.nextLine();
					loop: while(true) {
						int vt = dspk.check(name);
						if (vt != -1 && dspk.dspk.get(vt).getSoLuong() != 0) {
							System.out.println("So luong hien co: " + dspk.dspk.get(vt).getSoLuong());
							System.out.print("Nhap so luong mua: ");
							int cnt = Integer.parseInt(sc.nextLine());
							while(true) {
								if (cnt < 0 || cnt > dspk.dspk.get(vt).getSoLuong()) {
									System.out.print("So luong khong phu hop! Hay nhap lai: ");
								} else {
									SanPham temp = dspk.dspk.get(vt);
									sp.put(temp, cnt);
									dspk.dspk.get(vt).updateSoLuong(-cnt);
									break loop;
								}
								cnt = Integer.parseInt(sc.nextLine());
							}
						} else if (vt != -1 && dspk.dspk.get(vt).getSoLuong() == 0) {
							System.out.println("San pham da het.");
							break loop;
						} else {
							System.out.print("Khong tim thay. Hay nhap lai ten san pham: ");
						}
						name = sc.nextLine();
					}
				}
			}
			System.out.println("Ban co muon tiep tuc mua khong?"
					+ "\n1.Co"
					+ "\n2.Khong");
			int m = Integer.parseInt(sc.nextLine());
			if (m == 2) break lord;
		}
	}

	public String tongBill() {
		Locale lc = new Locale("vi","VN");
		NumberFormat numf = NumberFormat.getInstance(lc);
		double sum = 0;
		String ds = "";
		for(SanPham x : sp.keySet()) {
			ds += "Ten san pham: " + x.getTenSP() + " x" + sp.get(x) + "\n";
			sum+=(x.getCoin()*sp.get(x));
		}
		return ds + "\n===============================================\nTong tien: " + numf.format(sum);
	}
	@Override
	public String toString() {
		Locale lc = new Locale("vi","VN");
		NumberFormat numf = NumberFormat.getInstance(lc);
		return "Hoa Don\n" + "In: " + this.thoiGian 
				+ "\nNhan vien: " + nv
				+ "\nKhach Hang: " + kh
				+ "\n===============================================\n" + tongBill() + "\n";
	}
}