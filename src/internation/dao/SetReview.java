package internation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import internation.db.DBConnection;
import internation.model.Review;
import internation.model.Sub;;

public class SetReview {
	
	private static Connection conn;
	private static PreparedStatement stmt;
	private static ResultSet rs;

	public static boolean insertReview(Review review){
        	try {
    			conn = DBConnection.getConnection();
    		} catch (Exception e) {
    			// TODO: handle exception
    			System.err.println("Can not connect :" + e);
    			return false;
    		}
    		
    		String sql = "INSERT INTO review (content,video_id,sub_id) VALUES (?,?,?)" ;
    		try {
    			// Chuẩn bị câu lệnh truy vấn
    			stmt = conn.prepareStatement(sql);
    			//stmt.setInt(1, review.getId());
    			stmt.setString(1, review.getContent());
    			stmt.setInt(2, review.getVideo_id());
    			stmt.setInt(3, review.getSub_id());
    			// Thực hiện câu lệnh truy vấn
    			//stmt = miConexion.createStatement();
    	        stmt.executeUpdate();

    			return true;
    		} catch (Exception ex) {
    			System.err.println("Error set data review" + ex);
    			return false;
    		}
    }
}
