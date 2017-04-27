package wzj.util.dao;

import java.sql.SQLException;
import java.util.List;

public interface IBaseDAO<K,V> {
	public boolean doCreate(V vo)throws SQLException ;
	public boolean doUpdate(V vo)throws SQLException ;
	public boolean doRemove(K mid)throws SQLException ;
	public V fingById(K mid)throws SQLException ;
	public List<V> findAll()throws SQLException ;
	public List<V> findAllSplit(Integer currentPage,Integer lineSize)throws SQLException ;
	public List<V> findAllSplit(Integer currentPage,Integer lineSize,K column, K keyword)throws SQLException ;
	public Integer getCount()throws SQLException ;
	public Integer getCount(K column, K keyword)throws SQLException ;
}
