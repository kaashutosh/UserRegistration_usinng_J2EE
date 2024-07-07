package aashu;

import java.sql.*;
import java.sql.PreparedStatement;

public class RegisterDAO {
	int k=0;
	public  int register(UserBean ub) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement pst = con.prepareStatement("insert into userreg60 values(?,?,?,?,?,?,?)");
			pst.setString(1,ub.getlName());
			pst.setString(2, ub.getPword());
			pst.setString(3, ub.getFname());
			pst.setString(4, ub.getlName());
			pst.setString(5, ub.getAddr());
			pst.setString(6, ub.getMid());
			pst.setLong(7, ub.getPhno());
			k=pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}

}
