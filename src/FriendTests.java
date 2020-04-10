import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FriendTests {

    private Friend f;

    @Before
    public void setUp() {
        f = new Friend();
    }

    @Test
    public void req1Test() {
        String nameStr = f.greet("Bob");
        Assert.assertEquals("Hello, Bob.", nameStr);
    }

    @Test
    public void req2Test() {
        String nullStr = f.greet(null);
        Assert.assertEquals("Hello, my friend.", nullStr);
        String emptyStr = f.greet("");
        Assert.assertEquals("Hello, my friend.", emptyStr);
        String noArgs = f.greet();
        Assert.assertEquals("Hello, my friend.", noArgs);
    }

    @Test
    public void req3Test() {
        String nameStr = f.greet("JERRY");
        Assert.assertEquals("HELLO JERRY!", nameStr);
    }

    @Test
    public void req4Test() {
        String nameStr1 = f.greet("Jill", "Jane");
        Assert.assertEquals("Hello, Jill and Jane.", nameStr1);
        String nameStr2 = f.greet("", "Jane");
        Assert.assertEquals("Hello, my friend and Jane.", nameStr2);
        String nameStr3 = f.greet("Jill", "");
        Assert.assertEquals("Hello, Jill and my friend.", nameStr3);
        String nameStr4 = f.greet(null, "Jane");
        Assert.assertEquals("Hello, my friend and Jane.", nameStr4);
        String nameStr5 = f.greet("Jill", null);
        Assert.assertEquals("Hello, Jill and my friend.", nameStr5);
        String nameStr6 = f.greet("JILL", "Jane");
        Assert.assertEquals("Hello, Jane. HELLO JILL!", nameStr6);
        String nameStr7 = f.greet("Jill", "JANE");
        Assert.assertEquals("Hello, Jill. HELLO JANE!", nameStr7);
    }

    @Test
    public void req5Test() {
        String nameStr1 = f.greet("Amy", "Brian", "Charlotte");
        Assert.assertEquals("Hello, Amy, Brian, and Charlotte. ", nameStr1);
        String nameStr2 = f.greet("Amy", "Brian", "Charlotte", "Chelsea", "Bruno");
        Assert.assertEquals("Hello, Amy, Brian, Charlotte, Chelsea, and Bruno. ", nameStr2);
    }

    @Test
    public void req6Test() {
        String nameStr1 = f.greet("Amy", "BRIAN");
        Assert.assertEquals("Hello, Amy. HELLO BRIAN!", nameStr1);
        String nameStr2 = f.greet("Amy", "BRIAN", "Charlotte");
        Assert.assertEquals("Hello, Amy and Charlotte. HELLO BRIAN! ", nameStr2);
        String nameStr3 = f.greet("AMY", "Brian", "Charlotte", "CHELSEA", "Bruno");
        Assert.assertEquals("Hello, Brian, Charlotte, and Bruno. HELLO AMY! HELLO CHELSEA! ", nameStr3);
        String nameStr4 = f.greet("AMY", "Brian", null, "Charlotte", "CHELSEA", "", "Bruno");
        Assert.assertEquals("Hello, Brian, my friend, Charlotte, my friend, and Bruno. HELLO AMY! HELLO CHELSEA! ", nameStr4);
        String nameStr5 = f.greet("", "BRIAN");
        Assert.assertEquals("Hello, my friend. HELLO BRIAN!", nameStr5);
        String nameStr6 = f.greet("BRIAN", null);
        Assert.assertEquals("Hello, my friend. HELLO BRIAN!", nameStr6);
    }

    @Test
    public void req7Test() {
        String nameStr1 = f.greet("Bob", "Charlie, Dianne");
        Assert.assertEquals("Hello, Bob, Charlie, and Dianne. ", nameStr1);
        String nameStr2 = f.greet("BOB", "Charlie, Dianne");
        Assert.assertEquals("Hello, Charlie and Dianne. HELLO BOB! ", nameStr2);
        String nameStr3 = f.greet("BOB", "CHARLIE, Dianne");
        Assert.assertEquals("Hello, Dianne. HELLO BOB! HELLO CHARLIE! ", nameStr3);
        String nameStr4 = f.greet("BOB", "CHARLIE, DIANNE");
        Assert.assertEquals("HELLO BOB! HELLO CHARLIE! HELLO DIANNE! ", nameStr4);
        String nameStr5 = f.greet("Bob", "Chelsea, Charlie, DIANNE", "Bruno");
        Assert.assertEquals("Hello, Bob, Chelsea, Charlie, and Bruno. HELLO DIANNE! ", nameStr5);
    }

    @Test
    public void req8Test() {
        String nameStr1 = f.greet("Bob", "\"Charlie, Dianne\"");
        Assert.assertEquals("Hello, Bob and Charlie, Dianne.", nameStr1);
        String nameStr2 = f.greet("BOB", "\"Charlie, Dianne\"");
        Assert.assertEquals("Hello, Charlie, Dianne. HELLO BOB!", nameStr2);
        String nameStr3 = f.greet("BOB", "\"CHARLIE, Dianne\"");
        Assert.assertEquals("Hello, CHARLIE, Dianne. HELLO BOB!", nameStr3);
        String nameStr4 = f.greet("BOB", "\"CHARLIE, DIANNE\"");
        Assert.assertEquals("HELLO BOB! HELLO CHARLIE, DIANNE!", nameStr4);
        String nameStr5 = f.greet("Bob", "\"Chelsea, Charlie, DIANNE\"", "Bruno", "NICO");
        Assert.assertEquals("Hello, Bob, Chelsea, Charlie, DIANNE, and Bruno. HELLO NICO! ", nameStr5);
    }
}
