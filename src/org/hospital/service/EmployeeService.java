package org.hospital.service;

import java.util.List;

import org.hospital.domain.Clinic;
import org.hospital.domain.Department;
import org.hospital.domain.Employee;


/**
 * Created by pismery on 2017-10-25.
 */
public interface EmployeeService {
	/**
	 * 检测登录
	 * @param account
	 * @param pwd
	 * @return
	 */
    Employee login(String account,String pwd);
    
    
    Employee getById(Long employeeId);
    
    /**
     * 获取部门下的所有员工
     * @param departmentId
     * @return
     */
    List<Employee> getDepartmentEmployee(int departmentId);
    
    /**
     * 获取门诊下的所有员工
     * @param clinicId
     * @return
     */
    List<Employee> getClinicEmployee(int clinicId);
    
    /**
     * 获取部门下的所有医生(具有开治疗项目单据权限的员工)
     * @param department
     * @return
     */
    List<Employee> getDepartmentDoctor(Department department);
    
    /**
     * 获取门诊下的所有医生(具有开治疗项目单据权限的员工)
     * @param clinic
     * @return
     */
    List<Employee> getClinicDoctor(Clinic clinic);
    
    /**
     * 获取所有门诊下的所有医生(具有开治疗项目单据权限的员工)
     * @return
     */
    List<Employee> getAllDoctor();
}
