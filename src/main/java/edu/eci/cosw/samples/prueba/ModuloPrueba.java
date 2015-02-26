package edu.eci.cosw.samples.prueba;

import edu.eci.cosw.samples.model.Cliente;
import edu.eci.cosw.samples.model.DetallePedido;
import edu.eci.cosw.samples.model.DetallePedidoId;
import edu.eci.cosw.samples.model.Pedido;
import edu.eci.cosw.samples.model.Producto;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
/**
 * @autor Rodrigo
 * 
 **/
public class ModuloPrueba {

	public static void main(String[] args) throws ParseException {
		
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
            
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date d = sdf.parse("5/13/2030");
		
            Session s=sf.openSession();
	
            Transaction tx=s.beginTransaction();
            
            
            tx.commit();
            s.close();
            
            
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
	public static void registrarPedido(Session s, int idCliente, int[] identificadoresProductos, int[] cantidades, Date fecha){            
            
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
