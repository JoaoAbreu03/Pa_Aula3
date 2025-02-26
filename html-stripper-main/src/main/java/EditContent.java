/**
 * The EditContent class contains the methods for editing the content of a string. The edits available are appending
 * (<code>0</code>) or prepending (<code>1</code>) strings to the original content.
 */
public class EditContent {

    private static final int START = 1;
    private static final int END = 0;
    private final String content;
    private final int type;
    private String file;


    /**
     * Constructs the string to be inserted, the original content and the required edit.
     *
     * @param content   the string to be appended or prepended to the original content
     * @param file      the original content to be edited
     * @param start_end <code>0</code> to append the string to the file; <code>1</code> to prepend the string to the
     *                  file
     */
    public EditContent(String content, String file, int start_end) {
        this.content = content;
        this.file = file;
        this.type = start_end;
    }

    /**
     * Edits the original content with the edit specified in the constructor.
     */
    public void addContent() {
        switch (type) {
            case START -> file = content + file;
            case END -> file = file + content;
        }
    }


    /**
     * Gets the content edited. Note that if the {@link EditContent#addContent()} was not called, the original content
     * is returned.
     *
     * @return the content edited or the original content
     */
    public String getFile() {
        return this.file;
    }


}