package wzj.service.impl;

import java.util.List;

import wzj.dao.IDeptDAO;
import wzj.service.IDeptService;
import wzj.util.factory.Factory;
import wzj.vo.Dept;

public class DeptServiceImpl implements IDeptService {

	@Override
	public boolean add(Dept vo) throws Exception {
		IDeptDAO deptDAO=Factory.getDAOInstance("dept.dao") ;
		if(deptDAO.doCreate(vo)){
			vo.setDeptno(deptDAO.findAutoId());
			return true ;
		}
		return false ;
	}

	@Override
	public boolean edit(Dept vo) throws Exception {
		IDeptDAO deptDAO=Factory.getDAOInstance("dept.dao") ;
		return deptDAO.doUpdate(vo) ;
	}

	@Override
	public boolean delete(int deptno) throws Exception {
		IDeptDAO deptDAO=Factory.getDAOInstance("dept.dao") ;
		return deptDAO.doRemove(deptno) ;
	}

	@Override
	public List<Dept> list() throws Exception {
		IDeptDAO deptDAO=Factory.getDAOInstance("dept.dao") ;
		return deptDAO.findAll() ;
	}

}
