package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import context.ConnectDB;
import entity.Accout;
import entity.Product;

public class Dao {
	// Load dữ liệu từ DB lên
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<Product> getAllProduct() {
		List<Product> lish = new ArrayList<>();
		String query = "select * from svien";
		try {
			conn = (Connection) new ConnectDB().getConnection();// mở kết nối
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				lish.add(new Product(rs.getInt(1),
						rs.getString(2),
						rs.getString(3), 
						rs.getInt(4), 
						rs.getString(5),
						rs.getString(6))

				);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return lish;
	}

	public Accout login(String user, String pass) {
		String query = "select * from account where userr= ? and pass = ?";
		try {
			conn = (Connection) new ConnectDB().getConnection();// mở kết nối
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while (rs.next()) {
				Accout a = new Accout(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
				return a;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

	public void signup(String user, String pass) {
		String query = "INSERT INTO account (userr, pass,idSell, idAdmin)" + "VALUES (?, ?,0, 0);";
		try {

			conn = (Connection) new ConnectDB().getConnection();// mở kết nối
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			ps.executeUpdate();

		} catch (Exception e) {

		}

	}

	public Accout checkacountExits(String user) {
		String query = "select * from account where userr = ?";
		try {
			conn = (Connection) new ConnectDB().getConnection();// mở kết nối
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			rs = ps.executeQuery();
			while (rs.next()) {
				Accout a = new Accout(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
				return a;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

	public void deleteProduct(int idsv) {
		String query = "DELETE FROM Svien " + "WHERE id = ?";

		try {
			conn = (Connection) new ConnectDB().getConnection();
			ps = conn.prepareStatement(query);
			ps.setLong(1, idsv);
			ps.executeUpdate();
		} catch (Exception e) {
			// Handle the exception, for example, log it or print the stack trace
			e.printStackTrace();
		} finally {
			// Make sure to close resources in a finally block
			try {
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void insertProduct(String tensv, String lop, int tuoi, String diachi, String email) {
		String query = "INSERT INTO Svien(tensv,lop,tuoi,diachi,email) VALUES( ?,?,?,?,?)";
		try {
			conn = new ConnectDB().getConnection();// mở kết nối
			ps = conn.prepareStatement(query);
			ps.setString(1, tensv);
			ps.setString(2, lop);
			ps.setInt(3, tuoi);
			ps.setString(4, diachi);
			ps.setString(5, email);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("không in ra được");
		}

	}
	
	public List<Product> searchByName(String search) {
	    List<Product> list = new ArrayList<Product>();
	    String query = "SELECT * FROM svien WHERE tensv LIKE ?";
	    
	    try {
	        conn = new ConnectDB().getConnection();
	        ps = conn.prepareStatement(query);
	        ps.setString(1, "%" + search + "%"); // Corrected the parameter value
	        rs = ps.executeQuery();

	        while (rs.next()) {
	            list.add(new Product(
	                    rs.getInt(1),
	                    rs.getString(2),
	                    rs.getString(3),
	                    rs.getInt(4),
	                    rs.getString(5),
	                    rs.getString(6)
	            ));
	        }

	    } catch (Exception e) {
	        // TODO: Handle exception (Consider logging or proper error handling)
	        e.printStackTrace();
	    } finally {
	        // Close resources (Connection, PreparedStatement, ResultSet) in a finally block
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return list;
	}

	

	public void updateProduct(int id, String tensv, String lop, int tuoi, String diachi, String email) throws SQLException {
	    String query = "UPDATE Svien SET tensv=?, lop=?, tuoi=?, diachi=?, email=? WHERE id=?";
	    try {
	        conn = new ConnectDB().getConnection(); // mở kết nối
	        ps = conn.prepareStatement(query);
	        ps.setString(1, tensv);
	        ps.setString(2, lop);
	        ps.setInt(3, tuoi);
	        ps.setString(4, diachi);
	        ps.setString(5, email);
	        ps.setInt(6, id); // set ID at the end
	        ps.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace(); // print the stack trace for debugging
	    } finally {
	        // Close resources (PreparedStatement, Connection) in a finally block
	        // to ensure they are closed even if an exception occurs.
	        if (ps != null) {
	            ps.close();
	        }
	        if (conn != null) {
	            conn.close();
	        }
	    }
	}
	public void displayUpdate(int id) {
		String query = "select * from svien where id = ?";
		try {
			conn = new ConnectDB().getConnection();// mở kết nối
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
		    ps.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}


	public static void main(String[] args) {
		Dao dao = new Dao();
		List<Product> list = dao.getAllProduct();
		for (Product o : list) {
			System.out.println(o);

		}

	}

	public Product getAllProductByID(int id) {

		String query = "SELECT * FROM svien\r\n" + "where id";
		try {
			conn = (Connection) new ConnectDB().getConnection();// mở kết nối
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getString(6))

				;

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

	// phuong thuc sua

	/*private static final String UPDATE_PRODUCT_SQL = "UPDATE Svien SET tensv=?, lop=?, tuoi=?, diachi=?, email=? WHERE id=?";

	public boolean updateNhanvien(Product nhanvien) {
		try (Connection conn = new ConnectDB().getConnection();
				PreparedStatement ps = conn.prepareStatement(UPDATE_PRODUCT_SQL)) {

			ps.setString(1, nhanvien.getTensv());
			ps.setString(2, nhanvien.getLop());
			ps.setInt(3, nhanvien.getTuoi());
			ps.setString(4, nhanvien.getDiachi());
			ps.setString(5, nhanvien.getEmail());
			ps.setInt(6, nhanvien.getId());

			int rowsUpdated = ps.executeUpdate();
			return rowsUpdated > 0;

		} catch (SQLException e) {
			e.printStackTrace(); // In lỗi để theo dõi vấn đề
			return false;
		}
	}*/

}
