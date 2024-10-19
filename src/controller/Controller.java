package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import data.DataStorage;
import data.User;
import data.stampsDetails;

public class Controller {
	
	public String m="";  //methood
	public String c="";  //country
	public int y=0;      //year
	public String p="";  //printer
	public String n="";  //name
	public int q=0;      //quantity
	public float pS=0;   //perforation size
	public String d="";  //designer
	public String s="";    //size
	public String t="";  //type 
	public String sD=""; //short description
	private String read, cc="";
	
	public DataStorage datastorage= new DataStorage();
	

	public DataStorage getDatastorage() {
	 	 return datastorage; 
	}

	public void setDatastorage(DataStorage datastorage) { 
		 this.datastorage = datastorage; 
	}

	public void regUser(String user, String pass) { 
		User np = new User();
		np.setUser(user);
		np.setPass(pass);
		this.datastorage.storeUser(np);
	 }


	public void delStamps(int index, stampsDetails stamp) { 
		this.datastorage.delStamps(index, stamp);
	 }
	
	public boolean verifyUser(String user, String pass){
		String real = pass;
		String test="";
		User t=datastorage.getUser(user);
		if(t!=null){
			test=t.getPass().toString();
			if(real.equals(test))
				return true;
			else
				return false;
		}
		else
			return false;
		}
	
	public stampsDetails[] getAllStamps() { 
		return this.datastorage.getAllStamps();
	 }


	public void updateStamp(int index, stampsDetails StampD) { 
		this.datastorage.updateStamp(index, StampD);
	 }

	public void addStampD(String name, int year, String country, int quantity, Float perforation, String size,
			String designer, String printer, String method, String description, String type) {
		stampsDetails nz = new stampsDetails(name, year, country, quantity, perforation, size, designer, printer, method, description, type);
		this.datastorage.addStamps(nz);
	}

	public boolean exisUser(String user){
        User t=datastorage.getUser(user);
        if(t!=null){
        return true;
        }
        else{
            return false;
        }
	}
	public void writeStamp(String name, int year, String country, int quantity, Float perforation, String size,
			String designer, String printer, String method, String description, String type){ 
		n=name;
		y=year;
		c=country;
		q=quantity;
		pS=perforation;
		s=size;
		d=designer;
		p=printer;
		m=method;
		sD=description;
		t=type;
		
		try{
			BufferedWriter out = new BufferedWriter(new FileWriter("Stamp.txt", true)); 		//writes and append the data in text file
			out.write(n+";");						//ends each data with a ';'
			out.write(String.valueOf(y)+";");
			out.write(c+";");
			out.write(String.valueOf(q)+";");
			out.write(String.valueOf(pS)+";");
			out.write(s+";");
			out.write(d+";");
			out.write(p+";");
			out.write(m+";");
			out.write(sD+";");
			out.write(t+";");
			out.newLine();							//move to a new line when finish writing
			out.close();
			System.out.println("Successful");
		}
		catch(IOException e){
			System.out.println("There was a problem" + e);
		}
	}
	
	public void file() throws IOException{
		this.datastorage.stampfile();		//read data using function in datastorage
	}
	

}
