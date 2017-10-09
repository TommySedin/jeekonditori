package se.adopi.edu.konditori.pojo;

import java.util.ArrayList;
import java.util.List;

import se.adopi.edu.konditori.Employee;

public class PojoEmployee implements Employee {
	private String name;
	private float salary;
	
	PojoEmployee(String name, float salary) {
		this.name = name;
		this.salary = salary;
	}
	@Override
	public String getName() {
		return name;
	}

	@Override
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}

	@Override
	public float getEmployersFeeRate() {
		return 0.3142f;
	}

	@Override
	public float getUnionFeeRate() {
		return 0.051f;
	}

	public static List<Employee> getEmployees() {
		List<Employee> result = new ArrayList<>();

		result.add(new PojoEmployee("Leif", 22000));
		result.add(new PojoEmployee("Bengt", 19000));
		result.add(new PojoSeniorEmployee("Åke", 20000));

		return result;
	}
}
