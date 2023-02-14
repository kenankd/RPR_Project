package ba.unsa.etf.rpr;



import ba.unsa.etf.rpr.business.MovieManager;
import ba.unsa.etf.rpr.domain.Movie;
import net.bytebuddy.asm.Advice;
import org.apache.commons.cli.*;



import java.sql.Date;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

/**
 * @author Nermin Obucina
 * CLI (Command Line Interface) implementation in following class
 */
public class App {
    /**
     * Defining final variables to describe all code having options
     */
    private static final Option addMovie = new Option("m","add-movie",false, "Adding new movie to database");
    //private static final Option buyMovie = new Option("bm","buy-movie",false, "Adding new purchase to  database");
    private static final Option getMovies = new Option("getM", "get-movie",false, "Printing all movies from database");
    private static final Option getCustomers = new Option("getCust", "get-caustomers",false, "Printing all customers from database");
    private static final Option addCustomer = new Option("addC", "add-customer",false, "Adding new customer to database");
    //private static final Option sizeDefinition = new Option(null, "size", false,"Defining size for nes added clothing");
    //private static final Option priceDefinition = new Option(null, "price", false,"Defining price for nes added clothing");



    /**
     *
     * @param options
     *
     */
    public static void printFormattedOptions (Options options) {
        HelpFormatter helpFormatter = new HelpFormatter();
        PrintWriter printWriter = new PrintWriter(System.out);
        helpFormatter.printUsage(printWriter, 150, "java -jar Projekat-0.1.jar [option] 'something else if needed' ");
        helpFormatter.printOptions(printWriter, 150, options, 2, 7);
        printWriter.close();
    }
    public static Options addOptions() {
        Options options = new Options();
        options.addOption(addMovie);
        options.addOption(addCustomer);
        options.addOption(getCustomers);
        options.addOption(getMovies);
       // options.addOption(categoryDefinition);
        return options;
    }


    /**
     *
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
                System.out.println("No movies availaible");
            else
                for(Movie m : list)
                    System.out.println(m);

        }
        else{
            printFormattedOptions(options);
            System.exit(-1);
        }

    }
}
