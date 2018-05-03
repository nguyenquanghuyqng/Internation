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

		// Khai bÃ¡o biáº¿n cho thá»±c hiá»‡n truy váº¥n
		try {
			conn = DBConnection.getConnection();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Can not connect :" + e);
		}
		String sql = "Select * From video";
		try {
			// Chuáº©n bá»‹ cÃ¢u lá»‡nh truy váº¥n
			stmt = conn.prepareStatement(sql);
			// Thá»±c hiá»‡n cÃ¢u lá»‡nh truy váº¥n
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
		// Khai bÃ¡o biáº¿n cho thá»±c hiá»‡n truy váº¥n
		try {
			conn = DBConnection.getConnection();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Can not connect :" + e);
		}
		String sql = "Select link From video where id=" + id + "";
		try {
			// Chuáº©n bá»‹ cÃ¢u lá»‡nh truy váº¥n
			stmt = conn.prepareStatement(sql);
			// Thá»±c hiá»‡n cÃ¢u lá»‡nh truy váº¥n
			rs = stmt.executeQuery();
			while (rs.next()) {
				path = rs.getString("link");
			}
		} catch (Exception ex) {
			System.err.println("Error get data video" + ex);
		}
		return path;
	}

	public static int InsertPathVideo(String pathFile) {

		int t = 0;

		try {
			conn = DBConnection.getConnection();
		} catch (Exception e) {
			System.err.println("Can not connect :" + e);
		}
		String sql = "insert into video(link) values(?)";
		try {
			// Chuẩn bị câu lệnh truy vấn
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, pathFile);
			stmt.executeUpdate();
			t = 1;
			System.out.println("Start insert");
		} catch (Exception e) {
			t = 0;
			System.out.println("Error insert linkpath:" + e.getMessage());
		}
		return t;
	}

}
