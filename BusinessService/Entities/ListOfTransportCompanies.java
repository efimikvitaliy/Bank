package BusinessService.Entities;

import java.util.ArrayList;

/**
 * @author user
 * @version 1.0
 * @created 01-дек-2014 23:50:19
 */
public class ListOfTransportCompanies {

	public ArrayList <TransportCompany> transportCompanies;
	public TransportCompany m_TransportCompany;

	public ListOfTransportCompanies(){
		transportCompanies = new ArrayList <TransportCompany>();
	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param company
	 */
	public void addNewTransportCompanyInList(TransportCompany company){

	}

	public void create(){

	}

	public void delete(TransportCompany o){
		transportCompanies.remove(o);
	}
	
	public void add(TransportCompany o){
		transportCompanies.add(o);
	}

	/**
	 * 
	 * @param company
	 */
	public void deleteSelctedTransportCompany(TransportCompany company){

	}

	/**
	 * 
	 * @param data
	 */
	public TransportCompany getTransportCompany(String data){
		return null;
	}

	public int size() {
		// TODO Auto-generated method stub
		return transportCompanies.size();
	}
	
	public TransportCompany getWithId(int id) {
		// TODO Auto-generated method stub
		int i;
		for(i=0; i<transportCompanies.size(); ++i){
			if(transportCompanies.get(i).getTransportCompanyId() == id)
				break;
		}
		if(i>=transportCompanies.size())
			return null;
		return transportCompanies.get(i);
	}

	public TransportCompany get(int i) {
		// TODO Auto-generated method stub
		return transportCompanies.get(i);
	}


}