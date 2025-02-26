public class Main {

    public static void main(String[] args) {

        // T1
        FileReader t1 = new FileReader("index.html");
        t1.readFile();
        String file_content = t1.getContent();
        // T2
        HTMLStripper t2 = new HTMLStripper(file_content);
        t2.stripHTML();
        String striped_content = t2.getStrippedContent();
        // T3
        AskUser t31 = new AskUser("Introduza o título");
        t31.askForText();
        String title = t31.getAnswer();
        // ---
        AskUser t32 = new AskUser("Introduza a data");
        t32.askForText();
        String date = t32.getAnswer();
        // ---
        AskUser t33 = new AskUser("Introduza o caminho da imagem:");
        t33.askForText();
        String image_url = t33.getAnswer();
        // T4
        EditContent t41 = new EditContent("<h1> " + title + " </h1> <h1> " + date + " </h1>", striped_content, 1);
        t41.addContent();
        striped_content = t41.getFile();
        // ---
        EditContent t42 = new EditContent("<img src=" + image_url + "></img>", striped_content, 0);
        t42.addContent();
        striped_content = t42.getFile();
        // T5
        FileSaver svt = new FileSaver("ficheiroHMTL.html", striped_content);
        svt.saveFile();

    }
}
