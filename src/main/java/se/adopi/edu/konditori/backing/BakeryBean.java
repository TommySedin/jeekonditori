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

	public List<SoldPastry> getSoldPastries() {
		if (soldPastries == null) {
			soldPastries = new ArrayList<>();
			for (Pastry p : pastryTypes) {
				soldPastries.add(new SoldPastry(p, (int) (Math.random() * 10)));
			}
		}
		return soldPastries;
	}

	public void setSoldPastries(List<SoldPastry> soldPastries) {
		this.soldPastries = soldPastries;
	}

	public List<Employee> getEmployees() {
		return employees;
	}
}
