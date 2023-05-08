import static org.junit.Assert.*;

import org.junit.*;

public class RectangleTest {

    Rectangle rectangle;

    @Before
    public void testRectangleCreation() throws RectangleException {
        rectangle = new Rectangle(6.0, 8.0);
        Assert.assertEquals(6.0, rectangle.getA(), 0.0);
        Assert.assertEquals(8.0, rectangle.getB(), 0.0);
    }

    @Test
    public void testInvalidRectangleCreation() {
        assertThrows(RectangleException.class, () -> new Rectangle(-6.0, 8.0));
    }

    @Test(expected = RectangleException.class)
    public void testAInvalid() throws RectangleException {
        Rectangle rect = new Rectangle(-3.0, 8.0);
    }

    @Test(expected = RectangleException.class)
    public void testBInvalid() throws RectangleException {
        Rectangle rect = new Rectangle(3.0, -8.0);
    }

    @Test
    public void getAreaTest() {
        assertEquals(48.0, rectangle.getArea(), 0.0);
    }

    @Test
    public void getPerimeterTest() {
        assertEquals(28.0, rectangle.getPerimeter(), 0.0);
    }

    @Test
    public void checkSquareTests() {
        assertFalse(rectangle.isSquare());

        rectangle.setA(4.0);
        rectangle.setB(4.0);
        assertTrue(rectangle.isSquare());
    }

    @Test
    public void mainTestFunction() {
        try {
            Main m = new Main();
            Main.main(new String[]{"33", "10"});
        } catch (Exception err) {
            fail("Error");
        }
    }
}
