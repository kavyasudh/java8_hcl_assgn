package java8_hcl_assgn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;



import static java.util.stream.Collectors.toList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Trader ram= new Trader("ram", "delhi");
		Trader kapil= new Trader("kapil","noida");
		Trader raj= new Trader("raj","banglore");
		Trader ekta= new Trader("ekta","banglore");
		List<Trader> traders = Arrays.asList();
		List<Transaction> transactions = Arrays.asList(
				new Transaction(ram, 2011, 300),
				new Transaction(ram, 2012, 1000),
				new Transaction(kapil, 2011, 400),
				new Transaction(raj, 2012, 710),
				new Transaction(ekta, 2012, 700),
				new Transaction(ekta, 2012, 950)
		);
		
		//1. Find all transactions in the year 2011 and sort them by value (small to high)
		List<Transaction>  trans=transactions.stream()
				.filter(t->t.getYear()==2011)
				.sorted(Comparator.comparing(Transaction::getValue))
				.collect(toList());
		
		trans.forEach(t->System.out.println(t));
		
	   //	2.What are all the unique cities where the traders work?
		
		List<Trader> cities=transactions.stream()
				.map(t->t.getTrader())
				.distinct()
				.collect(toList());
		
		cities.forEach(c->System.out.println(c.getCity()));
		
		
	//	3. Find all traders from delhi and sort them by name.
		
		List<Trader> traders1=transactions.stream()
				.filter(c->c.getTrader().getCity()=="delhi")
				.map(t->t.getTrader())
				.sorted(Comparator.comparing(Trader::getName))
				.collect(toList());
		
		traders1.forEach(c->System.out.println(c));
		
		
		//4. Return a string of all traders names sorted alphabetically.
		
		List<Trader> names=transactions.stream()
				.map(t->t.getTrader())
				.sorted(Comparator.comparing(Trader::getName))
				.collect(toList());
		names.forEach(n->System.out.println(n));
		
		//5. Are any traders based in Jaipur?
		
		boolean isAnyTraderFromJaipur=transactions.stream()
				   .map(t->t.getTrader())
				  .anyMatch(b->b.getCity()=="jaipur");
				  System.out.println(isAnyTraderFromJaipur);
				 
  //	  6. Print all transactions values from the traders living in delhi
				  

				List<Transaction> transacs=transactions.stream()
						.filter(t->t.getTrader().getCity()=="delhi")
						.collect(toList());
				
				transacs.forEach(t->System.out.println(t));
				
				//7. Whats the highest value of all the transactions?
				
				List<Integer>  maxVal=transactions.stream()
						.map(v->v.getValue())
						.sorted()
						.collect(toList());
				
				System.out.println(maxVal.get(maxVal.size()-1));
				
				
				
			//	8. Find the transaction with the smallest value
	
				List<Transaction> mintrans=transactions.stream()
						.sorted(Comparator.comparing(Transaction::getValue))
						.limit(1)
						.collect(toList());
				
				mintrans.forEach(t->System.out.println(t));
				
				
				  
	}

}
