import org.junit.Before;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ChatTest {

    @Before
    public void getMessages() {
        String message = "Messaga, Brat";

        chatInterface = mock(ChatInterface.class);
        when(chatInterface.getMessages()).thenReturn(message);
    }

    private ChatInterface chatInterface;

    @org.junit.Test
    public void testSendMessage() {
        String message = "Zdarova Bratan";

        chatInterface = mock(ChatInterface.class);
        when(chatInterface.sendAMessage(message)).thenReturn(message);

        assert(chatInterface.sendAMessage(message).equals(message));

        System.out.println("Test passed!");
    }

    @org.junit.Test
    public void testUpdateMessage() {
        String messageHi = "Zdarova Bratan";

        chatInterface = mock(ChatInterface.class);
        when(chatInterface.sendAMessage(messageHi)).thenReturn(messageHi);

        String messageBye = "Pakeda Bratan";

        chatInterface = mock(ChatInterface.class);
        when(chatInterface.updateMessage(messageBye)).thenReturn(messageBye);

        assert(chatInterface.updateMessage(messageBye).equals(messageBye));

        System.out.println("Test passed!");
    }

    @org.junit.Test
    public void testDeleteMessage() {
        String messageHi = "Zdarova Bratan";

        chatInterface = mock(ChatInterface.class);
        when(chatInterface.sendAMessage(messageHi)).thenReturn(messageHi);

        String message = "Delete Bratan";

        chatInterface = mock(ChatInterface.class);
        when(chatInterface.deleteMessage(message)).thenReturn(null);

        assert(chatInterface.deleteMessage(message) == null);

        System.out.println("Test passed!");
    }

    @org.junit.Test
    public void testGetMessages() {
        String message = "Brat";

        chatInterface = mock(ChatInterface.class);
        when(chatInterface.getMessages()).thenReturn(message);
        assert(chatInterface.getMessages().equals(message));

        System.out.println("Test passed!");
    }

    @org.junit.Test
    public void testResendMessage() {

        String message = "Bratan";

        chatInterface = mock(ChatInterface.class);
        when(chatInterface.resendMessage(message)).thenReturn(message);
        assert(chatInterface.resendMessage(message).equals(message));

        System.out.println("Test passed!");
    }

    @org.junit.Test
    public void testFindMessage() {
        String message = "Bratishka";

        chatInterface = mock(ChatInterface.class);
        when(chatInterface.findMessage(message)).thenReturn(message);
        assert(chatInterface.findMessage(message).equals(message));

        System.out.println("Test passed!");
    }
}
