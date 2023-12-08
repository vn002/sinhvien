package entity;

public class Product {
	private int id;
	private String tensv;
	private String lop;
	private int tuoi;
	private String diachi;
	private String email;

	public Product(int id, String tensv, String lop, int tuoi, String diachi, String email) {
		this.id = id;
		this.tensv = tensv;
		this.lop = lop;
		this.tuoi = tuoi;
		this.diachi = diachi;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTensv() {
		return tensv;
	}

	public void setTensv(String tensv) {
		this.tensv = tensv;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", tensv=" + tensv + ", lop=" + lop + ", tuoi=" + tuoi + ", diachi=" + diachi
				+ ", email=" + email + "]";
	}
	
	

}
