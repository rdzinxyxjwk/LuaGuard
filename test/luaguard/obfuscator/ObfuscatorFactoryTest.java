/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package luaguard.obfuscator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author jgs
 */
public class ObfuscatorFactoryTest {
    
    private ObfuscatorFactory factory;
    
    @Before
    public void setup() {
        factory = new ObfuscatorFactory();
    }
    
    @Test
    public void NullReturnTest() {
        Obfuscator obf = factory.constructObfuscator("Does not exist");
        Assert.assertNull("Non-null obfuscator", obf);
    }

    @Test
    public void IdentityObfuscatorTest() {
        Obfuscator obf = factory.constructObfuscator("none");
        Assert.assertTrue("Wrong obfuscator constructed", 
                IdentityObfuscator.class.equals(obf.getClass()));
    }
    
    @Test
    public void FunctionParameterObfuscatorTest() {
        Obfuscator obf = factory.constructObfuscator("fpo");
        Assert.assertTrue("Wrong obfuscator constructed", 
                FunctionParameterObfuscator.class.equals(obf.getClass()));
    }
    
    @Test
    public void ReturnValueObfuscatorTest() {
        Obfuscator obf = factory.constructObfuscator("rvo");
        Assert.assertTrue("Wrong obfuscator constructed", 
                ReturnValueObfuscator.class.equals(obf.getClass()));
    }
    
    @Test
    public void FunctionCallObfuscatorTest() {
        Obfuscator obf = factory.constructObfuscator("fco");
        Assert.assertTrue("Wrong obfuscator constructed", 
                FunctionCallObfuscator.class.equals(obf.getClass()));
    }
}
