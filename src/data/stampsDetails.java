package data;

public class stampsDetails {


	public String printingMethod;

	public String countryOfIssue;

	public int yearOfIssue;
	
	public String printer;

	public String name;

	public int quantityOfIssue;

	public float perforationSize;

	public String stampDesigner;

	public String sizeOfStamp;

	public String type;

	public String shortDescription;
	
	public stampsDetails(String name,int year,String country ,int quantity,Float perforation,String size,String designer,String printer,String method,String description,String type){
		this.printingMethod = method;
		this.countryOfIssue = country;
		this.yearOfIssue = year;
		this.printer = printer;
		this.name = name;
		this.quantityOfIssue = quantity;
		this.perforationSize = perforation;
		this.stampDesigner =designer;
		this.sizeOfStamp = size;
		this.type = type;
		this.shortDescription = description;
	}


	public String getPrintingMethod() {
	 	 return printingMethod; 
	}

	public void setPrintingMethod(String printingMethod) { 
		 this.printingMethod = printingMethod; 
	}

	public String getCountryOfIssue() {
	 	 return countryOfIssue; 
	}

	public void setCountryOfIssue(String countryOfIssue) { 
		 this.countryOfIssue = countryOfIssue; 
	}

	public int getYearOfIssue() {
	 	 return yearOfIssue; 
	}

	public void setYearOfIssue(int yearOfIssue) { 
		 this.yearOfIssue = yearOfIssue; 
	}

	public String getPrinter() {
	 	 return printer; 
	}

	public void setPrinter(String printer) { 
		 this.printer = printer; 
	}

	public String getName() {
	 	 return name; 
	}

	public void setName(String name) { 
		 this.name = name; 
	}

	public int getQuantityOfIssue() {
	 	 return quantityOfIssue; 
	}

	public void setQuantityOfIssue(int quantityOfIssue) { 
		 this.quantityOfIssue = quantityOfIssue; 
	}

	public float getPerforationSize() {
	 	 return perforationSize; 
	}

	public void setPerforationSize(float perforationSize) { 
		 this.perforationSize = perforationSize; 
	}

	public String getStampDesigner() {
	 	 return stampDesigner; 
	}

	public void setStampDesigner(String stampDesigner) { 
		 this.stampDesigner = stampDesigner; 
	}

	public String getSizeOfStamp() {
	 	 return sizeOfStamp; 
	}

	public void setSizeOfStamp(String sizeOfStamp) { 
		 this.sizeOfStamp = sizeOfStamp; 
	}

	public String gettype() {
	 	 return type; 
	}

	public void settype(String type) { 
		 this.type = type; 
	}

	public String getShortDescription() {
	 	 return shortDescription; 
	}

	public void setShortDescription(String shortDescription) { 
		 this.shortDescription = shortDescription; 
	}


	

	public void stampsDetail() { 
		// TODO Auto-generated method
	 } 

}
