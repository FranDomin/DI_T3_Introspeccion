
package introspeccionmicontrol;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import miscontroles.MiControl;

public class IntrospeccionMiControl 
{
    public static void main(String[] args) 
    {
        MiControl micontrol = new MiControl();
        
        System.out.println("La clase a la que pertenece micontrol es: " + micontrol.getClass());
        
        Class c1 = micontrol.getClass();
        
        muestraLosCampos(c1);
        muestraLosConstructores(c1);
        muestraLosMetodos(c1);
                
              
    }   

    private static void muestraLosConstructores(Class c1) 
    {
        Constructor[] constructores = c1.getDeclaredConstructors();
        System.out.println("Los constructores de la clase son: ");
        
        for(Constructor c : constructores)
        {
            String nombre = c.getName();
            Class[] tipoParams = c.getParameterTypes();
            System.out.print(" " + Modifier.toString(c.getModifiers()));
            System.out.print(" " + nombre + " (");
            for(int i = 0; i < tipoParams.length; i++)
            {
                if(i > 0)
                    System.out.print(", ");
                System.out.println(tipoParams[i].getName());
            }
            System.out.println(")");
        }
    }

    private static void muestraLosMetodos(Class c1) 
    {
        Method[] metodos = c1.getDeclaredMethods();
        
        System.out.println("__METODOS__");
        
        for(Method m : metodos)
        {
            System.out.println(m.toGenericString());
        }
    }

    private static void muestraLosCampos(Class c1) 
    {
        Field[] atributos = c1.getDeclaredFields();
        
        System.out.println("__ATRIBUTOS__");
        
        for(Field f : atributos)
        {
            System.out.println(Modifier.toString(f.getModifiers()) + "   " + f.getType() + "   " + f.getName());
        }
    }
}
