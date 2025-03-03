package com.valtech.training.first.services;

import java.util.List;

import com.valtech.training.first.dtos.BookInfoDTO;
import com.valtech.training.first.entities.Book;
import com.valtech.training.first.entities.Question;


public interface BookService{
	
	List<Book> getAllBooks();

	List<Book> getBooksByYearBetween(int i, int j);

	List<Book> getBooksByPriceGreaterThan(int i);
	
	List<Book> getAllByAuthorsId(long id);
		
	List<Integer> getPriceByAuthorId(long id);
	
	List<BookInfoDTO> getBookInfoByAuthor(long id);
}
