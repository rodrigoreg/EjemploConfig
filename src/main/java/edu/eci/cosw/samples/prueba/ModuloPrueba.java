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
            
            //Query q=s.createQuery("select distinct(desp.vehiculo) from Despacho as desp inner join desp.pedidos as p inner join p.detallesPedidos as dp    where dp.producto.idproducto=:idp");
                        
            Query q=s.createQuery("from Pedido p where p.idpedido=:idp");
            
            q.setInteger("idp", 10039);
            List l=q.list();
            
            Pedido p=(Pedido)l.get(0);
            
            s.close();
            
            //System.out.println(l.size());
            for (DetallePedido dp:p.getDetallesPedidos()){
                System.out.println(dp);
            }
            
            
            //for (Object o:l){
            //    System.out.println(o);
            //}
            
            //registrarPedido(s,999,new int[]{1,2,3,4},new int[]{3,2,4,3},d);
            
            //tx.commit();
            
            
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
            
            Cliente c=(Cliente)s.load(Cliente.class, idCliente);
            Pedido p=new Pedido(c,fecha);
            
            s.save(p);
            
            for (int i=0;i<identificadoresProductos.length;i++){
                Producto prod=(Producto)s.load(Producto.class, identificadoresProductos[i]);
                DetallePedidoId dpid=new DetallePedidoId(prod.getIdproducto(),p.getIdpedido());
                DetallePedido dp=new DetallePedido(dpid,prod,cantidades[i]);
                
                p.addDetallePedido(dp);
            }
            
            s.saveOrUpdate(p);
            
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
