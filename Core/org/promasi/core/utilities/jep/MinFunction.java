package org.promasi.core.utilities.jep;


import java.util.Stack;

import org.nfunk.jep.ParseException;
import org.nfunk.jep.function.PostfixMathCommandI;


/**
 * Implements the Min function accepts 2 parameters and returns the min.
 * 
 * @author eddiefullmetal
 * 
 */
public class MinFunction
        implements PostfixMathCommandI
{

    @Override
    public boolean checkNumberOfParameters ( int n )
    {
        return n == 2;
    }

    @Override
    public int getNumberOfParameters ( )
    {
        return 2;
    }

    @Override
    public void run ( Stack stack )
            throws ParseException
    {
        double var1 = (Double) stack.pop( );
        double var2 = (Double) stack.pop( );
        stack.push( Math.min( var1, var2 ) );
    }

    @Override
    public void setCurNumberOfParameters ( int n )
    {
    }
}