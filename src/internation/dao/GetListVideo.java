package internation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import internation.db.DBConnection;
import internation.model.Video;

public class GetListVideo {

	private static Connection conn;
	private static PreparedStatement stmt;
	private static ResultSet rs;

	public static List<Video> GetList() {

		List<Video> listvd = new ArrayList<Video>();

		// Khai báo biến cho thực hiện truy vấn
		try {
			conn = DBConnection.getConnection();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Can not connect :" + e);
		}
		String sql = "Select * From video";
		try {
			// Chuẩn bị câu lệnh truy vấn
			stmt = conn.prepareStatement(sql);
			// Thực hiện câu lệnh truy vấn
			rs = stmt.executeQuery();
			while (rs.next()) {
				Video vd = new Video();
				vd.setId(rs.getInt("id"));
				vd.setVideoname(rs.getString("videoname"));
				vd.setContent(rs.getString("videoname"));
				vd.setTimepause(rs.getTime("timepause"));
				vd.setImage(rs.getString("image"));
				vd.setLink(rs.getString("link"));
				listvd.add(vd);
			}
		} catch (Exception ex) {
			System.err.println("Error get data video" + ex);
		}
		return listvd;
	}

	public static String GetPathVideo(int id) {
		String path = null;
		// Khai báo biến cho thực hiện truy vấn
		try {
			conn = DBConnection.getConnection();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Can not connect :" + e);
		}
		String sql = "Select link From video where id="+id+"";
		try {
			// Chuẩn bị câu lệnh truy vấn
			stmt = conn.prepareStatement(sql);
			// Thực hiện câu lệnh truy vấn
			rs = stmt.executeQuery();
			while (rs.next()) {
				path = rs.getString("link");
			}
		} catch (Exception ex) {
			System.err.println("Error get data video" + ex);
		}
		return path;
	}

}
