package entity;

public class Accout {
	private int id;
	private String username;
	private String password;
	private int sellid;
	private int adminid;

	public Accout(int id, String username, String password, int sellid, int adminid) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.sellid = sellid;
		this.adminid = adminid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSellid() {
		return sellid;
	}

	public void setSellid(int sellid) {
		this.sellid = sellid;
	}

	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	@Override
	public String toString() {
		return "Accout [id=" + id + ", username=" + username + ", password=" + password + ", sellid=" + sellid
				+ ", adminid=" + adminid + "]";
	}

}
