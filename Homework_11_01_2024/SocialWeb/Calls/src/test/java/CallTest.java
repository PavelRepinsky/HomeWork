import org.junit.After;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;

public class CallTest {
    private CallsInterface callsInterface;

    @Test
    public void testStartCall() {

        callsInterface = mock(CallsInterface.class);
        callsInterface.startCall();

        Mockito.verify(callsInterface).startCall();

        System.out.println("Test passed!");
    }

    @Test
    public void testEndCall() {

        callsInterface = mock(CallsInterface.class);
        callsInterface.startCall();

        callsInterface.endCall();

        Mockito.verify(callsInterface).endCall();

        System.out.println("Test passed!");
    }

    @Test
    public void testAnswerCall() {

        String incomingCall = "There is an incoming Call! Please, answer!";

        callsInterface = mock(CallsInterface.class);
        callsInterface.answerCall();

        Mockito.verify(callsInterface).answerCall();

        System.out.println("Test passed!");
    }

    @Test
    public void testDropCall() {

        String incomingCall = "There is an incoming Call! Please, answer!";

        callsInterface = mock(CallsInterface.class);
        callsInterface.dropCall();

        Mockito.verify(callsInterface).dropCall();

        System.out.println("Test passed!");
    }

    @Test
    public void testHoldCall() {

        String incomingCall = "There is an incoming Call! Please, answer!";

        callsInterface = mock(CallsInterface.class);
        callsInterface.answerCall();

        callsInterface.holdCall();

        Mockito.verify(callsInterface).holdCall();

        System.out.println("Test passed!");
    }

    @Test
    public void testResumeCall() {

        String incomingCall = "There is an incoming Call! Please, answer!";

        callsInterface = mock(CallsInterface.class);
        callsInterface.answerCall();

        callsInterface.holdCall();

        callsInterface.resumeCall();

        Mockito.verify(callsInterface).resumeCall();

        System.out.println("Test passed!");
    }

    @Test
    public void testAddListenerToCall() {

        callsInterface = mock(CallsInterface.class);
        callsInterface.startCall();

        callsInterface.addListenerToCall();

        Mockito.verify(callsInterface).addListenerToCall();

        System.out.println("Test passed!");
    }
}
