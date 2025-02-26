public class UserInputTheread extends Thread {

    private String titele;
    private String date;

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitele() {
        return titele;
    }

    public void setTitele(String titele) {
        this.titele = titele;
    }

    private String imageurl;

    @Override
    public void run() {
        // T3
        try {
            AskUser t31 = new AskUser("Introduza o título");
            t31.start();
            this.titele = t31.getAnswer();
            // ---
            AskUser t32 = new AskUser("Introduza a data");

            t31.join();

            t32.start();
            this. date = t32.getAnswer();
            // ---
            AskUser t33 = new AskUser("Introduza o caminho da imagem:");
            t32.join();
            t33.start();
            t33.join();
            this.imageurl = t33.getAnswer();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
