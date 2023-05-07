import static org.junit.Assert.*;
import org.junit.*;

public class RectangleTest {

    Rectangle rectangle;

    @Before
    public void setUp() throws RectangleException {
        rectangle = new Rectangle(4.0, 6.0);
    }

    @Test
    public void testGetArea() {
        assertEquals(24.0, rectangle.getArea(), 0.001);
    }

    @Test
    public void testGetPerimeter() {
        assertEquals(20.0, rectangle.getPerimeter(), 0.001);
    }

    @Test
    public void testSetA() {
        rectangle.setA(8.0);
        assertEquals(8.0, rectangle.getA(), 0.001);
        assertEquals(48.0, rectangle.getArea(), 0.001);
        assertEquals(28.0, rectangle.getPerimeter(), 0.001);
    }

    @Test
    public void testSetB() {
        rectangle.setB(10.0);
        assertEquals(10.0, rectangle.getB(), 0.001);
        assertEquals(40.0, rectangle.getArea(), 0.001);
        assertEquals(28.0, rectangle.getPerimeter(), 0.001);
    }

    @Test
    public void testIsSquare() {
        assertFalse(rectangle.isSquare());
        rectangle.setA(5.0);
        rectangle.setB(5.0);
        assertTrue(rectangle.isSquare());
    }

    @Test(expected = RectangleException.class)
    public void testConstructorWithNegativeA() throws RectangleException {
        Rectangle rect = new Rectangle(-2.0, 6.0);
    }

    @Test(expected = RectangleException.class)
    public void testConstructorWithNegativeB() throws RectangleException {
        Rectangle rect = new Rectangle(8.0, -12.0);
    }

    @Test(expected = RectangleException.class)
    public void testConstructorWithNegativeBoth() throws RectangleException {
        Rectangle rect = new Rectangle(-5.0, -3.0);
    }

    @Test(expected = RectangleException.class)
    public void testConstructorWithZeroA() throws RectangleException {
        Rectangle rect = new Rectangle(0.0, 6.0);
    }

    @Test(expected = RectangleException.class)
    public void testConstructorWithZeroB() throws RectangleException {
        Rectangle rect = new Rectangle(8.0, 0.0);
    }

    @Test(expected = RectangleException.class)
    public void testConstructorWithZeroBoth() throws RectangleException {
        Rectangle rect = new Rectangle(0.0, 0.0);
    }
}
