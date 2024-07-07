package aashu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
	public UserBean ub = null;
	public UserBean Login(String uN,String pW) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement pst = con.prepareStatement("select * from userreg60 where uname=? and pword=?");
			pst.setString(1,uN);
			pst.setString(2, pW);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				ub = new UserBean();
				ub.setUname(rs.getString(1));
				ub.setPword(rs.getString(2));
				ub.setFname(rs.getString(3));
				ub.setlName(rs.getString(4));
				ub.setAddr(rs.getString(5));
				ub.setMid(rs.getString(6));
				ub.setPhno(rs.getLong(7));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ub;
	}

}
