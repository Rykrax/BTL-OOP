package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DanhSachDienThoai {
	private ArrayList<DienThoai> dsdt;

	public DanhSachDienThoai() {
		this.dsdt = new ArrayList<DienThoai>();
	}

	public DanhSachDienThoai(ArrayList<DienThoai> dsdt) {
		super();
		this.dsdt = dsdt;
	}
	
	public void them() {
		DienThoai dt = new DienThoai();
		dt.nhap();
		this.dsdt.add(dt);
	}
	
	public boolean kiemTraTonTai(DienThoai dt) {
		return this.dsdt.contains(dt);
	}
	
	public void xoa(DienThoai dt) {
		if (this.kiemTraTonTai(dt) == true) {
			this.dsdt.remove(dt);
			System.out.println("Xoa thanh cong!");
		} else {
			System.out.println("San pham khong co trong danh sach!");
		}
	}
	
//	public void search(DienThoai dt) {
//		for (DienThoai x : dsdt) {
//			if (x )
//		}
//	}
	
	public void hienDanhSach() {
			for (DienThoai x : dsdt) {
				System.out.println(x.toString());
			}
	}
	public void sapXepGiaTienGiamDan() {
		Collections.sort(this.dsdt, new Comparator<DienThoai>() {
			@Override
			public int compare(DienThoai dt1, DienThoai dt2) {
				if (dt1.getCoin() < dt2.getCoin()) {
					return 1;
				} else if (dt1.getCoin() > dt2.getCoin()) {
					return -1;
				} else return 0;
			}
		});
	}
	
	public void sapXepGiaTienTangDan() {
		Collections.sort(this.dsdt, new Comparator<DienThoai>() {
			@Override
			public int compare(DienThoai dt1, DienThoai dt2) {
				if (dt1.getCoin() > dt2.getCoin()) {
					return 1;
				} else if (dt1.getCoin() < dt2.getCoin()) {
					return -1;
				} else return 0;
			}
		});
	}
}
