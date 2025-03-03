package com.valtech.training.first.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.first.dtos.BookInfoDTO;
import com.valtech.training.first.entities.Book;
import com.valtech.training.first.entities.Question;
import com.valtech.training.first.repos.BookRepo;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepo bookRepo;
	@Override
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
		
	}	

	public void setBookRepo(BookRepo bookRepo) {
		this.bookRepo = bookRepo;
	}

	@Override
	public List<Book> getBooksByYearBetween(int i, int j) {
		return bookRepo.findAllByYearBetween(i, j);
	}

	@Override
	public List<Book> getBooksByPriceGreaterThan(int i) {
		return bookRepo.findAllByPriceGreaterThan(i);
	}
	
	public List<Integer> getPriceByAuthorId(long i){
		return bookRepo.findPriceByAuthorsId(i);
	}

	@Override
	public List<Book> getAllByAuthorsId(long id) {
		return bookRepo.findAllByAuthorsId(id);
	}

	@Override
	public List<BookInfoDTO> getBookInfoByAuthor(long id) {
		return bookRepo.getBookInfoByAuthor(id);
	}
	
	
}
