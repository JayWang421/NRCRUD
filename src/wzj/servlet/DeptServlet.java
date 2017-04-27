package wzj.servlet;

import java.io.IOError;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import wzj.service.IDeptService;
import wzj.util.factory.Factory;
import wzj.vo.Dept;

@SuppressWarnings("serial")
@WebServlet("/DeptServlet/*")
public class DeptServlet extends HttpServlet{
	public void add(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOError{
		IDeptService deptService=Factory.getServiceInstance("dept.service") ;
		Dept vo=new Dept() ;
		vo.setDname(request.getParameter("dname"));
		try {
			deptService.add(vo) ;
			response.getWriter().println(vo.getDeptno());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public void edit(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOError{
		IDeptService deptService=Factory.getServiceInstance("dept.service") ;
		Dept vo=new Dept() ;
		vo.setDeptno(Integer.parseInt(request.getParameter("deptno")));
		vo.setDname(request.getParameter("dname"));
		try {
			response.getWriter().println(deptService.edit(vo));
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public void delete(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOError{
		IDeptService deptService=Factory.getServiceInstance("dept.service") ;
		int deptno=Integer.parseInt(request.getParameter("deptno")) ;
		try {
			response.getWriter().println(deptService.delete(deptno));
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	public void list(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOError{
		IDeptService deptService=Factory.getServiceInstance("dept.service") ;
		try {
			List<Dept> all=deptService.list() ;
			JSONObject obj=new JSONObject() ;
			JSONArray arr=new JSONArray() ;
			Iterator<Dept> iter=all.iterator() ;
			while(iter.hasNext()){
				arr.add(iter.next()) ;
			}
			obj.put("alldepts", arr) ;
			response.getWriter().println(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String uri=request.getRequestURI() ;
		String methodName=uri.substring(uri.lastIndexOf("/")+1) ;
		try{
			Method method=this.getClass().getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class) ;
			method.invoke(this, request,response) ;
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
