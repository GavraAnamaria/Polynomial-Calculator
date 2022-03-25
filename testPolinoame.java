
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class testPolinoame {
    Model m = new Model();

    @Test
    public void suma() throws Exception {
            m.setVal( "x^7-x^8+9x-14x^5-x^3+12x^6+6x-8", "x^5+5x^4+3x^5+3x^3-x^8-6x+8");
            assertEquals( m.suma().toString(),"-2x^8+x^7+12x^6-10x^5+5x^4+2x^3+9x");
    }

    @Test
    public void diferenta() throws Exception {
        m.setVal( "x^7-x^8+9x-14x^5-x^3+12x^6+6x-8", "x^5+5x^4+3x^5+3x^3-x^8-6x+8");
        assertEquals( m.diferenta().toString(),"+x^7+12x^6-18x^5-5x^4-4x^3+21x-16");
    }

    @Test
    public void produs() throws Exception {
        m.setVal( "x^7-x^8+9x-14x^5-x^3+12x^6+6x-8", "x^5+5x^4+3x^5+3x^3-x^8-6x+8");
        assertEquals("produs verificat", m.produs().toString(), "+x^16-x^15-12x^14+10x^13-x^12+51x^11+7x^10-43x^9-52x^8-69x^7+237x^6-69x^5+11x^4-32x^3-90x^2+168x-64");
    }

    @Test
    public void cat() throws Exception {
        m.setVal( "x^7-x^8+9x-14x^5-x^3+12x^6+6x-8", "x^5+5x^4+3x^5+3x^3-x^8-6x+8");
        assertEquals("cat verificat", m.cat().toString(), "+1");
    }

    @Test
    public void derivare() throws Exception {
        m.setVal( "x^7-x^8+9x-14x^5-x^3+12x^6+6x-8", "x^5+5x^4+3x^5+3x^3-x^8-6x+8");
        assertEquals("derivare verificata", m.derivare().toString(), "-8x^7+7x^6+72x^5-70x^4-3x^2+15");
    }

    @Test
    public void integrare() throws Exception {
        m.setVal("4x-16x^3+9x^2-15x^4+6","x^5+5x^4+3x^5+3x^3-x^8-6x+8");
        assertEquals("integrare verificata", m.integrare().toString_d(), "-3.0x^5-4.0x^4+3.0x^3+2.0x^2+6.0x");
    }

}
