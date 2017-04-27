package wzj.service;

import java.util.List;

import wzj.vo.Dept;

public interface IDeptService {
	public boolean add(Dept vo)throws Exception ;
	public boolean edit(Dept vo)throws Exception ;
	public boolean delete(int deptno)throws Exception ;
	public List<Dept> list() throws Exception ;
}
