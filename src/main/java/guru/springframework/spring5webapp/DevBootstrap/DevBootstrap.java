package guru.springframework.spring5webapp.DevBootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private AuthorRepository aR;
	private BookRepository bR;
	
	
	public DevBootstrap(AuthorRepository aR, BookRepository bR) {
		this.aR = aR;
		this.bR = bR;
	}

	private void initData(){
		
		Author uvn = new Author("Niranjan", "UV");
		Book r31 = new Book("Route 31", "1234", "Sanatana");
		uvn.getBooks().add(r31);
		r31.getAuthors().add(uvn);
		
		aR.save(uvn);
		bR.save(r31);
		
		Author vishnu = new Author("Vishnu", "Reddy");
		Book kannada = new Book("Kavanagalu", "4567", "Sanatana");
		vishnu.getBooks().add(kannada);
		aR.save(vishnu);
		bR.save(kannada);
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshEvent) {
		// TODO Auto-generated method stub
		initData();		
	}
}
