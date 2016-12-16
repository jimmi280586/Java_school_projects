package utility;

import java.util.ArrayList;

import domain.model.Article;
import domain.model.Book;
import domain.model.CD;
import domain.model.DVD;
import domain.model.Item;
import domain.model.LinkedList;
import domain.model.ListADT;

public class HardCodeMethods
{
	private int size;
	public static ArrayList<Item> hardCodedList() 
		
	
	{
		Book a = new Book("title1", 1, "author1", "isbn");
		Book b = new Book("title2", 1, "author2", "isbn");
		CD c = new CD("title3", 1, "artist3");
		DVD d = new DVD("title4", 1, "artist4");
		Article e = new Article("title5", 1, "author5", "magazine1");
		Book f = new Book("title6", 1, "author6", "isbn");
		Book g = new Book("title7", 1, "author7", "isbn");
		CD h = new CD("title8", 1, "artist8");
		DVD i = new DVD("title9", 1, "artist9");
		Article j = new Article("title10", 1, "author10", "magazine2");
		Book k = new Book("title11", 1, "author11", "isbn");
		Book l = new Book("title12", 1, "author12", "isbn");
		CD m = new CD("title13", 1, "artist13");
		DVD n = new DVD("title14", 1, "artist14");
		Article o = new Article("title15", 1, "author15", "magazine3");
		Book p = new Book("title16", 1, "author16", "isbn");
		Book q = new Book("title17", 1, "author17", "isbn");
		CD r = new CD("title18", 1, "artist18");
		DVD s = new DVD("title19", 1, "artist19");
		Article t = new Article("title20", 1, "author20", "magazine4");
		
		ListADT list = new LinkedList<Item>();
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);
		list.add(e);
		list.add(f);
		list.add(g);
		list.add(h);
		list.add(i);
		list.add(j);
		list.add(k);
		list.add(l);
		list.add(m);
		list.add(n);
		list.add(o);
		list.add(p);
		list.add(q);
		list.add(r);
		list.add(s);
		list.add(t);
	
		System.out.println(list.toString());
		
		ArrayList<Item> al = list.toArray();
		
		for (int i1 = 0; i1 < al.size(); i1++) {
			Item s1 = al.get(i1);
			System.out.println("" + s1.toString());
		}
		return al;
	}
	
}
