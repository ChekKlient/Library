package net.bookshelf.spring.model;

public class Genre {
	private int id;
	private String title;

	public Genre() {
	}

	public Genre(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
