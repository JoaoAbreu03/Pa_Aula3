import java.io.File;
import java.util.Scanner;

/**
 * The FileReader class implements a file reader. The file path is specified in the constructor. The file can be then
 * read using the method {@link FileReader#readFile()}.
 */
public class FileReader implements Runnable {


    private final String path;
    private String file_content;

    /**
     * Constructs the file reader with the path of the file to be read.
     *
     * @param path the path of the file to be read
     */
    public FileReader(String path) {
        this.path = path;
    }

    /**
     * Reads the file specified in the constructor with verbose.
     *
     * @return <code>true</code> if the file was read correctly; <code>false</code> otherwise.
     */
    public boolean readFile() {
        System.out.println(">>> Reading the file");
        File original = new File(path);
        Scanner reader;
        StringBuilder content = new StringBuilder();
        try {
            reader = new Scanner(original);
            while (reader.hasNextLine()) {
                String input = reader.nextLine();
                if (content.length() == 0) {
                    content = new StringBuilder(input);
                } else {
                    content.append("\n").append(input);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        System.out.println(">>> Done reading the file");
        file_content = content.toString();
        return true;
    }

    /**
     * Gets the content of the file or an empty string if the file was not read yet.
     *
     * @return the content of the file or an empty string
     */
    public String getContent() {
        return file_content;
    }

    @Override
    public void run() {

    }
}
