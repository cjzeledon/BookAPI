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
    public void checkIn(@PathVariable("index") int index){
        books.get(index).setCheckedOut(false);
    }

    /*
    This is another way to patch information on a single book
    This will patch/update the entire object of a book
    The FrontEnd will be responsible for creating their own code to select a specific book to update on

    @CrossOrigin
    @RequestMapping(path = "/check_in", method = RequestMethod.PATCH)
    public void checkIn(@RequestBody Book book){
    book.setCheckedOut(false);
    }

    Then you can make a copy of the previous code with the RequestBody and set the check out to true
    */


    @CrossOrigin
    @RequestMapping(path = "/check_out/{index}", method = RequestMethod.PATCH)
    public void checkOut(@PathVariable("index") int index){
        books.get(index).setCheckedOut(true);
    }


    /*
    NOTE:

    If you are using the Postman to see how this works, you need to make sure you are using the appropriate request
    method such as GET, POST, PATCH, etc in accordance with the request mapping. Plus, since there is no actual
    form being utilized, you are requesting and sending information as json. Spring will receive it as json and then
    convert it to an object.

    So, when you are in "POST" method, make sure you are using "body" then use "raw" and "JSON".

    Since the checkIn and checkOut method uses the PATCH method with the PathVariable. So, in the Postman, you select
    the book base on the index and just "send". It will automatically update the CheckedOut field to either true or
    false base on which method you are using.


     */

}
