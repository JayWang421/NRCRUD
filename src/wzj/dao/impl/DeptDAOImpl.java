package wzj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import wzj.dao.IDeptDAO;
import wzj.util.dbc.DatabaseConnection;
import wzj.vo.Dept;

public class DeptDAOImpl implements IDeptDAO {
	private PreparedStatement ps ;
	private Connection conn ;
	public DeptDAOImpl() {
		this.conn=DatabaseConnection.getConnection() ;
	}
	@Override
	public boolean doCreate(Dept vo) throws SQLException {
		String sql="insert into dept(dname) values(?) " ;
		this.ps=this.conn.prepareStatement(sql) ;
		this.ps.setString(1, vo.getDname());
		return this.ps.executeUpdate() > 0 ;
	}

	@Override
	public boolean doUpdate(Dept vo) throws SQLException {
		String sql="update dept set dname=? where deptno=? " ;
		this.ps=this.conn.prepareStatement(sql) ;
		this.ps.setString(1, vo.getDname());
		this.ps.setInt(2, vo.getDeptno());
		return this.ps.executeUpdate() > 0 ;
	}

	@Override
	public boolean doRemove(Integer mid) throws SQLException {
		String sql="delete from dept where deptno=? " ;
		this.ps=this.conn.prepareStatement(sql) ;
		this.ps.setInt(1, mid);
		return this.ps.executeUpdate() > 0 ;
	}

	@Override
	public Dept fingById(Integer mid) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dept> findAll() throws SQLException {
		List<Dept> all=new ArrayList<Dept>() ;
		String sql="select deptno,dname from dept " ;
		this.ps=this.conn.prepareStatement(sql) ;
		ResultSet rs=this.ps.executeQuery() ;
		while(rs.next()){
			Dept vo=new Dept() ;
			vo.setDeptno(rs.getInt(1));
			vo.setDname(rs.getString(2));
			all.add(vo) ;
		}
		return all ;
	}

	@Override
	public Integer findAutoId() throws SQLException {
		String sql="select last_insert_id()" ;
		this.ps=this.conn.prepareStatement(sql) ;
		ResultSet rs=this.ps.executeQuery() ;
		if(rs.next()){
			return rs.getInt(1) ;
		}
		return 0 ;
	}
	
	@Override
	public List<Dept> findAllSplit(Integer currentPage, Integer lineSize) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dept> findAllSplit(Integer currentPage, Integer lineSize, Integer column, Integer keyword)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getCount() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getCount(Integer column, Integer keyword) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
