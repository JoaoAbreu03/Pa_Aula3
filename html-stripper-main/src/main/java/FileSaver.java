import java.io.FileWriter;
import java.io.IOException;

/**
 * The FileSaver class implements a file saver. The content of the file and the path are specified in the constructor.
 * After the method {@link FileSaver#saveFile()} is called, the file with its contents is created in the specified
 * path.
 */
public class FileSaver {

    private final String path;
    private final String content;

    /**
     * Constructs the file saver with the path of the file and the contents to be stored in that file.
     *
     * @param path    the path in which the file will be saved
     * @param content the content to be stored in the file
     */
    public FileSaver(String path, String content) {
        this.path = path;
        this.content = content;
    }

    /**
     * Saves the file and the contents specified in the constructor with verbose.
     *
     * @return <code>true</code> if the file was created correctly; <code>false</code> otherwise.
     */
    public boolean saveFile() {
        System.out.println(">>> Saving the file");
        FileWriter file;
        try {
            file = new FileWriter(path);
            file.write(content);
            file.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


}
