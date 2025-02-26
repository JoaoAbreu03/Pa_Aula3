import java.util.Scanner;

/**
 * The AskUser class represents the prompts, printed in the user's terminal, and the users answer to those prompts.
 * There is always a message and an answer associated with a prompt. The answer is saved after the user pressed the
 * <code>ENTER</code> key.
 */
public class AskUser extends Thread {

    private final String message;
    private String answer;

    /**
     * Constructs the prompt to be asked to the user and the respective answer.
     *
     * @param message the message to be printed in the user's terminal
     */
    public AskUser(String message) {
        this.message = message;
    }

    /**
     * Prints the message in the user's terminal and waits for the answer. The answer is then stored after the user
     * pressed the <code>ENTER</code> key. The answer can be retrieved using the method {@link AskUser#getAnswer()}.
     */
    public void askForText() {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        answer = sc.nextLine();
    }

    /**
     * Gets the answer the user gave to the message.
     *
     * @return the user's answer
     */
    public String getAnswer() {
        return answer;
    }

    @Override
    public void run() {

    }
}