package generated;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import generated.Catalog.Book;



public class ModifyClass {
	

	public static void main(String[] args) {

		try {

		JAXBContext jc = JAXBContext.newInstance("generated");
		
		Unmarshaller jaxbUnmarshaller = jc.createUnmarshaller();
		Catalog cat = (Catalog)jaxbUnmarshaller.unmarshal(new FileInputStream("Book.xml"));
		
		List a = new ArrayList();
		//List b = new ArrayList();
		a = cat.getBook();
		
		float avg=0,t=0, pricesum = 0, max=0;
		String title;
		Date date1, date2 ;
		
		//Loop to iterate via list and display data from xml
		for(int i =0; i < a.size(); i++)
		{
		Book data = cat.getBook().get(i);
		display(data);
		System.out.println("\n");
		}
		
		
		//Defining list with specific address to be modified
		
		Book modifyxml = cat.getBook().get(3) ;
		 modify(modifyxml);
		 
		 for( int k=0 ; k<a.size(); k++)
		 {
			 Book calc = cat.getBook().get(k);
			 pricesum+=calc.getPrice();
			 t++;
			 if(max<calc.getPrice())
			 { max=calc.getPrice();
			     title=calc.getTitle();	
			 }
			 
			 }
		 
		 avg = pricesum/t ;
		System.out.println("Average Price: " + avg);
		System.out.println("Maximum Price of book :"+ max);
		 
		}
		catch(JAXBException e)
		{
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static void display(Book data)
	{
		System.out.println("\t"+ "Author :"+ data.getAuthor());
		System.out.println("\t"+ "Genre :"+ data.getGenre());
		System.out.println("\t"+ "ID :"+ data.getId());
		System.out.println("\t"+ "Title :"+ data.getTitle());
		System.out.println("\t"+ "Description :"+ data.getDescription());
		System.out.println("\t"+ "Price:"+ data.getPrice());
		System.out.println("\t"+ "PublishDate:"+ data.getPublishDate());
	}
	
	public static void modify(Book modifyxml)
	{
		System.out.println("DATA Before Change");
		System.out.println("\t"+ "Author :"+ modifyxml.getAuthor());
		System.out.println("\t"+ "Description :"+modifyxml.getDescription());
		System.out.println("\t"+ "Price:"+ modifyxml.getPrice());
		System.out.println("\t"+ "Title :"+ modifyxml.getTitle());
		
	 modifyxml.setAuthor("Steve");
	 modifyxml.setDescription("New Modified Description");
	 modifyxml.setPrice(1000);
	 modifyxml.setTitle("NEW Modified Title");
	 
	 System.out.println("After Modification");
	 System.out.println("\t"+ "Author :"+ modifyxml.getAuthor());
		System.out.println("\t"+ "Description :"+modifyxml.getDescription());
		System.out.println("\t"+ "Price:"+ modifyxml.getPrice());
		System.out.println("\t"+ "Title :"+ modifyxml.getTitle());
	 
	}
	
	public void calculateavg(Book data)
	{
		
		
	}
}

