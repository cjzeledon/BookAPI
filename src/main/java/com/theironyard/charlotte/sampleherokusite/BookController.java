package com.theironyard.charlotte.sampleherokusite;

import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.ArrayList;
import java.util.List;


@RestController
public class BookController {

    List<Book> books = new ArrayList<>();

    @CrossOrigin
    @RequestMapping(path = "/books", method = RequestMethod.GET)
    public List<Book> getBooks() {
//        Book greenEggsAndHam = new Book("1234","Green Eggs And Ham",
//                                        "Dr. Seuss!", true,
//                            "Awesome", true, 67 );
//        books.add(greenEggsAndHam);
        return books;
    }
    // {"isbn":"12345","title":"The Great Gatsomething","author":"yamama"}

//    @CrossOrigin(origins = {"http://thegoogs.com", "yahoo.com", "idk.com"})
    @CrossOrigin
    @RequestMapping(path = "/books", method = RequestMethod.POST)
    public void addBook(@RequestBody Book book) {
        books.add(book);
    }

    @CrossOrigin
    @RequestMapping(path = "/check_in/{index}", method = RequestMethod.PATCH)
    public void checkIn(@PathVariable("index") int index, Model model){
        books.get(index).setCheckedOut(false);
    }

    @CrossOrigin
    @RequestMapping(path = "/check_out/{index}", method = RequestMethod.PATCH)
    public void checkOut(@PathVariable("index") int index, Model model){
        books.get(index).setCheckedOut(true);
    }

}
