import java.lang.reflect.*;
import java.util.Scanner;

public class EclipseLike {
	
	public static void main (String[] args) throws ClassNotFoundException{
		System.out.println("Enter a qualified class name:");
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		Class c = Class.forName(str);
		
		for (Field field: c.getFields()){
			if (!Modifier.isStatic(field.getModifiers()))
				System.out.println(field.getName() + ": " + field.getType() + 
						" - " + field.getDeclaringClass());
		}
		for (Method method : c.getMethods()){
			if (!Modifier.isStatic(method.getModifiers()))
				System.out.println("S:" + method.getName() + "(" + method.getParameterTypes() +
						" ): " + method.getReturnType() + " - " + method.getDeclaringClass());
		}
		for (Field field: c.getFields()){
			if (Modifier.isStatic(field.getModifiers()))
				System.out.println("S:" + field.getName() + ": " + field.getType() + 
						" - " + field.getDeclaringClass());
		}
		for (Method method : c.getMethods()){
			if (!Modifier.isStatic(method.getModifiers()))
				System.out.println("S:" + method.getName() + "(" + method.getParameterTypes() +
						" ): " + method.getReturnType() + " - " + method.getDeclaringClass());
		}
		
		
	}
}
