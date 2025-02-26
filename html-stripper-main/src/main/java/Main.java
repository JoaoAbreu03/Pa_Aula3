
    public class Main {

        public static void main(String[] args) {
            try {
                // T1
                FileReader t1 = new FileReader("html-stripper-main/index.html");

                Thread tt1 = new Thread(t1);
                tt1.start();


                //T3
                UserInputTheread t3 = new UserInputTheread();

                t3.start();

                tt1.join();
                t1.readFile();
                String file_content = t1.getContent();

                // T2
                HTMLStripper t2 = new HTMLStripper(file_content);
                t2.start();

                t2.join();
                t3.join();


                t2.stripHTML();
                String striped_content = t2.getStrippedContent();




                // T4
                EditContent t41 = new EditContent("<h1> " + t3.getTitele() + " </h1> <h1> " + t3.getDate() + " </h1>", striped_content, 1);
                t41.start();
                t41.join();

                //t41.addContent();

                striped_content = t41.getFile();
                // ---
                EditContent t42 = new EditContent("<img src=" + t3.getImageurl() + "></img>", striped_content, 0);
                t42.start();
                t42.join();

                //t42.addContent();

                striped_content = t42.getFile();
                // T5
                FileSaver t5 = new FileSaver("ficheiroHMTL.html", striped_content);

                t5.start();

                //t5.saveFile();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
