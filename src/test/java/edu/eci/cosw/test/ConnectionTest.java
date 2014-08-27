/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.eci.cosw.test;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hcadavid
 */
public class ConnectionTest {
    
    @Test
    public void connectionTest(){
        SessionFactory sf=null;
        try{
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            sf = configuration.buildSessionFactory(serviceRegistry);               
            Session s=sf.openSession();            
            s.createQuery("from Pedido").list().size();
        }
        catch (Throwable e){
            fail("Error en la configuración de la conexión:"+e.getLocalizedMessage());
        }
        finally{
            if (sf!=null){
                sf.close();
            }
        }
    }
    
}
