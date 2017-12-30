package DAO;

import java.util.ArrayList;
import PlaceHolder.Manager;

public interface ManagerDAO {
	//Everything we want to do with the table
			public ArrayList<Manager> getAllManagers();
			//Get 1
			public Manager getManager(int itemID);
			//Update
			public void updateManager(Manager manager);
			//Delete
			public void deleteManager(Manager manager);;
			//Create
			public void createManager(Manager manager);
}
