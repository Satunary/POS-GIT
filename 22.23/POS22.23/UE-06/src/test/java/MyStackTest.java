import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    @Test
    void push() {
        MyStack ms=new MyStack();
        String exp="5";

        ms.push(5);
        String actual=ms.toString();

        assertEquals(exp,actual);
    }

    @Test
    void pop() {
        MyStack ms=new MyStack();
        Object expected=ms.push(5);

        Object actual=ms.pop();
        assertEquals(expected,actual);
    }

    @Test
    void peek() {
        MyStack ms=new MyStack();
        Object exp=ms.push(5);


        Object actual=ms.peek();

        assertEquals(exp,actual);
    }

    @Test
    void size() {
        MyStack ms=new MyStack();
        ms.push(5);
        int value=ms.size();

        assertEquals(1,value);
    }

    @Test
    void testToString() {
        MyStack ms=new MyStack();
        String expect="5";

        ms.push(5);
        String actual=ms.toString();

        assertEquals(expect,actual);
    }
}