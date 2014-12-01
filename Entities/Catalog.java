package Entities;

import java.util.ArrayList;

/**
 * @author User
 * @version 1.0
 * @created 01-дек-2014 23:50:11
 */
public class Catalog {

	private String information;
	private ArrayList<CatalogRecord> records;
	public CatalogRecord m_CatalogRecord;



	public void finalize() throws Throwable {

	}

	public Catalog(){

	}

	/**
	 * 
	 * @param record
	 */
	public void addRecord(CatalogRecord record){

	}

	/**
	 * 
	 * @param record
	 */
	public void deleteRecord(CatalogRecord record){

	}

	public String getInformation(){
		return information;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setInformation(String newVal){
		information = newVal;
	}

	/**
	 * 
	 * @param record
	 */
	public void updateRecord(CatalogRecord record){

	}

}