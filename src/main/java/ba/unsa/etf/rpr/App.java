package ba.unsa.etf.rpr;



import ba.unsa.etf.rpr.business.CustomerManager;
import ba.unsa.etf.rpr.business.MovieManager;
import ba.unsa.etf.rpr.domain.Customer;
import ba.unsa.etf.rpr.domain.Movie;
import ba.unsa.etf.rpr.exceptions.MovieException;
import net.bytebuddy.asm.Advice;
import org.apache.commons.cli.*;



import java.sql.Date;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

/**
 * @author Kenan Dizdarevic
 * CLI (Command Line Interface) implementation in following class
 */
public class App {
    /**
     * Defining final variables to describe all code having options
     */
    private static final Option addMovie = new Option("addM","add-movie",false, "Adding new movie to database, parameters should go in this order : title,date,actor,price,length,genre");
    //private static final Option buyMovie = new Option("bm","buy-movie",false, "Adding new purchase to  database");
    private static final Option getMovies = new Option("getM", "get-movie",false, "Printing all movies from database");
    private static final Option getCustomers = new Option("getC", "get-customers",false, "Printing all customers from database");
    private static final Option addCustomer = new Option("addC", "add-customer",false, "Adding new customer to database");
    private static final Option nameDefinition = new Option(null, "name", false,"Defining name for customer");
    private static final Option surnameDefinition = new Option(null, "surname", false,"Defining surname for customer");
    private static final Option mailDefinition = new Option(null, "mail", false,"Defining mail for customer");
    private static final Option usernameDefinition = new Option(null, "username", false,"Defining username for customer");
    private static final Option pwDefinition = new Option(null, "pw", false,"Defining password for customer");
    private static final Option titleDefinition = new Option(null, "title", false,"Defining title of the movie");
    private static final Option dateDefinition = new Option(null, "date", false,"Defining release date of the movie, enter in this format \"dd/MM/yyyy\"");
    private static final Option actorDefinition = new Option(null, "actor", false,"Defining main actor of the movie");
    private static final Option priceDefinition = new Option(null, "price", false,"Defining price of the movie");
    private static final Option lengthDefinition = new Option(null, "length", false,"Defining length of the movie");
    private static final Option genreDefinition = new Option(null, "genre", false,"Defining genre of the movie");




    /**
     * Helping function which displays possible options for command line interface
     * @param options available options
     *
     */
    public static void printFormattedOptions (Options options) {
        HelpFormatter helpFormatter = new HelpFormatter();
        PrintWriter printWriter = new PrintWriter(System.out);
        helpFormatter.printUsage(printWriter, 150, "java -jar Projekat-0.1-jar-with-dependencies.jar [option] 'something else if needed' ");
        helpFormatter.printOptions(printWriter, 150, options, 2, 7);
        printWriter.close();
    }
    public static Options addOptions() {
        Options options = new Options();
        options.addOption(addMovie);
        options.addOption(addCustomer);
        options.addOption(getCustomers);
        options.addOption(getMovies);
        options.addOption(nameDefinition);
        options.addOption(surnameDefinition);
        options.addOption(mailDefinition);
        options.addOption(usernameDefinition);
        options.addOption(pwDefinition);
        options.addOption(titleDefinition);
        options.addOption(dateDefinition);
        options.addOption(actorDefinition);
        options.addOption(priceDefinition);
        options.addOption(lengthDefinition);
        options.addOption(genreDefinition);
        return options;
    }


    /**
     * Main function which controls the Command Line Interface
     * @param args
     * @throws Exception
     */

    public static void main(String[] args) throws Exception {
        Options options = addOptions();
        CommandLineParser commandLineParser = new DefaultParser();
        CommandLine cl =commandLineParser.parse(options,args);
        if(cl.hasOption(getMovies.getOpt()) || cl.hasOption(getMovies.getLongOpt())){
            MovieManager movieManager = new MovieManager();
            List<Movie> list = movieManager.getAll();
            if(list==null)
                System.out.println("No movies available");
            else
                for(Movie m : list)
                    System.out.println(m);
        }
        else if(cl.hasOption(getCustomers.getOpt()) || cl.hasOption(getCustomers.getLongOpt())){
            CustomerManager customerManager = new CustomerManager();
            List<Customer> customers = customerManager.getAll();
            if(customers == null) System.out.println("No customers found in database");
            else
                for(Customer c : customers) System.out.println(c);
        }
        else if((cl.hasOption(addCustomer.getOpt()) || cl.hasOption(addCustomer.getLongOpt())) && cl.hasOption(nameDefinition.getLongOpt()) && cl.hasOption(surnameDefinition.getLongOpt())
        && cl.hasOption(mailDefinition.getLongOpt()) && cl.hasOption(surnameDefinition.getLongOpt()) && cl.hasOption(pwDefinition.getLongOpt())){
            CustomerManager customerManager = new CustomerManager();
            Customer customer = new Customer();
            customer.setName(cl.getArgList().get(0));
            customer.setSurname(cl.getArgList().get(1));
            customer.setMail(cl.getArgList().get(2));
            customer.setUsername(cl.getArgList().get(3));
            customer.setPw(cl.getArgList().get(4));
            try{
                customerManager.add(customer);
                System.out.println("Customer successfully added to database!");
            } catch (MovieException e) {
                System.out.println("Error, customer not added to database!");
            }
        }
        else if((cl.hasOption(addMovie.getOpt()) || cl.hasOption(addMovie.getLongOpt())) && cl.hasOption(titleDefinition.getLongOpt()) && cl.hasOption(dateDefinition.getLongOpt()) &&
        cl.hasOption(actorDefinition.getLongOpt())&& cl.hasOption(priceDefinition.getLongOpt()) && cl.hasOption(lengthDefinition.getLongOpt()) && cl.hasOption(genreDefinition.getLongOpt())){
            MovieManager movieManager = new MovieManager();
            Movie movie = new Movie();
            movie.setTitle(cl.getArgList().get(0));
            movie.setRelease_date(new SimpleDateFormat("dd/MM/yyyy").parse(cl.getArgList().get(1)));
            movie.setMain_actor(cl.getArgList().get(2));
            movie.setPrice(Double.parseDouble(cl.getArgList().get(3)));
            movie.setLength(Integer.parseInt(cl.getArgList().get(4)));
            movie.setGenre(cl.getArgList().get(5));
            try{
                movieManager.add(movie);
                System.out.println("Movie successfully added to database!");
            } catch (MovieException e) {
                System.out.println("Error, movie not added to database!");
            }
        }
        else{
            printFormattedOptions(options);
            System.exit(-1);
        }

    }
}
