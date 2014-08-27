package edu.eci.cosw.samples.test;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Test {

	public static void main(String[] args) throws ParseException {
		
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
            
		
            Session s=sf.openSession();
		
            Query q=s.createQuery("from Producto");
            
            System.out.println(q.list().get(0));
            
            
	}
	
	/**
	 * Hacer persistente un nuevo pedido, creado a partir del identificador de cliente dado, los identificadores
	 * de los productos, sus cantidades, y la fecha.
	 * @pre identificadorProductos.lenght==cantidades.lenght
	 * @param idCliente identificador del cliente que hace el pedido
	 * @param identificadoresProductos conjunto de identificadores de los productos que componen el pedido
	 * @param cantidades conjunto de cantidades de los productos pedidos. La cantidad i, ser� entonces, 
	 *        la cantidad asociada al producto i.
	 */
	public void registrarPedido(Session s, int idCliente, int[] identificadoresProductos, int[] cantidades, Date fecha){
		
	}
	
	/**
	 * Registrar un despacho de un pedido
	 * @param idPedido identificador del pedido ya existente
	 * @param idVehiculo identificador del veh�culo a asociar con el despacho
	 * @param qrCode flujo de bytes de la im�gen de c�digo QR generado para el despacho
	 */
	public void registrarDespacho(Session s, int idPedido, int idVehiculo, InputStream qrCode){
		
	}

	
	
}
