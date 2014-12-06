package BusinessService.Entities;

import java.util.ArrayList;

public class ListOfClients
{
	private ArrayList<Client> list;
	public Client m_Client;

	public ListOfClients()
	{
		list = new ArrayList<>();
	}
	public Client get(int index)
	{
		return list.get(index);
	}
	public void add(Client client)
	{
		list.add(client);
	}
	public String[] getElementsInStringArray()
	{
		String []s = new String[list.size()];
		int i = 0;
		for(Client m: list)
		{
			s[i] = new String("id = " + m.getId() + ", Full Name = " + m.getFirstName() + " " + m.getSecondName());
			++i;
		}
		return s;
	}
}
