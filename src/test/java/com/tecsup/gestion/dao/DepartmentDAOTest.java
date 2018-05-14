package com.tecsup.gestion.dao;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.tecsup.gestion.exception.DAOException;
import com.tecsup.gestion.exception.EmptyResultException;
import com.tecsup.gestion.model.Department;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
@WebAppConfiguration
public class DepartmentDAOTest {

	private static final Logger logger = LoggerFactory.getLogger(DepartmentDAOTest.class);

	@Autowired
	private DepartmentDAO departmentDAO;

	
	@BeforeClass
	public static void beforeClass() {
		logger.info("Antes de todos los metodos");

	}
	
	@Before
	public  void before() {
		logger.info("Antes de cada metodo");
	}
	
	
	@Test
	 public void testFindDepartmentById() {

		try {
			//
			Department dep = departmentDAO.findDepartmentById(47);

			Assert.assertNotNull(dep);

			Assert.assertEquals("departamento_lima", dep.getName());
			Assert.assertEquals("este es un bonito departamento", dep.getDescription());
			Assert.assertEquals("Lima", dep.getCity());

			logger.info(dep.toString());

		} catch (EmptyResultException e) {
			fail(e.getMessage());
		} catch (DAOException e) {
			fail(e.getMessage());
		}

	}
	
	@Test
	public void testFindAllDepartments() {

		try {
			//
			List<Department> deps = departmentDAO.findAllDepartments();

			//Assert.assertEquals(emps.size(), 4);

			logger.info(deps.toString());

		} catch (EmptyResultException e) {
			fail(e.getMessage());
		} catch (DAOException e) {
			fail(e.getMessage());
		}

		
	}
	
	@Test
	public void testFindDepartmentByName() {

		try {
			//
			Department dep = departmentDAO.findDepartmentByName("gomez");

			Assert.assertEquals(47, dep.getDepartmentid());
			Assert.assertEquals("profesor", dep.getDescription());
			Assert.assertEquals("santa anita", dep.getCity());

			logger.info(dep.toString());
			
		} catch (EmptyResultException e) {
			fail(e.getMessage());
		} catch (DAOException e) {
			fail(e.getMessage());
		}

	}
	
	@Test
	public void testCreateDepartment() {

		logger.info("--");
		
		String NAME = "alvarado" + (int)(Math.random() * 100);
		String DESC = "alumna";
		String CITY = "Lima";

		try {
			//
			departmentDAO.create(NAME, DESC, CITY);

			//
			Department dep = departmentDAO.findDepartmentByName(NAME);

			Assert.assertEquals(NAME, dep.getName());
			Assert.assertEquals(DESC, dep.getDescription());
			Assert.assertEquals(CITY, dep.getCity());

		} catch (DAOException e) {
			fail(e.getMessage());
		} catch (EmptyResultException e) {
			fail(e.getMessage());
		}

	}

	@Test
	public void testUpdateDepartment() {

		String NAME = "alvarado" + (int)(Math.random() * 100);
		String DESC = "alumna";
		String CITY = "Lima";
		
		
		String UP_DESC = "alumna" + (int)(Math.random() * 100);
		String UP_CITY = "Arequipa";
	
		
		try {
			//
			departmentDAO.create(NAME, DESC, CITY);
			//
			departmentDAO.update(NAME, UP_DESC, UP_CITY);
			//
			Department dep = departmentDAO.findDepartmentByName(NAME);

			Assert.assertEquals(UP_DESC, dep.getDescription());
			Assert.assertEquals(UP_CITY, dep.getCity());
	

		} catch (DAOException e) {
			fail(e.getMessage());
		} catch (EmptyResultException e) {
			fail(e.getMessage());
		}

	}
	
	@Test
	public void testDeleteDepartment() {

		String NAME = "Info";
		String DESC = "Departamento de informatica";
		String CITY = "Arequipa";

		try {
			//
			departmentDAO.create(NAME, DESC, CITY);

		} catch (DAOException e) {
			fail(e.getMessage());
		}

		try {

			departmentDAO.delete(NAME);

			departmentDAO.findDepartmentByName(NAME);

		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmptyResultException e) {
			// Usuario borrado 
			return;
		}

	}
	@After
	public void after() {
		logger.info("Despues de cada metodo");
	}
	
	@AfterClass
	public static void afterClass() {
		logger.info("Despues de todos los metodos");
	}
}
