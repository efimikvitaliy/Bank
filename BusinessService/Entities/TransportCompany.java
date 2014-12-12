package BusinessService.Entities;

/**
 * @author user
 * @version 1.0
 * @created 01-дек-2014 23:50:24
 */
public class TransportCompany {

	private String name;
	private int transportCompanyId;
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTransportCompanyId() {
		return transportCompanyId;
	}

	public void setTransportCompanyId(int transportCompanyId) {
		this.transportCompanyId = transportCompanyId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TransportCompany(){

	}
	
	public TransportCompany(int transportCompanyId_, String name_,  String description_){
		name = name_;
		transportCompanyId = transportCompanyId_;
		description = description_;
	}
	public void finalize() throws Throwable {

	}

	public void create(){

	}

	/**
	 * 
	 * @param company
	 */
	public void setNewInformation(TransportCompany company){

	}

}