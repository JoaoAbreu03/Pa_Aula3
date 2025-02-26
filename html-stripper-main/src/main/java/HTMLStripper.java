/**
 * The HTMLStripper class implements the methods for stripping all the HTML tags from a string, transforming it into
 * plain text when the {@link HTMLStripper#stripHTML()} is called.
 */
public class HTMLStripper {

    private final String html_content;
    private final String scriptTagStart = "<script";
    private final String scriptTagEnd = "</script>";
    private String stripped_content;

    /**
     * Constructs the HTML tag stripper by specifying the content which the tags will be stripped.
     *
     * @param html the HTML content which the tags will be stripped
     */
    public HTMLStripper(String html) {
        this.html_content = html;
    }

    /**
     * Strips, with verbose, all the HTML tags from the HTML content specified in the constructor. The content between
     * <code>script</code> tags is ignored.
     */
    public void stripHTML() {
        System.out.println(">>> Removing the tags");
        StringBuilder parsed_content = new StringBuilder();
        for (int i = 0; i < html_content.length(); i++) {
            if (html_content.charAt(i) == '<') {
                if (html_content.startsWith(scriptTagStart, i)) {
                    i = html_content.indexOf(scriptTagEnd, i) + scriptTagEnd.length() - 1;
                } else {
                    i++;
                    while (html_content.charAt(i) != '>')
                        i++;
                }
            } else {
                parsed_content.append(html_content.charAt(i));
            }
        }
        System.out.println(">>> Done removing the tags");
        this.stripped_content = parsed_content.toString();
    }

    /**
     * Gets the content of the HTML string in plain text. Note that if the {@link HTMLStripper#stripHTML()} was not
     * called, an empty string will be returned.
     *
     * @return the plain text or an empty string
     */
    public String getStrippedContent() {
        return stripped_content;
    }

}