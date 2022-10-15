/**
 * 
 */
package com.danni.projectspringdesktop.test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Properties;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.danni.projectspringdesktop.dao.DisqueraDAO;
import com.danni.projectspringdesktop.dao.impl.DisqueraDAOImpl;
/**
 * @author danni
 *clase de prueba Unitaria que permite realizar pruebas con el framework SPRING
 */
class SpringDesktopTest {
	@Test
	void testContext() {
		/*cargar atraves de una instancia
		 * ClassPath "buscara la ubicacion del la clase applicationContext.xml"*/
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		/*verificar que el contexto lleve informacion y este cargando*/
		assertNotNull(context);
		/*metodo que permitira utilizar un BEAN de ApplicationContext.xml*/
		DisqueraDAO disqueraDAO = (DisqueraDAO) context.getBean("disqueraDAO");
		assertNotNull(disqueraDAO);
		/*otro ejemplo con BEANs*/
		DisqueraDAO disqueraDAONuevo = (DisqueraDAO) context.getBean("disqueraDAO");
		/*ejemplos sinspring "utilizando new"*/
		DisqueraDAO disqueraDAOSinSpring = new DisqueraDAOImpl();
		DisqueraDAO disqueraDAOSinSpringNuevo =new DisqueraDAOImpl();
		/*Mensaje*/
		System.out.println("Contexto cargado exitosamente.");
		System.out.println(disqueraDAO);
		System.out.println(disqueraDAONuevo);
		/*mensaje */
		System.out.println(disqueraDAOSinSpring);
		System.out.println(disqueraDAOSinSpringNuevo);
		
		//::::::: PROPERTIES ::::::::::::::
		/*CONTEXT "objeto,, llamamos "properties""*/
		Properties properties = (Properties) context.getBean("properties");
		/*obtener la propiedad + get""permite obtener la clave"*/
		System.out.println(properties.get("spring-username")); 	
		
	}
}
