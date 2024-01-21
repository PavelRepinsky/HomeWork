public interface ChatInterface {
    public String sendAMessage(String message);

    public String updateMessage(String message);

    public String deleteMessage(String message);

    public String getMessages();

    public String resendMessage(String message);

    public String findMessage(String message);
}
