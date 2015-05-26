/**
 * 
 */
package edu.springweb.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import edu.springweb.dao.EmployeeDao;
import edu.springweb.entity.Employee;

/**
 * @author Praveen
 *
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private static Long empId = 100L;
	private static Map<Long, Employee> empMap = new HashMap<Long, Employee>(5);
	private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);
 
	static {
		Employee emp = null;
		emp = new Employee();
		emp.setId(getIncrementedEmpId());
		emp.setFirstName("Praveen Kumar");
		emp.setLastName("Mishra");
		empMap.put(emp.getId(), emp);

		emp = new Employee();
		emp.setId(getIncrementedEmpId());
		emp.setFirstName("Yash");
		emp.setLastName("Mishra");
		empMap.put(emp.getId(), emp);
	}

	public static Long getIncrementedEmpId() {
		return ++empId;
	}
	 
	@Inject
	private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

	public Long getNextEmpId() {
		return ++empId;
	}

	/** (non-Javadoc)
	 * @see edu.springweb.dao.EmployeeDao#getEmployees()
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> getEmployees() {

		//List<Employee> empList = new ArrayList<Employee>(empMap.values());
		Session session = this.sessionFactory.getCurrentSession();
        List<Employee> empList = session.createQuery("from Employee").list();
        for(Employee emp : empList) {
            logger.info("Employee List::"+emp);
        }
		return empList;
	}

	public void save(Employee emp) {

		//empMap.put(emp.getId(), emp);
		Session session = this.sessionFactory.getCurrentSession();
		if(emp.getId()==null) {
			session.persist(emp);
			logger.info("Employee saved successfully, Employee Details="+emp);
		} else {
			session.update(emp);
	        logger.info("Employee updated successfully, Employee Details="+emp);
		}
	}

	public Employee getById(Long id) {

		//System.out.println(empMap.get(100L));
		//System.out.println(empMap.get(101L));
		//System.out.println(empMap.get(id));
		//return empMap.get(id);
		Session session = this.sessionFactory.getCurrentSession();      
		Employee emp = (Employee) session.load(Employee.class, new Long(id));
        logger.info("Employee loaded successfully, Employee details="+emp);
        return emp;
	}

	public Employee deleteById(Long empId) {

		//Employee emp = empMap.get(empId);
		//empMap.remove(empId);
		//return emp;
		Session session = this.sessionFactory.getCurrentSession();
		Employee emp = (Employee) session.load(Employee.class, new Long(empId));
        if(null != emp){
            session.delete(emp);
        }
        logger.info("Employee deleted successfully, person details="+emp);
        return emp;
	}

}
