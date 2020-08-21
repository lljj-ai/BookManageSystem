package javaBean;

public class Book {
    
	private int bookid = 0;
    private String bookname = null;
    private String author = null;
    private String publisher = null;
    private int currentcount = 0;
    private int count = 0;
   
    public Book() {
    	
    }
    
    public Book(int bookid) {
		this.bookid = bookid;

	}
     
    public Book(int bookid, String bookname, String autor, String publisher, int currentcount, int count) {
		this.bookid = bookid;
		this.bookname = bookname;
		this.author = autor;
		this.publisher = publisher;
		this.currentcount = currentcount;
		this.count = count;
	}

    public Book(String bookname, String autor, String publisher, int currentcount, int count) {
		super();
		this.bookname = bookname;
		this.author = autor;
		this.publisher = publisher;
		this.currentcount = currentcount;
		this.count = count;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String autor) {
		this.author = autor;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getCurrentcount() {
		return currentcount;
	}

	public void setCurrentcount(int currentcount) {
		this.currentcount = currentcount;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}


    
}
