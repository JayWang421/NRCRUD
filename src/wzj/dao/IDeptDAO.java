package wzj.dao;

import java.sql.SQLException;

import wzj.util.dao.IBaseDAO;
import wzj.vo.Dept;

public interface IDeptDAO extends IBaseDAO<Integer, Dept> {
	public Integer findAutoId()throws SQLException ;
}
