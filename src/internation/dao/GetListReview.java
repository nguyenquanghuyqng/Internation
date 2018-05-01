package internation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import internation.db.DBConnection;
import internation.model.Review;

public class GetListReview {

	private static Connection conn;
	private static PreparedStatement stmt;
	private static ResultSet rs;

	public static List<Review> GetList() {

		List<Review> listrv = new ArrayList<Review>();

		// Khai báo biến cho thực hiện truy vấn
		try {
			conn = DBConnection.getConnection();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Can not connect :" + e);
		}
		String sql = "Select * From review";
		try {
			// Chuẩn bị câu lệnh truy vấn
			stmt = conn.prepareStatement(sql);
			// Thực hiện câu lệnh truy vấn
			rs = stmt.executeQuery();
			while (rs.next()) {
				Review vr = new Review();
				vr.setId(rs.getInt("id"));				
				vr.setContent(rs.getString("content"));
				vr.setVideo_id(rs.getInt("video_id"));
				vr.setSub_id(rs.getInt("sub_id"));
				listrv.add(vr);
			}
		} catch (Exception ex) {
			System.err.println("Error get data video" + ex);
		}
		return listrv;
	}

//	public static String GetPathVideo(int id) {
//		String path = null;
//		// Khai báo biến cho thực hiện truy vấn
//		try {
//			conn = DBConnection.getConnection();
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.err.println("Can not connect :" + e);
//		}
//		String sql = "Select link From video where id="+id+"";
//		try {
//			// Chuẩn bị câu lệnh truy vấn
//			stmt = conn.prepareStatement(sql);
//			// Thực hiện câu lệnh truy vấn
//			rs = stmt.executeQuery();
//			while (rs.next()) {
//				path = rs.getString("link");
//			}
//		} catch (Exception ex) {
//			System.err.println("Error get data video" + ex);
//		}
//		return path;
//	}

}
