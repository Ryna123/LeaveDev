package com.kh.coocon.lmsapp.services;

import com.kh.coocon.lmsapp.entities.HrManagement;
import java.util.List;

public interface HumanResurceService {
	List<HrManagement> getAllEmp();
	List<HrManagement> getEmpByOrg(int orgId);
}
