package pl.insurance.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;


import org.apache.log4j.Logger;

import pl.insurance.model.Client;
import pl.insurance.model.Contract;
import pl.insurance.service.ClientService;
import pl.insurance.service.ContractService;

@ViewScoped
@ManagedBean(name="contractListController")
public class ContractListController implements Serializable {

	private static final long serialVersionUID = 2444314616874951348L;

	@Inject
	private FacesContext facesContext;

	@Inject
	private Logger log;

	@Inject
	private ContractService contractService;
	
	@Inject
	private ClientService clientService;
	

	private String pesel;
	private List<Contract> contracts;
	private Contract selectedContract;


	public String listForClient() {
		Client client = clientService.findClientByPESEL(pesel);
		contracts = contractService.clientContracts(client);
		return null;
	}

	public List<Contract> getContracts() {
		return contracts;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}
	
	public Contract getSelectedContract() {
		return selectedContract;
	}
	
	public void setSelectedContract(Contract selectedContract) {
		this.selectedContract = selectedContract;
	}

}
