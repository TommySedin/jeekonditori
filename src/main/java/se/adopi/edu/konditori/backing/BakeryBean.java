package se.adopi.edu.konditori.backing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import se.adopi.edu.konditori.Employee;
import se.adopi.edu.konditori.Pastry;
import se.adopi.edu.konditori.SoldPastry;

@Named
@SessionScoped
public class BakeryBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private List<Pastry> pastryTypes;

	@Inject
	private List<Employee> employees;

	private List<SoldPastry> soldPastries;
	
	private SoldPastry selectedPastry;

	public List<SoldPastry> getSoldPastries() {
		if (soldPastries == null) {
			soldPastries = new ArrayList<>();
			for (Pastry p : pastryTypes) {
				soldPastries.add(new SoldPastry(p, (int) (Math.random() * 10)));
			}
		}
		return soldPastries;
	}

	public float getSumSoldPastries() {
		float sum = 0;
		for (SoldPastry sp : soldPastries) {
			sum += sp.getUnits() * sp.getPastry().getSellPrice();
		}
		return sum;
	}

	public SoldPastry getSelectedPastry() {
		return selectedPastry;
	}
	public void setSelectedPastry(SoldPastry selectedPastry) {
		this.selectedPastry = selectedPastry;
	}

	public List<Employee> getEmployees() {
		return employees;
	}
	
	public float getSumSalaries() {
		float result = 0;
		for (Employee e : employees) {
			result += e.getSalary();
		}
		return result;
	}
	public float getSumEmployersFees() {
		float result = 0;
		for (Employee e : employees) {
			result += e.getEmployersFee();
		}
		return result;
	}
	public float getSumUnionFees() {
		float result = 0;
		for (Employee e : employees) {
			result += e.getUnionFee();
		}
		return result;
	}
	public float getTotalEmployeeCosts() {
		return getSumSalaries() + getSumEmployersFees() + getSumUnionFees();  
	}
}
