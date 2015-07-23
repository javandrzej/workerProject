import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertSame;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class MockitoTest
{
    Operation operation;
    public interface Operation
    {
        public int add(int a,int b);
        public int minus(int a,int b);
        public int multiply(int a,int b);
    }

    class MathOperation implements Operation
    {

        @Override
        public int add(int a, int b)
        {
            return 0;
        }

        @Override
        public int minus(int a, int b)
        {
            return 0;
        }

        @Override
        public int multiply(int a, int b)
        {
            return 0;
        }
    }

    @Before
    public void setUp() throws Exception
    {
        operation = mock(Operation.class);
    }

    @Test
    public void testAdd() throws Exception
    {
        when(operation.add(1,3)).thenReturn(4);
        assertSame(operation.add(1,3),4);
        verify(operation,times(1)).add(1,3);
    }

    @Test
    public void testMinus() throws Exception
    {
        when(operation.minus(10,6)).thenReturn(4);
        assertEquals(4,operation.minus(10,6));
        verify(operation,times(1)).minus(10,6);
    }

    @Test
    public void testMultiply() throws Exception
    {
        when(operation.multiply(anyInt(),eq(0))).thenReturn(0);
        TestCase.assertEquals(0,operation.multiply(4,0));
        TestCase.assertEquals(0,operation.multiply(114,0));
        TestCase.assertEquals(0,operation.multiply(-234,0));

    }
}
