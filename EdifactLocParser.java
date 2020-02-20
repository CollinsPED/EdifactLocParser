import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EdifactLocParser {

	public static void main (String[] args) throws IOException {

		// -- Read from the text file and save the edifact message as a String
        String ediString = new String(Files.readAllBytes(Paths.get("Edifact.txt")), StandardCharsets.UTF_8);

        // -- Split the message into segments using the single quote (') delimiter
        String[] segments = ediString.split("'");

        // -- Console output provides a description in a user friendly format
        System.out.println("\nThe LOC element values are :\n");

        // -- Iterate through the segments, we skip the zero element as this is the UNA line
        for (int a = 1; a < segments.length; a++)
        {            
            // -- Split the segment into elements using the plus (+) delimiter
            String[] elements = segments[a].split("\\+");

            // -- Parse out the LOC segments we are interested in
            if (elements[0].trim().equals("LOC"))
            {
                // -- Populate an array with the 2nd and 3rd elements of the LOC segment
                String [] locElements = new String[] { elements[1], elements[2]};

                // -- Console output formatting
                System.out.print(" -");

                // -- Print the values to the console
                for (String element : locElements)
                {
                    System.out.print(" " + element);
                }                

                // -- Console output formatting
                System.out.println();                
            }

        }
        System.out.println();
    }
}
