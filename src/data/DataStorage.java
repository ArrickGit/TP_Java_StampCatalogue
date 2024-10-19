package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import data.User;

public class DataStorage {
	Vector<User> userList = new Vector<User>();
	Vector<stampsDetails> stampList = new Vector<stampsDetails>();		//vector for stampList



	public void delStamps(int index, stampsDetails stamp) { 
		this.stampList.remove(index);
		this.stampList.remove(stamp);
	 }

	public void storeUser(User np) { 
		this.userList.add(np);
		}
	 


	public stampsDetails[] getAllStamps() { 
		stampsDetails[] opArr= new stampsDetails[this.stampList.size()];
		this.stampList.toArray(opArr);
		return opArr;
		
	 }

	public void addStamps(stampsDetails nz) { 
		this.stampList.add(nz);
	 }

	public void updateStamp( int index ,stampsDetails StampD) { 
		this.stampList.set(index, StampD);
	 }

	public User getUser(String user) {
		for(int i=0;i<userList.size();i++){
			User temp = userList.get(i);
			if(temp.getUser().equals(user)){
				return temp;
			}
		}
		return null;
	} 
	
	public void stampfile() throws IOException{
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader("Stamp.txt"));
            String line = bufReader.readLine();
            while(line != null){
            	
                 String[] column = line.split(";");					//splits the data in text file into columns
                 String name = line.split(";")[0];
                 int year = Integer.valueOf(line.split(";")[1]);
                 String country = line.split(";")[2];
                 int quantity = Integer.valueOf(line.split(";")[3]);
                 Float perforation = Float.valueOf(line.split(";")[4]);
                 String size = line.split(";")[5];
                 String type = line.split(";")[6];
                 String designer = line.split(";")[7];
                 String printer = line.split(";")[8];
                 String method = line.split(";")[9];
                 String description = line.split(";")[10];
                 
                 line = bufReader.readLine();
                 
                 stampsDetails nz = new stampsDetails(name, year, country, quantity, perforation, size, designer, printer, method, description, type);
                 stampList.add(nz); 			//add data that was split into columns into existing vector(stampList)
            }
            bufReader.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		
	}

}
